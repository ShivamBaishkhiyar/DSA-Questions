package arrays;

import java.util.Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9,10,12};
        System.out.println(findMissingNumberUsingSum(arr));
        System.out.println(findMissingNumberUsingXOR(arr));
    }

    // a^a = 0, a^0=a
    private static int findMissingNumberUsingXOR(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i] ^ i;
        }
        // XOR with last element
        return res ^ arr.length;
    }

    private static int findMissingNumberUsingSum(int[] arr) {
        int n = arr.length;
        return (n * (n+1)/2) - Arrays.stream(arr).sum();
    }
}
