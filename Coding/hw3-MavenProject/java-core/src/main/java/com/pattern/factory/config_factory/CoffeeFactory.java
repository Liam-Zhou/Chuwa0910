package com.pattern.factory.config_factory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class CoffeeFactory {

    //加载配置文件，获取配置文件中配置的全类名，并创建该类的对象进行存储
    private static HashMap<String,Coffee> map = new HashMap<>();
    //加载配置文件，只需要加载一次
    static {
        // 创建Properties对象
        Properties p = new Properties();
        //调用p对象的load方法，进行配置文件的加载
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            p.load(is);
            // 从p集合中全类名，并且创建对象
            //遍历Properties集合对象
            Set<Object> keys = p.keySet();
            for (Object key : keys) {
                //根据键获取值（全类名）
                String className = p.getProperty((String) key);
                //获取字节码对象 通过反射创建对象
                Class clazz = Class.forName(className);
                Coffee obj = (Coffee) clazz.newInstance();

                //将名称和对象存储到容器中
                map.put((String) key, obj);
            }
        } catch(Exception e){
                e.printStackTrace();
        }
    }

    public static Coffee createCoffee(String name) {
        return map.get(name);
    }
}
