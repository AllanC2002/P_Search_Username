package com.allan.P_Search_Username;

import com.allan.P_Search_Username.config.EnvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PSearchUsernameApplication {

    public static void main(String[] args) {
        EnvLoader.load();  // <-- carga las variables de entorno aquí

        SpringApplication.run(PSearchUsernameApplication.class, args);

        System.out.println("DB_URL = " + System.getProperty("DB_URL"));
        System.out.println("DB_USERNAME = " + System.getProperty("DB_USERNAME"));
        System.out.println("DB_PASSWORD = " + System.getProperty("DB_PASSWORD"));

    }

}
