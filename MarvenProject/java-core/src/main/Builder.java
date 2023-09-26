public class Builder{

    private String HDD;
    private String RAM;

    boolean GraphicCard;
    boolean Wifi;

    private Builder(ComputerBuilder builder){
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;

        this.GraphicCard = builder.GraphicCard;
        this.Wifi = builder.Wifi;
    }

    public String GetHDD(){
        return HDD;
    }

    public String GetRAM(){
        return RAM;
    }

    public boolean GetGraphicCard(){
        return GraphicCard;
    }

    public boolean GetWifi(){
        return Wifi;
    }



    public static class ComputerBuilder {


        private String HDD;
        private String RAM;

        boolean GraphicCard;
        boolean Wifi;

        public ComputerBuilder(String hdd, String ram){
            this.HDD = hdd;
            this.RAM = ram;

        }

        public ComputerBuilder setGraphicCard(boolean GraphicCard){
            this.GraphicCard = GraphicCard;
            return this;
        }

        public ComputerBuilder SetWifi(boolean Wifi){
            this.Wifi = Wifi;
            return this;
        }

        public Builder build(){
            return new Builder(this);
        }

    
        
    }


    public static void main(String []args){


        Builder GamingBuilder = new Builder.ComputerBuilder("1T", "32GB")
                                .setGraphicCard(true)
                                .SetWifi(true)
                                .build();
        Builder OfficeBuilder = new Builder.ComputerBuilder("256GB", "8GB")
                                .setGraphicCard(false)
                                .SetWifi(false)
                                .build();

        System.out.println("Gaming Builder:" + GamingBuilder.GetHDD() +" "+ GamingBuilder.GetRAM() +" "+ GamingBuilder.GraphicCard+ " " + GamingBuilder.GetWifi());
        System.out.println("Office Builder:" + OfficeBuilder.GetHDD()+" "+OfficeBuilder.GetRAM()+" "+OfficeBuilder.GetGraphicCard()+" "+OfficeBuilder.GetWifi());

    }









}