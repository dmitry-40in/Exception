import java.io.BufferedWriter;
import java.io.FileWriter;
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


        try {
            checkFormat(data);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(data[0] + ".txt", true))) {
                String userData = data[0] + " " + data[1] + " " + data[2] + " " + data[3];
                writer.write(userData);
                writer.newLine();
                System.out.println("Данные успешно записаны в файл " + data[0] + ".txt");
            }
            catch (Exception e) {
                System.out.println("Ошибка " + e.getMessage());
            }
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
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


        static boolean isNumeric(String str) {
            for (int i = 0; i < str.length(); i++) {
                if(Character.isDigit(str.charAt(i))) {
                    return true;
                }
            }
            return false;
        }


        static void checkFormat (String[] data) throws InvalidDataException {
            if (isNumeric(data[0])) throw new InvalidDataException("Ошибка - Фамилия указана неверно.");
            if (isNumeric(data[1])) throw new InvalidDataException("Ошибка - Имя указано неверно.");
            if (isNumeric(data[2])) throw new InvalidDataException("Ошибка - Отчество указано неверно.");

            try {
                Long parsPhoneNumber = Long.parseLong(data[3]);
            } catch (Exception e) {
                throw new InvalidDataException("Ошибка - Неверный формат номера телефона.");
            }
        }

    
    
}

    class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
    }
