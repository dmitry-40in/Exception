/*
Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. 
Если длины массивов не равны, необходимо как-то оповестить пользователя. 
 */

public class task_2 {
    public static void main(String[] args) {
        int[] arrA = new int[]{3, 3, 3};
        int[] arrB = new int[]{1, 1, 1};

        int[] res = arrayDifference(arrA, arrB);


        for (int i : res) {
            System.out.print(i + " ");
        }
        
    }

    public static int[] arrayDifference(int[] arrA, int[] arrB){
        if (arrA.length == arrB.length){
            int[] arrC = new int[arrA.length];
            for (int i = 0; i < arrA.length; i++) {
                arrC[i] = arrA[i] - arrB[i];
            }
            return arrC;
        }
        throw new RuntimeException("Длины массивов различаются.");    
    }
}
