package vinylshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vinylshop.domain.User;
import vinylshop.domain.UserRepository;
import vinylshop.domain.DiskRepository;
import vinylshop.domain.Disk;
import vinylshop.domain.CategoryRepository;
import vinylshop.domain.Category;


@SpringBootApplication
public class VinylshopApplication {
	private static final Logger log = LoggerFactory.getLogger(VinylshopApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(VinylshopApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(DiskRepository diskrepository, CategoryRepository catrepository, UserRepository userrepository ) {
		return (args) -> {
	
			log.info("save disks");
			catrepository.save(new Category("Pop"));
			catrepository.save(new Category("Rock"));
			catrepository.save(new Category("Blues"));
			
			diskrepository.save(new Disk ("Thriller", "Michael Jackson", 1979, "888751437319", 19.99, catrepository.findByCategoryname("Pop").get(0)));
			diskrepository.save(new Disk ("Dark Side Of The Moon", "Pink Floyd", 1973,"888751842519", 30.99, catrepository.findByCategoryname("Rock").get(0)));
			diskrepository.save(new Disk ("Led Zeppelin IV", "Led Zeppelin", 1971,"081227965778", 24.99, catrepository.findByCategoryname("Rock").get(0)));
			diskrepository.save(new Disk ("Where Did You Sleep Last Night", "Lead Belly", 1944,"00543729042", 18.99, catrepository.findByCategoryname("Blues").get(0)));
			diskrepository.save(new Disk ("Violator", "Depeche Mode", 1990,"0123425522", 28.99, catrepository.findByCategoryname("Pop").get(0)));
			
			//Password: password
			userrepository.save(new User("user", "$2a$12$Lw3xw05g.1JsTTwNtDvcQO5ClF1Z896I9TcqgZj7AHMJV/Ur7NAQK", "USER"));
			userrepository.save(new User("admin", "$2a$12$Lw3xw05g.1JsTTwNtDvcQO5ClF1Z896I9TcqgZj7AHMJV/Ur7NAQK", "ADMIN"));
			
			log.info("fetch all disks");
			for (Disk disk : diskrepository.findAll()) {
				log.info(disk.toString());
			}
		};
	}
	
	
}
