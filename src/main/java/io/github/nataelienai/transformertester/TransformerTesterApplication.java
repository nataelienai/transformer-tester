package io.github.nataelienai.transformertester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class TransformerTesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransformerTesterApplication.class, args);
	}

}
