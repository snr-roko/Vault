package com.rokoinc.Vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")
@SpringBootApplication
public class VaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaultApplication.class, args);
	}

	// Gender of user
	public enum Gender{MALE, FEMALE}


	// simple user model with record
	public record User(
			Integer id, String firstName, String lastName, String email, String phoneNumber,
			LocalDate dateOfBirth, String GPS, String city, String state, String zipCode, Gender gender,
			LocalDate createdAt, LocalDate updatedAt
	) {

	}

	// automatically incrementing id
	private static final AtomicInteger idCounter = new AtomicInteger(0);

	// user list
	public static List<User> users = new ArrayList<>();

	// sample users
	static {
		users.add(new User(
				idCounter.incrementAndGet(),
				"Larry",
				"Daniels",
				"larry.daniels@gmail.com",
				"+233545048523",
				LocalDate.of(1995, 4, 30),
				"AK-539-3213",
				"Kumasi",
				"Ashanti",
				"00233",
				Gender.MALE,
				LocalDate.now(),
				LocalDate.now()
		));

		users.add(new User(
				idCounter.incrementAndGet(),
				"Akosua",
				"Mensah",
				"akosua.mensah@yahoo.com",
				"+233204567890",
				LocalDate.of(1988, 12, 15),
				"AR-284-7519",
				"Accra",
				"Greater Accra",
				"00233",
				Gender.FEMALE,
				LocalDate.now(),
				LocalDate.now()
		));

		users.add(new User(
				idCounter.incrementAndGet(),
				"Kwame",
				"Asante",
				"kwame.asante@outlook.com",
				"+233558123456",
				LocalDate.of(1992, 7, 8),
				"BA-156-4892",
				"Sunyani",
				"Bono",
				"00233",
				Gender.MALE,
				LocalDate.now(),
				LocalDate.now()
		));

		users.add(new User(
				idCounter.incrementAndGet(),
				"Ama",
				"Osei",
				"ama.osei@gmail.com",
				"+233244789012",
				LocalDate.of(1990, 1, 22),
				"EP-372-6148",
				"Ho",
				"Volta",
				"00233",
				Gender.FEMALE,
				LocalDate.now(),
				LocalDate.now()
		));

		users.add(new User(
				idCounter.incrementAndGet(),
				"Yaw",
				"Boateng",
				"yaw.boateng@hotmail.com",
				"+233509876543",
				LocalDate.of(1985, 11, 3),
				"WP-493-2857",
				"Wa",
				"Upper West",
				"00233",
				Gender.MALE,
				LocalDate.now(),
				LocalDate.now()
		));
	}

	// enum for sorting
	public enum SortingOrder {ASC, DESC}

	@GetMapping
	public List<User> getAllUsers(@RequestParam(value = "sort", defaultValue = "ASC") SortingOrder sort) {
		if (sort == SortingOrder.ASC) {
			return users.stream().sorted(Comparator.comparing(User::id)).collect(Collectors.toList());
		}

		return users.stream().sorted(Comparator.comparing(User::id).reversed()).collect(Collectors.toList());
	}

	@GetMapping("{id}")
	public Optional<User> getUserById (@PathVariable("id") Integer id) {
        return users.stream().filter(user -> user.id.equals(id)).findFirst();
	}




}
