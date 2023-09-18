public class Main {
    public static void main(String[] args) {
        Singleton instance_1 = Singleton.INSTANCE;
        Singleton instance_2 = Singleton.INSTANCE;

        System.out.println(instance_1 == instance_2);
    }
}