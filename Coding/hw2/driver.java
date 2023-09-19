public class driver {
    //test
    // Driver: Vehicle, name, age, address, credit card number
    Vehicle car;
    String name;
    String address;
    int credit;
    int age;

    public driver(Vehicle car, String name) {
        this.car = car;
        this.name = name;
    }

    public Vehicle getCar() {
        return car;
    }

    public void setCar(Vehicle car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
