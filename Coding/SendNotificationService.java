import java.util.List;

public interface SendNotificationService {
    public void sendNotification(User user, Notification notification);
    public void sendBoradcast(List<User> users, Notification notification);

    public void sendNotificationByEmail(User user, Notification notification);

    public void sendNotificationBySMS(User user, Notification notification);

    public void sendNotificationByWhatapps(User user, Notification notification);

}
