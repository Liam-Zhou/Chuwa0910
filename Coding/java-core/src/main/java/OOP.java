import org.w3c.dom.ls.LSOutput;

public class OOP {

    public static void main(String[] args) {
        //Encapsulation
        Person a = new Student("Zhengyi", 25, "male", 1234, 5678);

        //Polymorphism
        System.out.println(a.role());
        System.out.println(((Student)a).role());
    }

}

class Person {
    private String name;
    private Integer age;
    private String gender;
    private Integer id;

    Person() {}

    Person(String name, Integer age, String gender, Integer id) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Integer getId() {
        return id;
    }

    public String role() {
        return "person";
    }
}

//Inheritance
class Student extends Person {
    private Integer studentId;
    Student(String name, Integer age, String gender, Integer id, Integer studentId) {
        super(name, age, gender, id);
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    @Override
    public String role() {
        return "student";
    }
}
