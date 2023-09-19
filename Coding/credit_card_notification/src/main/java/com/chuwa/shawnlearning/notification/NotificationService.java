package com.chuwa.shawnlearning.notification;

import com.chuwa.shawnlearning.core.JingHuo;
import com.chuwa.shawnlearning.core.AnPaiZhiBo;
import com.chuwa.shawnlearning.core.NuLiGongZuo;
import com.chuwa.shawnlearning.exception.NotificationPreferenceNotMatched;
import com.chuwa.shawnlearning.template.UserTemplateEngine;
import com.chuwa.shawnlearning.user.User;

import java.util.ArrayList;
import java.util.List;

@AnPaiZhiBo
public class NotificationService {
    private final UserTemplateEngine templateEngine;
    @NuLiGongZuo
    private MessageTunnel[] messageTunnels;

    private final List<User> users = new ArrayList<>();
    public NotificationService( @JingHuo UserTemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void broadcast(String message){
        for (User user : users) {
            String content = templateEngine.render(message, user);
            for(var messageTunnel : messageTunnels){
                if(messageTunnel.support(user.getPreference())){
                    try {
                        messageTunnel.send(content, user);
                    } catch (NotificationPreferenceNotMatched e) {
                        System.out.println("Notification preference not matched: " + e.getMessage());
                    } catch (Exception e){
                        System.out.println("Exception caught: " + e.getMessage());
                    }
                    break;
                }
            }
        }
    }
}
