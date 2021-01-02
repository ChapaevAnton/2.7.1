import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isCorrectName = false;
        while (!isCorrectName) {
            String name = scanner.nextLine(); //Считывает строку из System.in
            isCorrectName = checkName(name);
            if (!isCorrectName) {
                System.out.println("Введите корректное имя!");
            } else {
                System.out.println(formatName(name));
            }
        }

        boolean isCorrectNumberTel = false;
        while (!isCorrectNumberTel) {
            String tel = scanner.nextLine();
            isCorrectNumberTel = checkTel(tel);
            if (!isCorrectNumberTel) {
                System.out.println("Введите корректный номер телефона");
            } else {
                System.out.println(formatTel(tel));
            }
        }


    }

    private static String formatTel(String tel) {
        //QUESTION 3.2 ничего не рассказано про регулярные выражения которые применены "[^0-9]"?
        String temp = tel.replaceAll("[^0-9]", "");
        //QUESTION 3.2 конкотенация ли это?
        return String.format("+7 %1$s %2$s %3$s %4$s ",
                temp.substring(1, 4),
                temp.substring(4, 7),
                temp.substring(7, 9),
                temp.substring(9, 11));
    }

    private static boolean checkTel(String tel) {
        String temp = tel.replaceAll("[^0-9]", "");
        return temp.length() == 11;
    }

    private static boolean checkName(String name) {
        //Написать код здесь
        String[] temp = name.trim().split(" ");
        return temp.length == 3;
    }

    private static String formatName(String name) {
        //Написать код здесь
        StringBuilder str = new StringBuilder();
        String[] words = name.trim().split(" ");
        //сортируем
        sortByLength(words);
        //делаем заглавные буквы
        for (int i = 0; i < words.length; i++) {
            char upCase = words[i].charAt(0);
            if (!Character.isUpperCase(upCase)) {
                //QUESTION 3.2 создается ли новая строка в памяти если применять String.format?
                //str.append(Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1) + " ");
                //QUESTION 3.2 %10S - 10 знаков префик,постфикс?
                str.append(String.format("%S%s ", words[i].charAt(0), words[i].substring(1)));
            } else {
                str.append(words[i]);
            }
        }

        return String.valueOf(str);
    }

    private static void sortByLength(String[] words) {
        //Написать код здесь
        //QUESTION 3.2 оправдана ли сортировка StringBuilder?
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - 1; j++) {
                if (words[j].length() > words[j + 1].length()) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
    }


    //        String name = "Саша,Маша,Таня";
//
//        int x = 5;
//        int[] array = new int[11];
//
//        for (int i = 0; i < array.length; i++) {
//            array[i] = x;
//            x++;
//        }
//        System.out.println(Arrays.toString(array));
//
//        for (int item : array) {
//            System.out.println(item);
//        }
//
//
//        String[] str = name.split(",");
//
//        System.out.println(Arrays.toString(str));
//        System.out.println(str[0]);
//
//
//        String str1 = "Sometimes";
//        System.out.println(str1.charAt(2));
//
//        String name1 = "Иван Иванов";
//        String name2 = "иван ивАнов";
//        String name3 = "иван пеТРОв Иванов";
//
//
//        System.out.println(name1.equalsIgnoreCase(name2));
//        System.out.println(name1.equals(name2));
//
//        checkUserName(name1, name2);
//        checkUserName(name1, name3);
//
//        String formatString = String.format("Имена1: 1-%1$s 2-%2$s 3-%3$s", str[0], str[1], str[2]);
//        System.out.println(formatString);
//        System.out.printf("Имена2: 1-%3$S+ 2-%2$S 3-%1$S", str[0], str[1], str[2]);
//        System.out.println("");

//        // String objects
//        String team = "Iowa";
//        // modifying creates new object
//        team = team + " State";
//        System.out.println(team);
//
//        // StringBuilder object
//        StringBuilder otherTeam = new StringBuilder("University");
//        // modify same object
//        otherTeam.append(" of Northern Iowa");
//        System.out.println(otherTeam);
//
//        StringBuilder skiResort = new StringBuilder("Big Sky");
//        System.out.println(skiResort);
//
//        // Appending a string
//        skiResort.append(" Montana");
//        System.out.println(skiResort);
//
//        // Append char array
//        char[] hasCharArray = new char[]{' ', 'h', 'a', 's', ' '};
//        skiResort.append(hasCharArray);
//        System.out.println(skiResort);
//
//        // Append an int
//        skiResort.append(12);
//        System.out.println(skiResort);
//
//        // Appending another string
//        skiResort.append(" lifts.");
//        System.out.println(skiResort);
//
//        // StringBuilder has three constructors
//        StringBuilder emptyConstructor = new StringBuilder();
//        StringBuilder stringSpecified = new StringBuilder("Here is a string to start");
//        StringBuilder lengthSpecified = new StringBuilder(10);
//
//        // insert method
//        emptyConstructor.insert(0, "adding to the empty StringBuilder");
//        System.out.println(emptyConstructor);
//
//        emptyConstructor.reverse();
//        System.out.println(emptyConstructor);
//
//        // replace method
//        stringSpecified.replace(0, 4, "There");
//        System.out.println(stringSpecified);
//
//        // length method
//        System.out.println(stringSpecified.length());
//        System.out.println(lengthSpecified);
//        System.out.println(lengthSpecified.length());
//        lengthSpecified.append(1111122222);
//        System.out.println(lengthSpecified);
//        System.out.println(lengthSpecified.length());
//
//
//// the append method
//        StringBuffer javaStringBuffer = new StringBuffer("Java is ");
//        javaStringBuffer.append("Great!!");
//        System.out.println(javaStringBuffer);
//
//        // insert method
//        javaStringBuffer.insert(15, " yes..");
//        System.out.println(javaStringBuffer);
//
//        // replace method
//        javaStringBuffer.replace(13, 15, "??");
//        System.out.println(javaStringBuffer);
//
//        // reverse method
//        javaStringBuffer.reverse();
//        System.out.println(javaStringBuffer);

//    }

    private static void checkUserName(String name1, String name2) {
        if (name1.equalsIgnoreCase(name2))
            System.out.println("Выберите другое имя пользователя");
        else {
            System.out.println("Отличное Имя!!!");
            System.out.println("Длина имени:" + name2.length());
            name2 = name2.replaceAll(" ", "");
            //name2 = name2.replaceAll(' ', 'c');
            name2 = name2.replace(' ', '\u0000');
            name2 = name2.replace(" ", "");
            System.out.println("Длина без пробелов:" + name2.length());
            System.out.println(name2);
        }
    }

}
