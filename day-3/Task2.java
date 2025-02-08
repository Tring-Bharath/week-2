public class Task2 {

    public static void divide(int a, int b) {
        try {
            a=a/b;
        } catch (ArithmeticException e) {
            System.err.println("Division by zero is not allowed.");
        }
    }
    public static void array(int[] arr, int index) {
        try {
            arr[index]++;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array index out of bounds.");
        }
    }
    public static void Number(String str) {
        try {
            int b=Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number");
        }
    }
    public static int a()
    {
        return a();
    }
    public static void main(String[] args) {
        divide(10,0);  
        int[] arr={1,2,3};
        array(arr,5);
        try{
        a();
        }
        catch(StackOverflowError e)
        {
            System.err.println("Infinite Recursion");
        }
        Number("a");
    }
}
