public class User{
    private String name;

    private notificationType t;

    public User(String name){
        this.name = name;
    }

    public notificationType getType(){
        return t;
    }


    public void setNotificationType(notificationType t){
        this.t = t;
    }


    public String getName(){
        return this.name;
    }

    public void sendMessage(Message m){
        System.out.println("Send To: "+ this.getName());
        System.out.println("Send Type: "+ this.getType());
        System.out.println("Message Content: "+ m.getMessage());
        System.out.println();
    }


}
