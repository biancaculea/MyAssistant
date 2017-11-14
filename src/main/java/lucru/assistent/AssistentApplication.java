package lucru.assistent;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// In Spring Boot + Spring Data JPA application, to support the JSR310 java.time.* APIs,
// we need to register this Jsr310JpaConverters manually:
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
//@EntityScan(
//		basePackageClasses = {AssistentApplication.class, Jsr310JpaConverters.class}
//)

@SpringBootApplication
public class AssistentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssistentApplication.class, args);
	}

	@Bean
    public CommandLineRunner run()throws Exception{
		return args -> {
		final Logger logger = LogManager.getLogger(AssistentApplication.class);
		};
	}
}
