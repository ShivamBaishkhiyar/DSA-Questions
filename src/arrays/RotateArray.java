package arrays;

public class RotateArray {
    public static void main(String[] args) {
        int []arr = new int[]{1,2,3,4,5};
        rotateArray(arr,2);
        for (int x : arr){
            System.out.print(x + " ");
        }
    }
    private static void rotateArray(int[] arr, int k){
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
        reverse(arr,0, arr.length-1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
