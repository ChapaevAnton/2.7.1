public class MySwitch {

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

        @Override
        public String toString() {

            if (getLogical()) return "Истина";
            else return "Ложь";
        }
    }

    public static void main(String[] args) {

        Logical logical = Logical.FALSE;

        String strLogical = switch (logical) {
            case TRUE, FALSE -> {
                System.out.println(logical.getLogical());
                yield logical.toString();
            }
        };

        System.out.println(strLogical);


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

