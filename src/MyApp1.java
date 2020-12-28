public class MyApp1 {
    public static void main(String[] args) {


        Calculator calculator = new Calculator();
        
        Operand opr1 = new Operand(calculator.getNumber());
        Operand opr2 = new Operand(calculator.getNumber());
        System.out.println(calculator.getCalculate(opr1,opr2, calculator.getOperation()));


    }

}

