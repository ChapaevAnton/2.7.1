import java.util.Scanner;

public class Calculator {

    //FIXME Задание 2.7.2* Недоработано, смысл в том что бы вводить C или S в любой момент.
//    public void calculate() {
//
//
//
//    }

    //OPTIMIZE
//TODO
//FIXME Нужно переработать этот метод так чтобы цикл на потоврение ввода
// был внутри него, и прерывать его как только 'c'
    public float getNumber() {
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

    public char getOperation() {
        char operation;
        System.out.print("Введите тип операции(+,-,*,/):");
        Scanner enter = new Scanner(System.in);
        operation = enter.next().charAt(0);
        return operation;
    }

    public float getCalculate(Operand opr1, Operand opr2, char operator) {
        float result;
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
                if (opr2.getOpr() != 0 && operator == '/') {
                    result = opr1.getOpr() / opr2.getOpr();
                } else {
                    System.out.println("Деление на ноль!!!");
                    opr2.setOpr(getNumber());
                    result = getCalculate(opr1, opr2, getOperation());
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
