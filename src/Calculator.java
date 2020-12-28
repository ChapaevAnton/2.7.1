import java.util.Scanner;

public class Calculator {

    private Scanner enter = new Scanner(System.in);
    private Operand opr1, opr2;
    private Operator operation;

    //TODO 2.7.2*
    public void calculate() {

        float result;
        System.out.println("калькулятор\ns - выход, c - сброс");
        opr1 = new Operand(getNumber());
        do {
            operation = new Operator(getOperation());
            //FIXME возможно этот if как то можно написать по другому,
            // сделано что бы не появлялся ввод второго операнда после сброса и остановки программы
            if ((operation.getOperator() != 's') && (operation.getOperator() != 'c')) opr2 = new Operand(getNumber());
            result = getCalculate(opr1, opr2, operation);
            System.out.println(result);
            opr1.setOperand(result);

        } while (operation.getOperator() != 's');
    }

    //TODO 2.7.1
    private float getNumber() {
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

    private char getOperation() {
        char operation;
        System.out.print("Введите тип операции(+,-,*,/):");
        operation = enter.next().charAt(0);
        return operation;
    }

    private float getCalculate(Operand opr1, Operand opr2, Operator operation) {
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

            //TODO 2.7.2*
            case 'c': {
                System.out.println("Сброс!");
                this.opr1 = new Operand(getNumber());
                this.operation = new Operator(getOperation());
                //FIXME возможно этот if как то можно написать по другому,
                // сделано что бы не появлялся ввод второго операнда после сброса и остановки программы
                if ((this.operation.getOperator() != 's') && (this.operation.getOperator() != 'c')) this.opr2 = new Operand(getNumber());
                result = getCalculate(this.opr1, this.opr2, this.operation);
                break;
            }

            //TODO 2.7.2*
            case 's': {
                result = 0F;
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
