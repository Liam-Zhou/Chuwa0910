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

public class Poly {
    public static void main(String[] args) {
        Animal myPet = new Dog(); // Polymorphism
        myPet.makeSound(); // Output: Bark!
    }
}
