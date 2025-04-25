package arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,0,0,3,2,2,3,4,0,0,0};
        moveZerosToEnd(arr);
        for(int x : arr){
            System.out.print(x + " ");
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void moveZerosToEnd(int[] ints) {
        for(int i=0,j=0; j<ints.length; j++) {
            if (ints[j] != 0) {
                swap(ints, i, j);
                i++;
            }
        }
    }
}
