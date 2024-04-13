package com.apirest.api_management.TestsUtils;

public class RandomDni {

    public static Long getRandomDni() {
        long num = (long) (Math.random() * 100000000L);

        // Formatear el número para que tenga siempre 8 dígitos
        String dniFormated = String.format("%08d", num);

        return Long.parseLong(dniFormated);
    }
}
