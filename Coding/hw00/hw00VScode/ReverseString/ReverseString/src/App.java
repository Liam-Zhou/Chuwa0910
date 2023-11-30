public class App {
    public static void main(String[] args) throws Exception {
        String str = "abcdef", nstr = "";
        char ch;

        System.out.println("Original word: abcdef");
        for(int i=0; i<str.length(); i++)
        {
            ch = str.charAt(i);
            nstr = ch + nstr;
        }
        System.out.println("Reversed word: " + nstr);
    }
}
