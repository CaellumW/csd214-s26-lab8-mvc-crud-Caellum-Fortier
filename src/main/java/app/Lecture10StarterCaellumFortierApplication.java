package app;

import app.entities.GelPolishEntity;
import com.github.javafaker.Faker;
import app.entities.BookEntity;
import app.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lecture10StarterCaellumFortierApplication implements CommandLineRunner {

	private final ProductRepository productRepository;

	// Constructor Dependency Injection [6]
	public Lecture10StarterCaellumFortierApplication(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lecture10StarterCaellumFortierApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (productRepository.count() == 0) {
			System.out.println("Populating Database with Faker for Web MVC...");
			Faker faker = new Faker();

			for (int i = 0; i < 5; i++) {
				GelPolishEntity p = new GelPolishEntity();
				p.setColourShade(faker.color().name());
				p.setTexture(faker.color().name());
				p.setBrand(p.getBrand()); // Map title to the parent product name
				p.setPrice(faker.number().randomDouble(2, 10, 50));
				productRepository.save(p);
			}

			GelPolishEntity specificPolish1 = new GelPolishEntity();
			specificPolish1.setColourShade("Red");
			specificPolish1.setBrand("e.l.f");
			specificPolish1.setTexture("Matte");
			specificPolish1.setPrice(24.99);
			productRepository.save(specificPolish1);

			GelPolishEntity specificPolish2 = new GelPolishEntity();
			specificPolish2.setColourShade("Forest Green");
			specificPolish2.setBrand("nyx");
			specificPolish2.setTexture("Shiny");
			specificPolish2.setPrice(24.99);
			productRepository.save(specificPolish2);

			System.out.println("Database seeded successfully!");
		}
		System.out.println("Web server is running! View the store at: http://localhost:8080/inventory");
	}
}
