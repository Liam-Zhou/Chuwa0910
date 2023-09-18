package org.example.USER;

public abstract class abUser {

    protected String user;
    protected String PreferType;
    protected String SMS;
    protected String Email;
    protected String WhatsApp;

    public abstract void note(String message);

    public void RegisterNote(String message) {
        System.out.printf("Hey %s, you have successfully registered to add and here is your , please use this for future references\n",this.user);
    }

}
