/*
Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
 */

import java.util.Scanner;

public class task_1 {
    static Scanner scanner = new Scanner(System.in);
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            printIntSq();
            System.out.println();

            divideIntZero();
            System.out.println();

            echoNumber();
            System.out.println();
        }

    }


    public static void printIntSq(){
        System.out.println("Введите целое число: ");
        int number = scanner.nextInt();
        System.out.printf("Квадрат числа равен %d: ", number * number);
        System.out.println();
    }


    public static void divideIntZero(){
        System.out.print("Введите первое целое число: ");
        int numberA = scanner.nextInt();
        System.out.println();
        System.out.print("Введите второе целое число: ");
        int numberB = scanner.nextInt();
        System.out.println();
        System.out.printf("Частное чисел равно: %d: ", numberA / numberB);
        System.out.println();
    }

    public static void echoNumber(){
        System.out.print("Введите число: ");
        String str = scan.nextLine();
        int number = Integer.parseInt(str);
        System.out.println(number);
    }
}