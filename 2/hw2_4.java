/*
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */

import java.util.Scanner;

public class hw2_4 {
    public static void main(String[] args) {
        LineScanException();
    }


    public static void LineScanException() {
        try {
            System.out.printf("Введена строка: %s", EmptyLineScan());    
        } catch (EmptyLineException ex) {
            System.out.println(ex.getMessage());
        } 
    }


    public static String EmptyLineScan() throws EmptyLineException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите что-нибудь: ");
        String value = scan.nextLine();
        scan.close();
        if (value.length() == 0) throw new EmptyLineException("Пустые строки вводить нельзя.");
        else return value;
    }
}


class EmptyLineException extends Exception {
    public EmptyLineException(String message) {
        super(message);
    }
}
