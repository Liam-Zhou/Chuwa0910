package com.chuwa.shawnlearning;

import com.chuwa.shawnlearning.core.LiJiaQi;
import com.chuwa.shawnlearning.core.BaoGuang;
import com.chuwa.shawnlearning.notification.NotificationService;
import com.chuwa.shawnlearning.template.UserTemplateEngine;
import com.chuwa.shawnlearning.user.NotificationPreference;
import com.chuwa.shawnlearning.user.User;

@BaoGuang("com.chuwa.shawnlearning.notification")
public class Main {
    public static void main(String[] args) {
        LiJiaQi liJiaQi = new LiJiaQi(Main.class);
        var notificationService = (NotificationService) liJiaQi.daiHuo("com.chuwa.shawnlearning.notification.NotificationService");
        var userTemplateEngine = (UserTemplateEngine) liJiaQi.daiHuo("com.chuwa.shawnlearning.template.UserTemplateEngine");
        userTemplateEngine.setTemplate("""
                Hey {{firstName}}, you have successfully registered to add and here is your <{{content}}>, please use this for future references.""");
        User user_a = new User("Shawn a", "aaa", "", NotificationPreference.EMAIL);
        User user_b = new User("Shawn b", "bbb", "", NotificationPreference.SMS);
        notificationService.addUser(user_a);
        notificationService.addUser(user_b);
        notificationService.broadcast("40% off when you buy Popeyes between 06/13 - 06/19");
    }
}