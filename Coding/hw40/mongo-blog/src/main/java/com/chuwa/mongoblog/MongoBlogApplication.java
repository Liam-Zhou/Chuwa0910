package com.chuwa.mongoblog;

import com.chuwa.mongoblog.DAO.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoBlogApplication  {

	@Autowired
	BlogRepository blogRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongoBlogApplication.class, args);
	}

}
