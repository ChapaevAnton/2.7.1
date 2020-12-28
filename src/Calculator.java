import java.util.Scanner;

public class Calculator {

    private Scanner enter = new Scanner(System.in);

    public void calculate() {
        Operand opr1 = new Operand(getNumber());
        Operand opr2 = new Operand(getNumber());
        Operand operation = new Operand(getOperation());
        System.out.println(getCalculate(opr1, opr2, operation));


    }


//TODO 2.7.1

    public float getNumber() {
        float number;
        System.out.print("Введите число:");
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
        operation = enter.next().charAt(0);
        return operation;
    }

    public float getCalculate(Operand opr1, Operand opr2, Operand operation) {
        float result;
        switch (operation.getOperator()) {
            case '+': {
                result = opr1.getOperand() + opr2.getOperand();
                break;
            }
            case '-': {
                result = opr1.getOperand() - opr2.getOperand();
                break;
            }
            case '*': {
                result = opr1.getOperand() * opr2.getOperand();

                break;
            }
            case '/': {
                if (opr2.getOperand() != 0 && operation.getOperator() == '/') {
                    result = opr1.getOperand() / opr2.getOperand();
                } else {
                    System.out.println("Деление на ноль!!!");
                    opr2.setOperand(getNumber());
                    result = getCalculate(opr1, opr2, operation);
                }
                break;
            }
            default:
                System.out.println("Вы допустили ошибку при вводе типа операции. Попробуйте еще раз!!!");
                result = getCalculate(opr1, opr2, operation);
        }
        return result;
    }


}
