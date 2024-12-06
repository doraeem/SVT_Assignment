public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    public boolean checkCondition(int a , int b){
        return a > b;
    }

    public int[] getArray(){
        return new int[]{1,2,3};
    }

    public int generateRandomNumber(int a,int b) {
        int min = 0;
        int max = 0;
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}