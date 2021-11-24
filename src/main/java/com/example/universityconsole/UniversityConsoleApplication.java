package com.example.universityconsole;

import com.example.universityconsole.console.ConsoleController;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UniversityConsoleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                SpringApplication.run(UniversityConsoleApplication.class, args);
        ConsoleController consoleController = run.getBean(ConsoleController.class);
        System.out.println("Available commands:");
        System.out.println("1. Who is head of department {department_name}");
        System.out.println("2. Show {department_name} statistics.");
        System.out.println("3. Show the average salary for the department {department_name}");
        System.out.println("4. Show count of employee for {department_name}.");
        System.out.println("5. Global search by {template}");
        boolean variable = true;
        while (variable) {
            System.out.print("Choose one the options above. Enter number: ");
            Scanner scan = new Scanner(System.in);
            String i = scan.next();
            consoleController.consoleCommand(Integer.parseInt(i));
            System.out.print("If you wish to exit, enter digit 0,"
                    + " or enter any digit to continue: ");
            int exit = scan.nextInt();
            if (exit == 0) {
                variable = false;
            }
        }
    }
}
