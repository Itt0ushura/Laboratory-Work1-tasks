package People14;

import java.util.Scanner;

class People2 {
    String surname;
    String name;
    String parent;
    int age;
    int size;
}

public class PeopleList2 {
    public static People2[] setPeopleArr(int np) {
        Scanner ns = new Scanner(System.in, "UTF-8");
        People2[] people = new People2[np];
        System.out.println("Введіть характеристики людей:");
        for (int i = 0; i < people.length; i++) {
            people[i] = new People2();

            System.out.println("Прізвище " + (i + 1) + " людини: ");
            people[i].surname = ns.nextLine();

            System.out.println("Ім'я " + (i + 1) + " людини: ");
            people[i].name = ns.nextLine();

            System.out.println("По-батькові " + (i + 1) + " людини: ");
            people[i].parent = ns.nextLine();

            System.out.println("Вік " + (i + 1) + " людини: ");
            people[i].age = ns.nextInt();

            System.out.println("Розмір одягу " + (i + 1) + " людини: ");
            people[i].size = ns.nextInt();

            ns.nextLine();
        }
        return people;
    }

    public static void showArray(People2[] ppl) {
        for (int i = 0; i < ppl.length; i++) {
            System.out.println((i + 1) + ")" + " Прізвище: " + ppl[i].surname + "\t" + "Ім'я: " + ppl[i].name + "\t" + "По-батькові: " + ppl[i].parent + "\t" + "Вік: " + ppl[i].age + " років\t" + "Розмір одягу: " + ppl[i].size);
        }
    }

    public static void showPeople(People2 ppl) {
        System.out.println("Прізвище " + ppl.surname + "\tІм'я " + ppl.name + "\tПо-батькові " + ppl.parent + "\tВік " + ppl.age + "\tРозмір одягу " + ppl.size);
    }

    public static int NumMax(People2[] peo) {
        int maxnum = 0;
        int max = peo[maxnum].size;
        for (int i = 0; i < peo.length; i++) {
            if (peo[i].size > max) {
                max = peo[i].size;
                maxnum = i;
            }
        }
        return maxnum;
    }

    public static double avgSize(People2[] ppl) {
        double average = 0;
        int count = 0;
        for (int i = 0; i < ppl.length; i++) {
            if (ppl[i].age >= 40) {
                count++;
                average += ppl[i].size;
            }
        }
        return average / count;
    }

    public static void sortBubbleSize(People2[] ppl) {
        for (int i = 0; i < ppl.length - 1; i++) {
            for (int j = 0; j < ppl.length - 1 - i; j++) {
                if (ppl[j].size > ppl[j + 1].size) {
                    People2 pep = ppl[j];
                    ppl[j] = ppl[j + 1];
                    ppl[j + 1] = pep;
                }
            }
        }
    }

    public static People2 arraySearch(People2[] ppl, String name) {
        int num = -1;
        for (int i = 0; i < ppl.length; i++) {
            if (name.equalsIgnoreCase(ppl[i].surname)) num = i;
        }
        if (num != -1) {
            return ppl[num];
        } else return null;
    }

    public static void arrayEdit(People2[] ppl, int editind, int editint) {
        Scanner ed = new Scanner(System.in, "UTF-8");

        for (int i = 0; i < ppl.length; i++) {
            if (i == editind) {
                System.out.println((editind + 1) + ")" + " Прізвище: " + ppl[editind].surname + " " + "Ім'я: " + ppl[editind].name + " " + " По-батькові: " + ppl[editind].parent + " " + " Вік: " + ppl[editind].age + " років " + "Розмір одягу: " + ppl[editind].size + "\n");
            }
        }

        switch (editint) {
            case 1 -> {
                System.out.println("На що змінюємо: ");
                ppl[editind].surname = ed.nextLine();
            }
            case 2 -> {
                System.out.println("На що змінюємо: ");
                ppl[editind].name = ed.nextLine();
            }
            case 3 -> {
                System.out.println("На що змінюємо: ");
                ppl[editind].parent = ed.nextLine();
            }
            case 4 -> {
                System.out.println("На що змінюємо: ");
                ppl[editind].age = ed.nextInt();
            }
            case 5 -> {
                System.out.println("На що змінюємо: ");
                ppl[editind].size = ed.nextInt();
            }
        }
    }

    public static void main(String[] args) {

        Scanner ns = new Scanner(System.in, "UTF-8");
        System.out.println("Введіть кількість людей => ");
        int n = ns.nextInt();
        People2[] people2 = setPeopleArr(n);
        System.out.println("\nХарактеристика людей");
        showArray(people2);

        ns.nextLine();

        int nummax = NumMax(people2);
        System.out.println("Людина з найбільшим розміром одягу");
        showPeople(people2[nummax]);

        ns.nextLine();

        System.out.println("Середній розмір " + avgSize(people2));

        ns.nextLine();

        sortBubbleSize(people2);
        System.out.println("\nВідсортований масив\n");
        showArray(people2);

        ns.nextLine();

        System.out.println("Введіть шукане прізвище");
        String Sname = ns.nextLine();
        People2 pfind = arraySearch(people2, Sname);
        if (pfind != null) {
            showPeople(pfind);
        } else {
            System.out.println("Такої людини немає");
        }

        ns.nextLine();

        System.out.println("Редагування, який запис редагуємо?\n");
        showArray(people2);
        int editind = ns.nextInt() - 1;
        System.out.println("Що саме редагуємо? введіть номер: \t 1) Прізвище \t 2) Ім'я \t 3) По-батькові \t 4) Вік \t 5) Розмір одягу");
        int editint = ns.nextInt();
        arrayEdit(people2, editind, editint);
        showPeople(people2[editind]);
    }
}
