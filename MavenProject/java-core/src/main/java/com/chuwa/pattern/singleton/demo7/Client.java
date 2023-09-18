package com.chuwa.pattern.singleton.demo7;

import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //writeObject2File();
        readObjectFromFile();
        readObjectFromFile();
    }

    // Read data(instance) from a file
    public static void readObjectFromFile() throws IOException, ClassNotFoundException {
        // Create instance of input stream
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/qrin/Study/Chuwa/Basic/Assignment/Chuwa0910/MavenProject/java-core/src/main/java/com/chuwa/pattern/singleton/demo7/a.txt"));
        // Read instance
        Singleton instance = (Singleton) ois.readObject();

        System.out.println(instance);
        // Relaease resource
        ois.close();
    }

    // Write data(instance) to a file
    public static void writeObject2File() throws IOException {
        // Get instance of Singleton
        Singleton instance = Singleton.getInstance();
        // Create instance of output stream
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/qrin/Study/Chuwa/Basic/Assignment/Chuwa0910/MavenProject/java-core/src/main/java/com/chuwa/pattern/singleton/demo7/a.txt"));
        // Write instance
        oos.writeObject(instance);
        // Release resource
        oos.close();
    }
}
