class MyStudent {
    private String name; // Encapsulated attribute

    // Constructor to initialize the name
    public MyStudent(String name) {
        this.name = name;
    }

    // Getter method to retrieve the name
    public String getName() {
        return name;
    }

    // Setter method to update the name
    public void setName(String name) {
        this.name = name;
    }
}

public class Student {
    public static void main(String[] args) {
        // Create a MyStudent object and initialize it
        MyStudent student = new MyStudent("Alice");

        // Get the name using the getter method
        String studentName = student.getName();
        System.out.println("Student's Name: " + studentName);

        // Update the name using the setter method
        student.setName("Bob");
        studentName = student.getName();
        System.out.println("Updated Student's Name: " + studentName);
    }
}




