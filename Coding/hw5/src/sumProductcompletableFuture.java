import java.util.concurrent.CompletableFuture;

public class sumProductcompletableFuture {
    //Write a simple program that
    // uses CompletableFuture to asynchronously get the sum and product of two integers,
    // and print the results.
    public static void main(String[] args) throws Exception {

        CompletableFuture<double[]> cf = CompletableFuture.supplyAsync(sumProductcompletableFuture::sumProduct);
        cf.thenAcceptAsync(
                (result)->
               {System.out.println("a: "+result[0]+"\tb: "+result[1]+"\tsum: "+result[2]+"\tproduct: "+result[3]);}
        );

        cf.exceptionally((e)->{
            e.printStackTrace();
            return null;
        });

        System.out.println("over");
        Thread.sleep(100);

    }

    public static double[] sumProduct(){
        Double a = Math.random()*100;
        Double b = Math.random()*30;
        return new double[]{a,b,a+b, a*b};
    }



}
