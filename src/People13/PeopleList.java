package People13;

import java.util.Scanner;

class People { //клас людини, з об'єктів якого буде складатись масив
    String surname; //прізвище людини
    String name; //ім'я людини
    String parent; //по-батькові людини
    int age; //вік людини
    int size; //розмір одягу людини
}

public class PeopleList { //основний клас
    public static void main(String[] args) { //точка входу в додаток
        Scanner ns = new Scanner(System.in, "UTF-8"); //оголошення нового сканеру
        System.out.println("Створимо ваш список людей!");
        System.out.println("Введіть кількість людей:");
        int np = ns.nextInt(); //задання кількості елементів масиву через клавіатуру, тільки цілі числа
        People[] people = new People[np]; //створення масиву розміром, який задав користувач
        System.out.println("Введіть характеристики людей:");
        for (int i = 0; i < people.length; i++) { //лічильник, який проходить по масиву і вносить зміни до елементів
            ns.nextLine(); //очищення буферу для коректної роботи сканеру
            people[i] = new People(); //створення об'єкту класса People
            System.out.println("Прізвище " + (i + 1) + " людини: "); //і+1 через те, що лічильник в масиві починає з 0 і і+1 дозволяє коректно відібражати порядок
            people[i].surname = ns.nextLine(); //встановлення прізвища з клавіатури
            System.out.println("Ім'я " + (i + 1) + " людини: ");
            people[i].name = ns.nextLine();//встановлення ім'я з клавіатури
            System.out.println("По-батькові " + (i + 1) + " людини: ");
            people[i].parent = ns.nextLine();//по-батькові з клавіатури
            System.out.println("Вік " + (i + 1) + " людини: ");
            people[i].age = ns.nextInt();//вік людини з клавіатури
            System.out.println("Розмір одягу " + (i + 1) + " людини: ");
            people[i].size = ns.nextInt();//розмір одягу з клавіатури
        }
        for (People peo : people) {//альтернативний запис виведення масиву людей
            System.out.println("Прізвище: " + peo.surname + "\n" + "Ім'я: " + peo.name + "\n" + "По-батькові: " + peo.parent + "\n" + "Вік: " + peo.age + " років\n" + "Розмір одягу: " + peo.size + "\n\n");
        }
//Частина коду, яка виводить максимальний розмір одягу серед всіх елементів масиву
        System.out.println("В цій частині ми розраховуємо максимальний розмір одягу серед усіх людей списку");
        ns.nextLine();//очищення буферу для коректної роботи сканеру
        int maxnum = 0; //змінна, яка буде зберігати в собі індекс максимального елементу масиву
        int max = people[maxnum].size;//змінна, яка буде зберігати значення максимального елементу масиву
        for (int i = 0; i < people.length; i++) //перебір всіх елементів масиву
            if (people[i].size > max) { //умова ЯКЩО розмір і елемента масиву більше за max
                max = people[i].size; //то і елемент стає max
                maxnum = i; //і індекс максимального елементу maxnum приймає значення і
            }
        System.out.println("Найбільший розмір одягу у: \n\n");
        System.out.println(people[maxnum].name + " " + people[maxnum].surname + " " + people[maxnum].parent + " " + people[maxnum].size + "\n\n"); //виведення елементу з найбільшим розміром одягу
//Частина коду, яка рахує середній розмір одягу серед людей віком в 40+ років
        System.out.println("В цій частині йде розрахунок середнього розміру одягу серед людей віком від 40 років");
        ns.nextLine();//очищення буферу для коректної роботи сканеру
        double average = 0;//значення середного арифметичного
        int count = 0;//лічильник кількості людей за 40 років
        for (int i = 0; i < people.length; i++) {//перебір масиву
            if (people[i].age >= 40) {//якщо людині більше або = 40 років
                count++;//додаємо її до лічильнику 40+ людей
                average += people[i].size;//і додаємо до середнього значення значення розміру людини 40+
            }
        }
        System.out.println("Середній розмір одягу для людей віком від 40 років: " + (average / count) + "\n\n");
//Сортування бульбашкою за розміром одягу
        System.out.println("В цій частині ми сортуємо масив за розміром одягу в порядку зростання");
        ns.nextLine();//очищення буферу для коректної роботи сканеру
        for (int i = 0; i < people.length - 1; i++) {//зовнішній лічильник масиву
            for (int j = 0; j < people.length - 1 - i; j++) {//внутрішній лічильник масиву, проходить з кожним виконанням зовнішнього лічильнику на один елемент менше
                if (people[j].size > people[j + 1].size) { //якщо розмір одягу j елементу масиву більше за наступний,
                    People pep = people[j];//створюємо об'єкт, який буде зберігати в собі минуле значення
                    people[j] = people[j + 1];//замінюємо старе значення на значення наступного елементу
                    people[j + 1] = pep;//присвоюємо наступному елементу значення минулого
                }
            }
        }
        System.out.println("\n Відсортований список за розмірами одягу: ");
        for (int i = 0; i < people.length; i++) {//виведення відсортованого масиву
            System.out.println(people[i].name + " " + people[i].surname + " " + people[i].parent + " " + people[i].age + " " + people[i].size + "\n");
        }
//Частина коду яка виконує пошук
        System.out.println("Пошук по масиву");
        ns.nextLine();//очищення буферу для коректної роботи сканеру
        System.out.println("Введіть шукане прізвище: ");
        String name = ns.nextLine();//вводимо шукане ім'я
        int num = -1;//змінна яка зазначає, що "шуканої людини не знайдено"
        for (int i = 0; i < people.length; i++) {//лічильник
            if (name.equalsIgnoreCase(people[i].surname))
                num = i;//якщо введене нами ім'я знайдене - присвоюємо індекс цього елементу масиву до змінної
        }
        if (num != -1) {
            System.out.println("Така людина є у списку. Це: " + people[num].surname + " " + people[num].name + " " + people[num].parent);//виведення знайденого результату
        } else System.out.println("Такої людини немає"); //якщо не знайшли
//редагування запису і виведення відредагованого
        System.out.println("Редагування записів у масиві");
        ns.nextLine();//очищення буферу для коректної роботи сканеру
        for (int i = 0; i < people.length; i++) {
            System.out.println((i + 1) + ")" + " Прізвище: " + people[i].surname + " " + "Ім'я: " + people[i].name + " " + "По-батькові: " + people[i].parent + " " + "Вік: " + people[i].age + " років " + "Розмір одягу: " + people[i].size);
        }
        System.out.println("Який запис редагуємо? введіть номер: ");
        int editind = ns.nextInt() - 1;//вводимо номер елементу для редагування. -1 тут потрібен для правильної роботи частини коду, тому що елементи рахуються від 0.
        for (int i = 0; i < people.length; i++) {//якщо шуканий елемент існує - виводимо його для користувача.
            if (i == editind) {
                System.out.println((editind + 1) + ")" + " Прізвище: " + people[editind].surname + " " + "Ім'я: " + people[editind].name + " " + "По-батькові: " + people[editind].parent + " " + "Вік: " + people[editind].age + " років " + "Розмір одягу: " + people[editind].size);
            } else {
                System.out.println("індекс введено неправильно або такого номеру елементу не існує");
            }
        }
        ns.nextLine();//очищення буферу
        System.out.println("Що саме редагуємо? введіть номер: \t 1) Прізвище \t 2) Ім'я \t 3) По-батькові \t 4) Вік \t 5) Розмір одягу");
        int editint = ns.nextInt();//введення номеру змінюваного запису
        switch (editint) { //коротко: якщо обираємо 1, тобто прізвище, то даємо користувачу змінити прізвище запису з клавіатури, і так далі з усіма номерами
            case 1:
                ns.nextLine();
                System.out.println("На що змінюємо: ");
                people[editind].surname = ns.nextLine();
                break;
            case 2:
                ns.nextLine();
                System.out.println("На що змінюємо: ");
                people[editind].name = ns.nextLine();
                break;
            case 3:
                ns.nextLine();
                System.out.println("На що змінюємо: ");
                people[editind].parent = ns.nextLine();
                break;
            case 4:
                ns.nextLine();
                System.out.println("На що змінюємо: ");
                people[editind].age = ns.nextInt();
                break;
            case 5:
                ns.nextLine();
                System.out.println("На що змінюємо: ");
                people[editind].size = ns.nextInt();
                break;
        }
        System.out.println("Змінена інформація про людину: ");//виведення відредагованного запису
        System.out.println("Прізвище: " + people[editind].surname + " " + "Ім'я: " + people[editind].name + " " + "По-батькові: " + people[editind].parent + " " + "Вік: " + people[editind].age + " років " + "Розмір одягу: " + people[editind].size);
    }
}
