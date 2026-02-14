package searching;

public class FibonacciSearchAlgorithm {
     //Fibonacci Search method
    public static int fibonacciSearch(int[] arr, int key){

        int n = arr.length;

        //Fibonacci numbers
        int fib2 = 0;
        int fib1 = 1;
        int fib = fib1 + fib2;

        //Find smallest Fibonacci ≥ n
        while (fib < n ){
            fib2 = fib1;
            fib1 = fib;
            fib = fib1 + fib2;
        }

        int offset = -1;

        // While Fibonacci number > 1
        while (fib > 1){

            int i  = Math.min(offset + fib2, n - 1);

            // If key greater -> move left
            if(arr[i] < key){
                fib = fib1;
                fib1 = fib2;
                fib2 = fib - fib1;
                offset = i;
            }

            // If key smaller -> move left
            else if(arr[i] > key) {
                fib = fib2;
                fib1 = fib1 - fib2;
                fib2 = fib - fib1;
            }

            else{
                return i;
            }
        }

        //Check last element
        if(fib1 == 1 && arr[offset + 1] == key)
            return offset +1;

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10,22,35,40,45,50,80,90,100};
        int key = 80;
        int result = fibonacciSearch(arr, key);

        if(result >= 0)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found in the array.");
    }
}
