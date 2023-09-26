package com.chuwa.shawnlearning.core;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

public class LiJiaQi {
    private final Map<String, Object> instances = new HashMap<>();
    public LiJiaQi(Class<?> clazz) {
        var loader = Thread.currentThread().getContextClassLoader();
        var componentScan = (BaoGuang)clazz.getAnnotation(BaoGuang.class);
        var packageName = componentScan.value();
        var packagePath = packageName.replace(".", "/");
        File file = new File(Objects.requireNonNull(loader.getResource(packagePath)).getFile());
        for (var f : Objects.requireNonNull(file.listFiles())) {
            if (f.getName().endsWith(".class")) {
                var className = packageName + "." + f.getName().replace(".class", "");
                try {
                    var cls = loader.loadClass(className);
                    if (cls.isAnnotationPresent(AnPaiZhiBo.class)) {
                        var instance = createOrGetHuaXiZi(cls.getName(), cls);
                        System.out.println(instance);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for(var instance: instances.values()){
            gongZiMeiZhang(instance);
        }
    }

    public <T> void gongZiMeiZhang(T instance){
        for(var field: instance.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(NuLiGongZuo.class)){
                if(field.getType().isArray()){
                    List<Object> params = new ArrayList<>();
                    for(var huaxizi: instances.values()){
                        if(field.getType().getComponentType().isAssignableFrom(huaxizi.getClass())){
                            params.add(huaxizi);
                        }
                    }

                    try {
                        field.setAccessible(true);
                        System.out.println(Arrays.toString(params.toArray()));
                        Object array = Array.newInstance(field.getType().getComponentType(), params.size());
                        for (int i = 0; i < params.size(); i++) {
                            Array.set(array, i, params.get(i));
                        }
                        field.set(instance, array);
                        field.setAccessible(false);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Object createOrGetHuaXiZi(String name, Class<?> clazz ) throws NoSuchMethodException {
        if(instances.containsKey(name)) {
           return instances.get(name);
        }
        for(var constructor: clazz.getConstructors()) {
            List<Object> params = new ArrayList<>();
            for (var p : constructor.getParameters()) {
                var injected = (JingHuo) p.getAnnotation(JingHuo.class);
                if (injected != null) {
                    var instance = createOrGetHuaXiZi(p.getType().getName(), p.getType());
                    params.add(instance);
                }
            }
            try {
                var instance = constructor.newInstance(params.toArray());
                instances.put(name, instance);
                return instance;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instances.get(name);

    }

    public Object daiHuo(String name) {
        return instances.get(name);
    }
}
