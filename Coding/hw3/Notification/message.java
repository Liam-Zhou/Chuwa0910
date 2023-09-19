public class Message{
    String message;

    User usr;

    public  Message(){

    }
    public Message(User usr, String message){
        this.usr = usr;
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
