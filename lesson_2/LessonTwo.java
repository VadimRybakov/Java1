package lesson_2;

public class LessonTwo {
    public static void main(String[] args) {
        /*1. Задать целочисленный массив, состоящий из элементов 0 и 1.
         Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
         С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */
        System.out.println("Первое задание:");
        int[] arrayBit = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printOneDimArr(arrayBit);
        for (int i = 0; i < arrayBit.length; i++) {
            if (arrayBit[i] == 0)
                arrayBit[i] = 1;
            else
                arrayBit[i] = 0;
        }
        printOneDimArr(arrayBit);

        /* 2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
         */
        System.out.println("\n\nВторое задание:");
        int[] emptyArr = new int[8];
        for (int i = 0; i < emptyArr.length; i++) {
            emptyArr[i] = i * 3;
        }
        printOneDimArr(emptyArr);

        /* 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
         пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */
        System.out.println("\n\nТретье задание:");
        int[] userArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printOneDimArr(userArr);
        for (int i = 0; i < userArr.length; i++) {
            if (userArr[i] < 6)
                userArr[i] *= 2;
        }
        printOneDimArr(userArr);

        /* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
         и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
         */
        System.out.println("\n\nЧетвертое задание:");
        int[][] squareArr = new int[5][5];
        // Заполняем массив числами
        for (int[] ints : squareArr) {
            generateArr(ints, 100);
        }
        printTwoDimArray(squareArr);
        // выполняем задание
        for (int i = 0; i < squareArr.length; i++) {
            squareArr[i][i] = 1;
            squareArr[i][squareArr.length - i - 1] = 1;
        }
        printTwoDimArray(squareArr);

        // 5.Задать одномерный массив и найти в нем минимальный и максимальный элементы;
        System.out.println("\n\nПятое задание:");
        int[] array = new int[10];
        generateArr(array, 100);
        printOneDimArr(array);
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        System.out.println("\nМаксимальный элемент массива: " + max);
        System.out.println("Минимальный элемент массива: " + min);

        // Проверка 6 задания
        System.out.println("\n\nШестое задание:");
        // Проверка произвольно сгенерированного массива
        generateArr(array, 3);
        printOneDimArr(array);
        System.out.println(checkBalance(array));
        // Проверка массива, заполненного вручную
        int[] arrUser = {2, 2, 2, 1, 2, 2, 10, 1};
        printOneDimArr(arrUser);
        System.out.println(checkBalance(arrUser));

        // Проверка 7 задания
        System.out.println("\n\nСедьмое задание:");
        // Проверка сдвига вправо
        generateArr(array, 100);
        printOneDimArr(array);
        shiftArr(array, 5);
        printOneDimArr(array);
        System.out.println();
        // Проверка сдвига влево
        generateArr(array, 100);
        printOneDimArr(array);
        shiftArr(array, -3);
        printOneDimArr(array);
    }

    /* 6. Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    граница показана символами ||, эти символы в массив не входят.
     */
    public static boolean checkBalance(int[] arr){
        int leftSumm = arr[0];
        boolean flag = false;
        for (int i = 1; i < arr.length - 1; i++) {
            leftSumm += arr[i];
            int rightSumm = arr[arr.length - 1];
            for (int j = arr.length - 2; j > 1; j--) {
                rightSumm += arr[j];
                if((i == j - 1) && (rightSumm == leftSumm)){
                    flag = true;
                    System.out.println("\nГраница находится между " + j + " и " + (j - 1) + " элементами массива");
                    break;
                }
            }
        }
        return flag;
    }

    /* 7. Написать метод, которому на вход подается одномерный массив и число n
     (может быть положительным, или отрицательным),
     при этом метод должен сместить все элементымассива на n позиций.
     Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    public static void shiftArr(int[] arr, int n){
        int numb;
        if(n > 0){
            for (int i = 0; i < n; i++) {
                for (int j = arr.length - 1; j > 0; j--) {
                    numb = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = numb;
                }
            }
        }
        if(n < 0){
            int N = -1 * n;
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < arr.length; j++) {
                    numb = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = numb;
                }
            }
        }
        System.out.println("\nСдвиг элементов на " + n);
    }


    // Доп. метод вывода на экран одномерного массива
    public static void printOneDimArr(int[] arr){
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    // Доп. метод вывода на экран двумерного массива
    public static void printTwoDimArray(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    // Доп. метод заполнения массива случайными элементами
    public static void generateArr(int[] arr, int range){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * range);
        }
    }

}
