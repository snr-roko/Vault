package com.rokoinc.Vault.data;

import com.github.javafaker.Faker;
import com.rokoinc.Vault.customer.Customer;
import com.rokoinc.Vault.customer.CustomerRepository;
import com.rokoinc.Vault.user.Gender;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements ApplicationRunner {

    private final CustomerRepository customerRepository;

    public DataSeeder(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (customerRepository.count() == 0) {
            System.out.println("No customers found");
            System.out.println("Seeding 30 Fake ");
            for (int i = 0; i < 30; i++) {
                seedCustomer();
            }
            System.out.println("30 customers seeded");
        } else {

            System.out.println(customerRepository.count() + " customers already in Databases");
            System.out.println("No customer seeding needed");

        }
    }

    public void seedCustomer() {
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        System.out.println("Creating first name: " + firstName);

        String lastName = faker.name().lastName();
        System.out.println("Creating last name: " + lastName);

        String email = faker.internet().emailAddress();
        System.out.println("Creating email: " + email);

        String phoneNumber = faker.phoneNumber().phoneNumber();
        System.out.println("Creating phone number: " + phoneNumber);

        String GPS = "AK-432-%s%s%s".formatted(faker.number().randomDigit(), faker.number().randomDigit(), faker.number().randomDigit());
        System.out.println("Creating GPS: " + GPS);

        String city = faker.address().city();
        System.out.println("Creating city: " + city);

        String region = faker.address().state();
        System.out.println("Creating region: " + region);

        Gender gender = faker.options().option(Gender.MALE, Gender.FEMALE);
        System.out.println("Creating gender: " + gender.toString());

        Customer newCustomer = new Customer(
                firstName,
                lastName,
                email,
                phoneNumber,
                GPS,
                city,
                region,
                gender
        );
        System.out.println("Saving User " + firstName + " " + lastName);
        customerRepository.save(newCustomer);
    }
}
