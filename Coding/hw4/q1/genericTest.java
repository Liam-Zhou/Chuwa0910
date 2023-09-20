public class genericTest{
    public static void main(String[] args) {
        genericClass<Integer> o1 = new genericClass<>(5);

        genericClass<Double> o2 = new genericClass<>(13.14);

        genericClass<String> o3 = new genericClass<>("hello world");
        System.out.println(o1.getObject());
    }
}
