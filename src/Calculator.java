import java.util.Scanner;

/**
 * Калькулятор
 */
public class Calculator {


    private final Scanner enter = new Scanner(System.in);
    private Operand opr1, opr2;
    private Operator operation;

    //TODO 2.7.2*
    /**
     * Запуск калькулятора
     */
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
    /**
     * Ввод значения операнда
     * @return number - возвращает введенное число типа float
     */
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

    /**
     * Ввод значения оператора
     * @return operation - возвращает символ введенной операции char - lowercase
     */
    private char getOperation() {
        char operation;
        System.out.print("Введите тип операции(+,-,*,/):");
        operation = enter.next().charAt(0);
        return Character.toLowerCase(operation);
    }

    /**
     * Результат вычисления в завивисимости от выбранно операции
     * @param opr1 операнд 1
     * @param opr2 опернад 2
     * @param operation тип операции (+-/*) с - сброс , s - стоп
     * @return result возвращает результат вычислений float
     */
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
                if ((this.operation.getOperator() != 's') && (this.operation.getOperator() != 'c'))
                    this.opr2 = new Operand(getNumber());
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
