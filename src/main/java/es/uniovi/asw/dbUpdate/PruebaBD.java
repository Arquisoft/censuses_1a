package es.uniovi.asw.dbUpdate;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.uniovi.asw.logica.User;

@SpringBootApplication
public class PruebaBD {
	
		
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaBD.class);
	}
	
	@Bean
	public CommandLineRunner demo(RepositorioUsuarios repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new User("pp", "ppp", "ppppppp",2,"PASS"));

			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
			for (User user: repository.findAll()) {
				System.out.println(user.toString());
			}
//            log.info("");
//
//			// fetch an individual customer by ID
//			Customer customer = repository.findOne(1L);
//			log.info("Customer found with findOne(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//            log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			for (Customer bauer : repository.findByLastName("Bauer")) {
//				log.info(bauer.toString());
//			}
//            log.info("");
		};
	}

}
