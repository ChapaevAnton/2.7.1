import java.util.Scanner;

public class Calculator {

    private Scanner enter = new Scanner(System.in);
    private float result = 0F;

    //TODO 2.7.2*
    public void calculate() {
        Operand opr1 = new Operand(getNumber());

        while (true) {
            Operand opr2 = new Operand(getNumber());
            Operator operation = new Operator(getOperation());
            result = getCalculate(opr1, opr2, operation);
            System.out.println(result);
            opr1.setOperand(result);

        }
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

    public float getCalculate(Operand opr1, Operand opr2, Operator operation) {
        float result = 0F;
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
            case 'c': {
                System.out.println("Сброс!");
                result = getCalculate(
                        new Operand(getNumber()),
                        new Operand(getNumber()),
                        new Operator(getOperation()));
                break;
            }

            default:
                System.out.println("Вы допустили ошибку при вводе типа операции. Попробуйте еще раз!!!");
                operation.setOperator(getOperation());
                result = getCalculate(opr1, opr2, operation);
        }
        return result;
    }

}
