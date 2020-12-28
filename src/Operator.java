/**
 * Оператор
 */
public class Operator {
    private char operator;

    /**
     * Создать оператор
     * @param operator символ операции
     */
    public Operator(char operator) {
        this.operator = operator;
    }

    /**
     * Получить текущее значение оператора
     * @return operator
     */
    public char getOperator() {
        return operator;
    }

    /**
     * Установить значение оператора
     * @param operator символ операции
     */
    public void setOperator(char operator) {
        this.operator = operator;
    }
}
