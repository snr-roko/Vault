package com.rokoinc.Vault.user;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LocalUserRepository {

    // automatically incrementing id
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    // user list
    private static final List<User> users = new ArrayList<>();

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

    protected AtomicInteger getIdCounter() {
        return idCounter;
    }

    protected List<User> getUsers() {
        return users;
    }
}
