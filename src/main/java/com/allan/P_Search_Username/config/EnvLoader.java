package com.allan.P_Search_Username.config;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {
    public static void load() {
        // Intenta obtener de System.getenv() primero
        String dbUrl = System.getenv("DB_URL");
        String dbUsername = System.getenv("DB_USERNAME");
        String dbPassword = System.getenv("DB_PASSWORD");

        // Si alguna es null, intenta cargar desde archivo .env (opcional para desarrollo)
        if (dbUrl == null || dbUsername == null || dbPassword == null) {
            try {
                Dotenv dotenv = Dotenv.configure().load();
                if (dbUrl == null) dbUrl = dotenv.get("DB_URL");
                if (dbUsername == null) dbUsername = dotenv.get("DB_USERNAME");
                if (dbPassword == null) dbPassword = dotenv.get("DB_PASSWORD");
            } catch (Exception e) {
                System.err.println("⚠️ Warning: No .env file found and some environment variables are missing.");
            }
        }

        // Setea propiedades del sistema (para que Spring las lea, por ejemplo)
        if (dbUrl != null) System.setProperty("DB_URL", dbUrl);
        if (dbUsername != null) System.setProperty("DB_USERNAME", dbUsername);
        if (dbPassword != null) System.setProperty("DB_PASSWORD", dbPassword);
    }
}
