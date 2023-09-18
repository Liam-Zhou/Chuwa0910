import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        User usr1 = new User("Jake");
        User usr2 = new User("Alice");
        User usr3 = new User("Bob");
        usr1.setNotificationType(notificationType.EMAIL);
        usr2.setNotificationType(notificationType.WHATSAPP);
        usr3.setNotificationType(notificationType.SMS);

        List<User> userList = new ArrayList<>();
        userList.add(usr1);
        userList.add(usr2);
        userList.add(usr3);

        for(User usr: userList){
            String message = "Hey "+ usr.getName()+", " +
                    "you have successfully registered to add and here is your , please use this for \n" +
                    "future references.";
            Message msg = new Message(usr, message);
            usr.sendMessage(msg);
        }

        //Send To: Jake
        //Send Type: EMAIL
        //Message Content: Hey Jake, you have successfully registered to add and here is your , please use this for
        //future references.
        //
        //Send To: Alice
        //Send Type: WHATSAPP
        //Message Content: Hey Alice, you have successfully registered to add and here is your , please use this for
        //future references.
        //
        //Send To: Bob
        //Send Type: SMS
        //Message Content: Hey Bob, you have successfully registered to add and here is your , please use this for
        //future references.

        //Broadcast
        for(User usr: userList){
            String message = "40% off when you buy Popeyes between 06/13 - 06/19";
            Message msg = new Message(usr, message);
            usr.sendMessage(msg);
        }

        //Send To: Jake
        //Send Type: EMAIL
        //Message Content: 40% off when you buy Popeyes between 06/13 - 06/19
        //
        //Send To: Alice
        //Send Type: WHATSAPP
        //Message Content: 40% off when you buy Popeyes between 06/13 - 06/19
        //
        //Send To: Bob
        //Send Type: SMS
        //Message Content: 40% off when you buy Popeyes between 06/13 - 06/19











    }
}