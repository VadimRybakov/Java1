package lesson_3;

import java.util.Scanner;
import java.util.Random;
public class LessonThree {

    public static void main(String[] args) {

        /*При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
        Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        Для сравнения двух слов посимвольно можно пользоваться:
        String str = "apple";
        char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово.
        Используем только маленькие буквы.*/
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rand = new Random();
        String computerWord = words[rand.nextInt(words.length - 1)]; // компьютер загадал слово
        Scanner sc = new Scanner(System.in);
        System.out.println("Список слов: apple, orange, lemon, banana, apricot,\n" +
                " avocado, broccoli, carrot, cherry, garlic, grape,\n" +
                " melon, leak, kiwi, mango, mushroom, nut, olive,\n" +
                " pea, peanut, pear, pepper, pineapple, pumpkin, potato.\n" +
                " Какое слово я загадал? ");

        String userWord = sc.nextLine(); // пользователь вводит слово
        userWord = userWord.toLowerCase(); // приводим слово к нижнему регистру на случай если введены большие буквы

        do {
            for (int i = 0; i < 15; i++) {
                if (i >= userWord.length() || i >= computerWord.length()) {
                    System.out.print("#");
                    continue;
                }

                if (computerWord.charAt(i) == userWord.charAt(i))
                    System.out.print(userWord.charAt(i));
                else
                    System.out.print("#");
            }
            System.out.println("\nПопробуйте ещё раз");
            userWord = sc.nextLine();
            userWord = userWord.toLowerCase();
            if (computerWord.equals(userWord)) // если пользователь угадал, сообщаем
                System.out.println("Вы угадали");
        } while (!computerWord.equals(userWord));
        sc.close();
    }
}
