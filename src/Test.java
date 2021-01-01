import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        String name = "Саша,Маша,Таня";

        int x = 5;
        int[] array = new int[11];

        for (int i = 0; i < array.length; i++) {
            array[i] = x;
            x++;
        }
        System.out.println(Arrays.toString(array));

        for (int item : array) {
            System.out.println(item);
        }


        String[] str = name.split(",");

        System.out.println(Arrays.toString(str));
        System.out.println(str[0]);


        String str1 = "Sometimes";
        System.out.println(str1.charAt(2));

        String name1 = "Иван Иванов";
        String name2 = "иван ивАнов";
        String name3 = "иван пеТРОв Иванов";


        System.out.println(name1.equalsIgnoreCase(name2));
        System.out.println(name1.equals(name2));

        checkUserName(name1, name2);
        checkUserName(name1, name3);

    }

    private static void checkUserName(String name1, String name2) {
        if (name1.equalsIgnoreCase(name2))
            System.out.println("Выберите другое имя пользователя");
        else {
            System.out.println("Отличное Имя!!!");
            System.out.println("Длина имени:"+name2.length());
            name2 = name2.replaceAll(" ","");
            //name2 = name2.replaceAll(' ', 'c');
            name2 = name2.replace(' ','\u0000');
            name2 = name2.replace(" ","");
            System.out.println("Длина без пробелов:"+name2.length());
            System.out.println(name2);
        }
    }

}
