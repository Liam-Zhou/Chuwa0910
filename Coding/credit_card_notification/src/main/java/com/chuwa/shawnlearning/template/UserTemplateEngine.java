package com.chuwa.shawnlearning.template;

import com.chuwa.shawnlearning.user.User;

public class UserTemplateEngine {

    private String template;
    public void setTemplate(String template) {
        this.template = template;
    }
    public String render(String content, User data) {
        var userPart = template.replaceAll("\\{\\{firstName}}", data.getFirstName());
        userPart = userPart.replaceAll("\\{\\{content}}", content);
        return userPart;

    }
}
