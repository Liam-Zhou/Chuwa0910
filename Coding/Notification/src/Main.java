public class Main {
    public static void main(String[] args) {

        User userA = new User("Yuhang", "EMAIL", "song2392823910@email.com", "8182723620");

        try {
            NotificationModule.notifyUser(userA, "Hey " + userA.getFirstName() + ", you have successfully registered. Please use this for future references.");
        } catch (NotificationNotFoundException e) {
            System.err.println(e.getMessage());
        }

        // Example to broadcast a public notification (just a demonstration for one user here)
        NotificationModule.notifyUser(userA, "40% off when you buy Popeyes between 06/13 - 06/19");
    }
}