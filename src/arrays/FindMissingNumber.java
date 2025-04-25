package arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,9};
        System.out.println(findMissingNumber(arr));
    }

    private static int findMissingNumber(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return (n * (n+1)/2) - sum;
    }
}
