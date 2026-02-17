package searching;

public class BinarySearch {

    // Binary Search Method
    public static int binarySearch(int[] arr, int key){

       int left = 0;
       int right = arr.length - 1;

       while(left <= right){

           int mid = (left + right )/2;

           // if element found
           if(arr[mid] == key){
               return mid;
           }
           // If key is greater -> search right
           else if (arr[mid] < key){
               left = mid +1;
           }
           else {
               right = mid -1;
           }
       }
       return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 25, 30, 35};

        int key = 25;

        int result = binarySearch(arr, key);

        if(result != -1){
            System.out.println("Element found at index: " + result);
        }else {
            System.out.println("Element not found");
        }
    }
}
