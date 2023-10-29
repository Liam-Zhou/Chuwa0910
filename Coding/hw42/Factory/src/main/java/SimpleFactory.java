import FactoryObject.OGobject;
import FactoryObject.object1;
import FactoryObject.object2;

public class SimpleFactory {
    public OGobject getObject(String indicate) throws Exception {
        if(indicate.equals("object1")) return new object1();
        else if(indicate.equals("object2")) return new object2();
        else {
            throw new Exception();
        }
    }
}
