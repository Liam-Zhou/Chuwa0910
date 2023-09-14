// Encapsulation: Wrapping data and methods into a single unit (class)

class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Polymorphism: The ability of objects of different classes to respond to the same method name

class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
}

// Inheritance: Creating a new class based on an existing class (subclass)

class Student extends Person {
    private int studentId;

    public Student(String name, int studentId) {
        setName(name);
        this.studentId = studentId;
    }
}

public class hw2_q1 {
    public static void main(String[] args) {
        // Demonstrate Encapsulation
        Person person = new Person();
        person.setName("Alice");
        System.out.println("Person's Name: " + person.getName());

        // Demonstrate Polymorphism
        Animal animal1 = new Animal();
        Animal animal2 = new Dog();

        animal1.makeSound(); // Output: Some generic animal sound
        animal2.makeSound(); // Output: Bark!

        // Demonstrate Inheritance
        Student student = new Student("Bob", 12345);
        System.out.println("Student's Name: " + student.getName());
    }
}

