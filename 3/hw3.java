import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class hw3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: фамилия имя отчество номер телефона (целое беззнаковое число) через пробел");
        String input = scanner.nextLine();

        String[] data = input.split(" ");

        int checkLengthResult = checkLength(data);
        if (checkLengthResult == -2) {
            System.out.println("Ошибка - введено больше данных.");
        }
        else if (checkLengthResult == -1) {
            System.out.println("Ошибка - введено меньше данных.");
        }
        else {
            System.out.println("Количество данных верное.");
        };

        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                processUserData(input);
                isValidInput = true;
            } catch (InvalidDataException e) {
                System.out.println("Ошибка: неверный формат данных");
                System.out.println(e.getMessage());
                System.out.println("Пожалуйста, повторите ввод данных.");
                input = scanner.nextLine();
            } catch (IOException e) {
                System.out.println("Ошибка: возникла проблема с записью данных в файл.");
                e.printStackTrace();
                return;
            }
        }
    }


    static int checkLength(String[] data) {
        if (data.length < 4) {
            return -1;
        }
        else if (data.length > 4){
            return -2;
        }
        else {
            return 4;
        }
    }


    static void checkFormat (String[] data) {
        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String phoneNumber = data[3];




        try {
            if(!lastName.matches("[а-яёА-ЯЁ]+"))
            
        } catch (Exception e) {
            // TODO: handle exception
        }

        try {
            Long parsPhoneNumber = Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Неверный формат номера телефона.");
        }

        // Создание файла с данными
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(lastName + ".txt", true))) {
            String userData = lastName + " " + firstName + " " + middleName + " " + phoneNumber;
            writer.write(userData);
            writer.newLine();
            System.out.println("Данные успешно записаны в файл " + lastName + ".txt");
        }
    }

    public static void stringChecking(String lastName, String firstName, String middleName) throws InvalidDataException{
        if(!lastName.matches("[а-яёА-ЯЁ]+")){
            throw new InvalidDataException("Фамилия указана неверно.");
        }
        if(!firstName.matches("[а-яёА-ЯЁ]+")){
            throw new InvalidDataException("Имя указана неверно.");
        }
        if(!middleName.matches("[а-яёА-ЯЁ]+")){
            throw new InvalidDataException("Отчество указано неверно.");
        }
    }
    
    
}


    class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
    }
