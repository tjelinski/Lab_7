package Zajecia;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int divisior = 10;
            int divider = 0;
            int result = divisior / divider;
        } catch (ArithmeticException e) {
            System.out.println("Arythmetic error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Another error: " + e.getMessage());
        } finally {
            System.out.println("Always perform, regardless of the exception");
        }
    }
}

