public class Operand {
    private float operand;
    private char operator;

    public Operand(float operand) {
        this.operand = operand;
    }

    public Operand(char operator) {
        this.operator = operator;
    }

    public float getOperand() {
        return operand;
    }

    public void setOperand(float operand) {
        this.operand = operand;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
}
