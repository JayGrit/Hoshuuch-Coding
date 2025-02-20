public class ExceptionDemo {


    public static void main(String[] args) {
        method();
    }


    public static void method() {
        try {
            throw new ArithmeticException();
        } catch (Exception e) {
            System.out.println("ready to throw");
        } finally {
            System.out.println("do nothing");
        }
    }


}
