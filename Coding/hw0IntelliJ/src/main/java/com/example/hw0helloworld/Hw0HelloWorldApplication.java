package com.example.hw0helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw0HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hw0HelloWorldApplication.class, args);
		System.out.println("Hello World!");

		// Reverse string
		String str = "abcdef", nstr = "";
		char ch;
		System.out.println("Original string: abcdef");
		for(int i=0; i<str.length(); i++)
		{
			ch = str.charAt(i);
			nstr = ch + nstr;
		}
		System.out.println("Reversed string: " + nstr);
	}

}
