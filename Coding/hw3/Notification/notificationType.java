public enum notificationType {
    SMS(1),
    EMAIL(2),
    WHATSAPP(3);

    private int value;

    private notificationType(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
