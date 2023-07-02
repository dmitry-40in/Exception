/*
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
 * Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */

import java.util.Scanner;

 public class hw2_1 {
 
    public static void main(String[] args) {
        inputFloat();
    }

    public static void inputFloat(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число типа float: ");
        String value = scan.next();
        try {
            float res = Float.parseFloat(value);
            System.out.printf("Вывод числа float: %f", res);
            System.out.println();
        } catch (Exception e) {
            System.out.println("Тип введенного числа не float");
            inputFloat();
        }
        
    }
}

