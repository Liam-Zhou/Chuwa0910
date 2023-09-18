package org.example.pattern;


import org.example.pattern.FactoryObject.OGobject;
import org.example.pattern.FactoryObject.object1;
import org.example.pattern.FactoryObject.object2;

public class SimpleFactory {

    public OGobject getObject(String indicate) throws Exception {
        if(indicate.equals("object1")) return new object1();
        else if(indicate.equals("object2")) return new object2();
        else {
            throw new Exception();
        }
    }
}
