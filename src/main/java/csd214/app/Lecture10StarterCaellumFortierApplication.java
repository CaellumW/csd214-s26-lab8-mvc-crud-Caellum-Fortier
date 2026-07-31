package csd214.app;

import com.github.javafaker.Faker;
import csd214.app.entities.BookEntity;
import csd214.app.repositories.ProductRepository;
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
				BookEntity b = new BookEntity();
				b.setAuthor(faker.book().author());
				b.setTitle(faker.book().title());
				b.setName(b.getTitle()); // Map title to the parent product name
				b.setPrice(faker.number().randomDouble(2, 10, 50));
				productRepository.save(b);
			}

			BookEntity specificBook1 = new BookEntity();
			specificBook1.setAuthor("Julius Caesar");
			specificBook1.setTitle("The Gallic Wars");
			specificBook1.setName("The Gallic Wars");
			specificBook1.setPrice(19.99);
			productRepository.save(specificBook1);

			BookEntity specificBook2 = new BookEntity();
			specificBook2.setAuthor("Julius Caesar");
			specificBook2.setTitle("The Civil War");
			specificBook2.setName("The Civil War");
			specificBook2.setPrice(24.99);
			productRepository.save(specificBook2);

			System.out.println("Database seeded successfully!");
		}
		System.out.println("Web server is running! View the store at: http://localhost:8080/inventory");
	}
}
