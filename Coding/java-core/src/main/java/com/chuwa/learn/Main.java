package com.chuwa.learn;

import java.util.Arrays;
import java.util.Optional;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int a =0;
        int b =3;
        String s = null;
        Optional<String> c = Optional.of("asdaw");

        try {
//            System.out.println(b/a);
//            System.out.println(s.equals("a"));
            throw new RuntimeException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch(RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}