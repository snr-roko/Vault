package com.rokoinc.Vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
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


//	// simple user model with record
//	public record User(
//			Integer id, String firstName, String lastName, String email, String phone,
//			LocalDate dateOfBirth, String GPS, String city, String region, String zipCode, Gender gender,
//			LocalDate createdAt, LocalDate updatedAt
//	) {
//
//	}

	// User Model Class
	public static class User{
		private Integer id;
		private String firstName;
		private String lastName;
		private String email;
		private String phone;
		private LocalDate dateOfBirth;
		private String GPS;
		private String city;
		private String region;
		private String zipCode;
		private Gender gender;
		private LocalDate createdAt;
		private LocalDate updatedAt;


		public User(Integer id, String firstName, String lastName, String email, String phone, LocalDate dateOfBirth, String GPS, String city, String region, String zipCode, Gender gender, LocalDate createdAt, LocalDate updatedAt) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phone = phone;
			this.dateOfBirth = dateOfBirth;
			this.GPS = GPS;
			this.city = city;
			this.region = region;
			this.zipCode = zipCode;
			this.gender = gender;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getGPS() {
			return GPS;
		}

		public void setGPS(String GPS) {
			this.GPS = GPS;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		public LocalDate getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDate createdAt) {
			this.createdAt = createdAt;
		}

		public LocalDate getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(LocalDate updatedAt) {
			this.updatedAt = updatedAt;
		}
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
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(value = "sort", defaultValue = "ASC") SortingOrder sort) {
		if (sort == SortingOrder.ASC) {
			List<User> response = users.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());

			return ResponseEntity.ok().body(response);
		}

		List<User> response = users.stream().sorted(Comparator.comparing(User::getId).reversed()).collect(Collectors.toList());
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("{id}")
	public ResponseEntity<Optional<User>> getUserById (@PathVariable("id") Integer id) {
        Optional<User> response = users.stream().filter(user -> user.id.equals(id)).findFirst ();

		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<Optional<User>> addUser(@RequestBody User newUser) {
		// Create new user with auto-generated ID and current timestamps
		User createdUser = new User(
				idCounter.incrementAndGet(),
				newUser.firstName,
				newUser.lastName,
				newUser.email,
				newUser.phone,
				newUser.dateOfBirth,
				newUser.GPS,
				newUser.city,
				newUser.region,
				newUser.zipCode,
				newUser.gender,
				LocalDate.now(),
				LocalDate.now()
		);

		// Add to the users collection
		users.add(createdUser);

		Optional<User> response = Optional.of(createdUser);

		return ResponseEntity.ok(response);
	}

	// update a user
	// to continue
	public Optional<User> updateUser(@RequestBody User user) {
		return Optional.of(user);
	}

}
