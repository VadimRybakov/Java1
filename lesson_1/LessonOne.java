package lesson_1;

// 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
public class LessonOne {
    public static void main(String[] args) {
        System.out.println("Hello");
        // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte byteVal = 18;
        short shortVal = -31800;
        int intVal = 23349955;
        long longVal = -929485475636L;
        float floatVal = 153.1567f;
        double doubleVal = 153.15678543;
        char charVal = 'v';
        boolean boolVal = true;

        System.out.println("Проверка 3 задания:  " + calc(8.9f, 12f, -13.88f, -15f));
        System.out.println("Проверка 4 задания: " + checkSumm(12,55));
        System.out.println("Проверка 5 задания: ");
        checkNum(-15);
        System.out.println("Проверка 6 задания: " + checkNegNum(-899));
        System.out.println("Проверка 7 задания: ");
        printName("Алина");
        System.out.println("Проверка 8 задания: ");
        checkYear(2019);
    }
    /* 3. Написать метод вычисляющий выражение a * (b + (c / d)) и
    возвращающий результат,где a, b, c, d – входные параметры этого метода;
     */
    public static float calc (float a, float b, float c, float d){
        return (a*(b + (c/d)));
    }
    /* 4. Написать метод, принимающий на вход два числа,
    и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
     если да – вернуть true, в противном случае – false;
     */
    public static boolean checkSumm (int a, int b){
        return (a + b) >= 10 && (a + b) <= 20;
    }
    /* 5. Написать метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль положительное ли число передали, или отрицательное;
    Замечание: ноль считаем положительным числом.
     */
    public static void checkNum(int a) {
        if (a >= 0)
            System.out.println("Вы передали положительное число");
        else
            System.out.println("Вы передали отрицательное число");
    }
    /* 6. Написать метод, которому в качестве параметра передается целое число,
    метод должен вернуть true, если число отрицательное;
     */
    public static boolean checkNegNum(int a){
        return a < 0;
    }
    /* 7. Написать метод, которому в качестве параметра передается строка,
    обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
     */
    private static void printName(String name){
        System.out.println("Привет, " + name + "!");
    }
    /* 8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
     Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static void checkYear(int year){
        if((year%4 == 0 && year%100 != 0) || year%400 ==0 )
            System.out.println(year + "год - високосный");
        else
            System.out.println(year + "год - не високосный");
    }
}
