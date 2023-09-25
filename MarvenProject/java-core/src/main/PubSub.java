import java.io.*;
import java.util.*;
import java.util.concurrent.Flow.Publisher;




interface Sub{

    public void update(String news);

} 


class Publisher{

    List <Sub> subs = new ArrayList<>(0);

    public void addSub(Sub sub){
        subs.add(sub);
    }

    public void removeSub(Sub sub){
        subs.remove(sub);
    }

    public void publishNews(String news){
        for(Sub sub:subs)
            sub.update(news);
    }



}

class Reader implements Sub{

    private String name;

    public Reader(String name){
        this.name = name;
    }

    @Override
    public void update(String news){
        System.out.println(name + " Receive news: " + news);
    }


}






public class PubSub {

    public static void main(String []args){
        Publisher agent = new Publisher();

        Reader darren = new Reader("Darren");
        Reader john = new Reader("John");

        agent.addSub(john);
        agent.addSub(darren);

        agent.publishNews("On sale!");

        agent.removeSub(john);

        agent.publishNews("Go Laker!");


    }
    
}
