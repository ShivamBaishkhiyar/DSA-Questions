package arrays;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        removeDuplicateFromSortedArray(new int[]{1,2,3,3,4,5,5,6,6,6,6,12,12,12,13,14,15});
    }

    private static void removeDuplicateFromSortedArray(int[] arr) {
        int i=1;
        int j=0;
        while(i<arr.length){
            if(arr[i]!=arr[i-1]) {
                j++;
                arr[j] = arr[i];
            }
            i++;
        }
        for(int l=0;l<=j;l++)
            System.out.print(arr[l] + " ");
    }
}
