/**
 * Операнд
 */
public class Operand {
    private float operand;

    /**
     * Создать операнд
     * @param operand - число типа float
     */
    public Operand(float operand) {
        this.operand = operand;
    }

    /**
     * Получить текущее значение операнда
     * @return операнда
     */
    public float getOperand() {
        return operand;
    }

    /**
     * Установить значение операнда
     * @param operand число типа float
     */
    public void setOperand(float operand) {
        this.operand = operand;
    }

}
