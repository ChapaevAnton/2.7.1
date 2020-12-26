import java.util.Scanner;

public class Calculator {

//FIXME Задание 2.7.2* Недоработано, смысл в том что бы вводить C или S в любой момент.
    public void calculate() {

        float result;

        Operand opr1 = new Operand(getNumber());
        Operand opr2 = new Operand(getNumber());
        Scanner enter = new Scanner(System.in);
        do {
            result = getCalculate(opr1, opr2, getOperation());
            System.out.println(result);

        } while (enter.next().charAt(0)!='s');

    }

    private float getNumber() {
        float number;
        System.out.print("Введите число:");
        Scanner enter = new Scanner(System.in);
        if (enter.hasNextFloat()) {
            number = enter.nextFloat();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз!!!");
            enter.next();
            number = getNumber();
        }
        return number;
    }

    private char getOperation() {
        char operation;
        System.out.print("Введите тип операции(+,-,*,/):");
        Scanner enter = new Scanner(System.in);
        operation = enter.next().charAt(0);
        return operation;
    }

    private float getCalculate(Operand opr1, Operand opr2, char operator) {
        float result = 0F;
        switch (operator) {
            case '+': {
                result = opr1.getOpr() + opr2.getOpr();
                break;
            }
            case '-': {
                result = opr1.getOpr() - opr2.getOpr();
                break;
            }
            case '*': {
                result = opr1.getOpr() * opr2.getOpr();

                break;
            }
            case '/': {
                if (opr2.getOpr() != 0) {
                    result = opr1.getOpr() / opr2.getOpr();
                } else {
                    System.out.println("Деление на ноль!!!");
                }
                break;
            }
            default:
                System.out.println("Вы допустили ошибку при вводе типа операции. Попробуйте еще раз!!!");
                result = getCalculate(opr1, opr2, getOperation());
        }
        return result;
    }


}
