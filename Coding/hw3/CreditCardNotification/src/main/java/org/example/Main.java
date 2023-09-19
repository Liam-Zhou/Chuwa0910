package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Publisher pub = new Publisher(new UserBuilder());
        pub.register("nameA","Email","email.com","email.com");
        pub.register("nameB","SMS","122313213","email2.com");
        pub.register("nameC","SMS","122313231231213","email23.com");

        pub.noteAll("40% off when you buy Popeyes between 06/13 - 06");
    }
}