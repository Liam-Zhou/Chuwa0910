// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


public class Main {

    static String reverseString(String s){

        String reverseStr="";
        for( int i=s.length()-1;i>=0;i--){
            reverseStr=reverseStr+s.charAt(i);
        }
        return reverseStr;
    }
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        System.out.println("Hello World!");
        String s="abcdef";
        System.out.println(reverseString(s));
    }
}