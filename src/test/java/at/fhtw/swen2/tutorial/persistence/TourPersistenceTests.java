package at.fhtw.swen2.tutorial.persistence;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TourPersistenceTests {

	@Autowired
	private TourRepository tourRepository;

	@Test
	void testPersonRepository() {
		TourEntity first = TourEntity.builder()
				.name("First")
				.tourDescription("hi")
				.build();
		tourRepository.save(first);
		tourRepository.findAll().forEach(System.out::println);
	}

}
