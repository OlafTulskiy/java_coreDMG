package com.company.lesson7DZ.DZ7;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private final Controller controller = new Controller();

    public void runApplication() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter name of city on english!");
            String city = scanner.nextLine();

            setGlobalCity(city);

            System.out.println("Enter answer: 1 - Get current weather, " +
                "2 - Get weather on next 5 days, " +
                "3 - LOad from DB all records " +
                " exit ");
            String result = scanner.nextLine();

            checkIsExit(result);

            try {
                validateUserInput(result);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            try {
                notifyController(result);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private void checkIsExit(String result) {
        if (result.toLowerCase().equals("выход") || result.toLowerCase().equals("exit")) {
            System.out.println("End job!! Goodbye!!");
            System.exit(0);
        }
    }

    private void setGlobalCity(String city) {
        ApplicationGlobalState.getInstance().setSelectedCity(city);
    }


    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Incorrect user input: expected one digit as answer, but actually get " + userInput);
        }
        int answer = 0;
        try {
            answer = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IOException("Incorrect user input: character is not numeric!");
        }
    }

    private void notifyController(String input) throws IOException, SQLException {
        controller.onUserInput(input);
    }

}
