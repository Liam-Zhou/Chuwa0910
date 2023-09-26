public class Factory {
    
    public interface Animals{
        public String sound();
    }

    public static class dog implements Animals{
        @Override
        public String sound(){
            return "Wang";
        }
    }

    public static class cat implements Animals{
        @Override
        public String sound(){
            return "Miao";
        }
    } 

    public static class wolf implements Animals{
        @Override
        public String sound(){
            return "Wow";
        }
    }  


    public static class AnimalsFactory{
        
        public static Animals getAnimals(String Animalstype){
            if(Animalstype==null)
                return null;
            
            if(Animalstype.equalsIgnoreCase("dog"))
                return new dog();
            
            if(Animalstype.equalsIgnoreCase("cat"))
                return new cat();

            if(Animalstype.equalsIgnoreCase("wolf"))
                return new wolf();

            return null;

        }
    }

    public static void main(String []args){

        Animals dog = AnimalsFactory.getAnimals("dog");
        System.out.println(dog.sound());

        Animals cat = AnimalsFactory.getAnimals("cat");
        System.out.println(cat.sound());

        Animals wolf = AnimalsFactory.getAnimals("wolf");
        System.out.println(wolf.sound());




    }

}
