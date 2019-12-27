package lesson_5;

public class LessonFive {
    public static void main(String[] args) {

        Employee[] personArray = new Employee[5];
        personArray[0] = new Employee("Коваленко Антон Владимирович","старший инженер",
                "kovant@gmail.com", "+79178634576", 85000, 45 );
        personArray[1] = new Employee("Иванов Иван Иванович","инженер",
                "ivanov@mail.ru", "+79168556456", 56700, 35 );
        personArray[2] = new Employee("Бабаев Дмитрий Олегович","менеджер",
                "bavdm@mail.ru", "+79253134567", 45000, 25 );
        personArray[3] = new Employee("Смирнова Виктория Кирилловна","секретарь",
                "smirn94@gmail.com", "+79259662351", 40000, 25 );
        personArray[4] = new Employee("Никифоров Олег Евгеньевич","директор",
                "noe@mail.ru", "+79034578832", 90000, 42 );

        for (Employee employee : personArray) {
            if (employee.getAge() > 40) {
                System.out.print(employee.getFullName() + " ");
                System.out.print(employee.getPosition() + " ");
                System.out.print(employee.getEmail() + " ");
                System.out.print(employee.getPhoneNumber() + " ");
                System.out.print(employee.getSalary() + " ");
                System.out.println(employee.getAge());
            }
        }
    }
}
