import java.util.List;
import java.util.logging.Logger;

public class SendNotificationServiceImpl implements SendNotificationService{
    @Override
    public void sendNotification(User user, Notification notification) {

        try {
            if(user.getDeliveryPefer()==null)throw new NullPointerException();

            if(user.getDeliveryPefer().equals("Email")){
                sendNotificationByEmail(user,notification);
            }else if(user.getDeliveryPefer().equals("SMS")){
                sendNotificationBySMS(user,notification);
            }else{
                sendNotificationByWhatapps(user,notification);
            }

        } catch (NullPointerException e) {
            Logger.getLogger("User perfer notificaton is empty. Please check!");
            e.printStackTrace();
        }
    }

    @Override
    public void sendBoradcast(List<User> users, Notification notification) {
        for (User user:users){
            sendNotification(user,notification);
        }
    }

    @Override
    public void sendNotificationByEmail(User user, Notification notification) {
        //call email interface
    }

    @Override
    public void sendNotificationBySMS(User user, Notification notification) {
        //call SMS interface
    }

    @Override
    public void sendNotificationByWhatapps(User user, Notification notification) {
        //call SMS interface
    }
}
