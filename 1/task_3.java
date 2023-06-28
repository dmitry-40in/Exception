/*
 Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
 и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. 
 Если длины массивов не равны, необходимо как-то оповестить пользователя. 
 Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
 */
public class task_3 {
   public static void main(String[] args) {
     int[] arrA = new int[]{3, 3, 3};
        int[] arrB = new int[]{1, 1, 1, 1};

        int[] res = arrayDivide(arrA, arrB);


        for (int i : res) {
            System.out.print(i + " ");
        }
   } 


       public static int[] arrayDivide(int[] arrA, int[] arrB){
        if (arrA.length == arrB.length){
            int[] arrC = new int[arrA.length];
            for (int i = 0; i < arrA.length; i++) {
                if (arrB[i] == 0) throw new RuntimeException("Ошибка - деление на ноль.");
                arrC[i] = arrA[i] / arrB[i];
            }
            return arrC;
        }
        throw new RuntimeException("Длины массивов различаются.");    
    }
}
