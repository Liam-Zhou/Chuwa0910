import javax.imageio.plugins.tiff.TIFFImageReadParam;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        //oddEvenPrinterTrigger();
        //oddEvenPrinterReenTrigger();
        //printNumber30Trigger();
    }

    public static void oddEvenPrinterTrigger(){
        oddEvenPrinter printer = new oddEvenPrinter();
        new Thread(printer).start();
        new Thread(printer).start();
    }

    public static void oddEvenPrinterReenTrigger(){
        oddEvenPrinterReen printer = new oddEvenPrinterReen();
        new Thread(printer).start();
        new Thread(printer).start();
        //new Thread(printer).start();

    }

    public static void printNumber30Trigger(){
        printNumber30 printer = new printNumber30();
        new Thread(printer).start();
        new Thread(printer).start();
        new Thread(printer).start();
    }
}