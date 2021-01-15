
public class MySwitchEnums {

    //TODO Логическое перечисление
    private enum Logical {
        TRUE(true),
        FALSE(false);

        private boolean bool;

        Logical(boolean bool) {
            this.bool = bool;
        }

        private boolean getLogical() {
            return bool;
        }

        private void setLogical(boolean bool) {
            this.bool = bool;
        }

        @Override
        public String toString() {

            if (getLogical()) return "Истина";
            else return "Ложь";
        }
    }

    //TODO Дни недели
    private enum Day {
        SUNDAY("Воскресенье"),
        MONDAY("Понедельник"),
        TUESDAY("Вторник"),
        WEDNESDAY("Среда"),
        THURSDAY("Четверг"),
        FRIDAY("Пятница"),
        SATURDAY("Суббота"),
        NO_DAY("Несуществующий день недели");

        private String day;

        Day(String day) {
            this.day = day;
        }

        @Override
        public String toString() {
            return day;
        }
    }

    //TODO Enum с использованием лямбда-выражений
    @FunctionalInterface
    interface Calculate {
        int operation(int x, int y);
    }

    private enum Calc //implements Calculate
    {
        PLUS(((x, y) -> x + y)),
        MINUS(((x, y) -> x - y)),
        MULTI(((x, y) -> x * y)),
        DIV(((x, y) -> x / y));

        //TODO лямбда
        private Calculate calculate;

        Calc(Calculate calculate) {
            this.calculate = calculate;
        }

        //@Override
        private int operation(int x, int y) {
            return calculate.operation(x, y);
        }
    }

    public static void main(String[] args) {

        //TODO alpha expressions across Enums

        System.out.println(Calc.PLUS.operation(4, 4));
        System.out.println(Calc.MINUS.operation(10, 4));
        System.out.println(Calc.MULTI.operation(10, 4));
        System.out.println(Calc.DIV.operation(24, 4));

        //TODO switch for boolean
        Logical logical = Logical.FALSE;
        logical.setLogical(true);

        String strLogical = switch (logical) {
            case TRUE, FALSE -> {
                System.out.println(logical.getLogical());
                yield logical.toString();
            }
        };
        System.out.println(strLogical);

        //TODO switch alternative for String across Enums
        Day day = Day.NO_DAY;

        switch (day) {
            case FRIDAY -> System.out.println("Hooray!!!!" + day);
            case SATURDAY, SUNDAY -> System.out.println("Выходной день:" + day);
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> System.out.println("Рабочий день:" + day);
            default -> System.out.println(day);
        }

        //TODO switch for String
        String str = "понедельник";
        int i = switch (str) {
            case "понедельник", "вторник", "среда", "четверг" -> {
                System.out.println("Будние дни");
                yield 2;
            }
            case "суббота", "воскресень" -> {
                System.out.println("Выходные");
                yield 1;
            }

            default -> {
                System.out.println("Нет такого дня недели");
                yield 0;
            }
        };
        System.out.println(i);

    }

}

