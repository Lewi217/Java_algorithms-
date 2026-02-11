package sorting;

public class MergeSort {

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }

    }

    private static void merge(int[] arr, int l, int mid, int r) {

        int n1 = mid-l+1;
        int n2 = r-mid;

        int lArr[] = new int[n1];
        int rArr[] = new int[n2];

        for(int x=0; x<n1; x++){
            lArr[x] = arr[l+x];
        }
        for(int x=0; x<n2; x++){
            rArr[x] = arr[mid+1+x];
        }

        int i=0;
        int j=0;
        int k=l;

        while (i<n1 && j<n2){
            if(lArr[i]<=rArr[j]){
                arr[k] = lArr[i];
                i++;
            }
            else{
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = lArr[i];
            i++;
            k++;
        }


        while(j<n2){
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {3,5,1,4,6,2};

        for(int n : arr){
            System.out.print(n + " ");
        }

        mergeSort(arr, 0, arr.length - 1);


        System.out.println();
        System.out.println("after sorting");
        for(int n : arr){
            System.out.print(n + " ");
        }
    }



//    public static void merge(int[] arr, int left, int mid, int right) {
//        int n1 = mid - left + 1;
//        int n2 = right - mid;
//        int[] leftArr = new int[n1];
//        int[] rightArr = new int[n2];
//        for (int i = 0; i < n1; i++)
//            leftArr[i] = arr[left + i];
//
//        for (int j = 0; j < n2; j++)
//            rightArr[j] = arr[mid + 1 + j];
//
//        int i = 0, j = 0;
//        int k = left;
//        while (i < n1 && j < n2) {
//            if (leftArr[i] <= rightArr[j]) {
//                arr[k] = leftArr[i];
//                i++;
//            } else {
//                arr[k] = rightArr[j];
//                j++;
//            }
//            k++;
//        }
//
//        while (i < n1) {
//            arr[k] = leftArr[i];
//            i++;
//            k++;
//        }
//
//        while (j < n2) {
//            arr[k] = rightArr[j];
//            j++;
//            k++;
//        }
//    }
//
//    public static void mergeSort(int[] arr, int left, int right) {
//        if (left < right) {
//
//            int mid = (left + right) / 2;
//
//            mergeSort(arr, left, mid);
//            mergeSort(arr, mid + 1, right);
//            merge(arr, left, mid, right);
//        }
//    }
//
//    public static void main(String[] args) {
//
//        int[] arr = {8, 3, 5, 2, 9, 1};
//
//        System.out.println("Before sorting:");
//        for (int num : arr)
//            System.out.print(num + " ");
//
//        mergeSort(arr, 0, arr.length - 1);
//
//        System.out.println("\nAfter sorting:");
//        for (int num : arr)
//            System.out.print(num + " ");
//    }
}
