package com.example.universityconsole;

import com.example.universityconsole.console.ConsoleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UniversityConsoleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                SpringApplication.run(UniversityConsoleApplication.class, args);
        ConsoleController consoleController = run.getBean(ConsoleController.class);
        consoleController.run();
    }
}
