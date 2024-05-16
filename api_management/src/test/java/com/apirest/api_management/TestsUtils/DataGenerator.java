package com.apirest.api_management.TestsUtils;

import com.github.javafaker.Faker;

public class DataGenerator {

    private static final Faker faker = new Faker();
    public static String getRandomDni() {
        long num = (long) (Math.random() * 100000000L);

        // Formatear el número para que tenga siempre 8 dígitos
        return String.format("%08d", num);
    }

    public static String getRandomName() { return faker.name().firstName(); }

    public static String getRandomSurname() { return faker.name().lastName(); }

}
