package arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7};
        int[] arr2 = {2,4,6,8};

        int[] arr11 = {1,3,5,7,0,0,0,0};
        int[] arr12 = {2,4,6,8};
        int m = 4, n=4;

        int[] finalArr = new int[arr1.length + arr2.length];

        mergeTwoSortedArrayWithoutExtraSpace(arr11,arr12,m,n);
        System.out.println();

        mergeTwoSortedArray(arr1,arr2,finalArr);
        for(int x : finalArr) {
            System.out.print(x + " ");
        }
    }

    // Iterate from End
    private static void mergeTwoSortedArrayWithoutExtraSpace(int[] arr1, int[] arr2, int m, int n) {
        int w = m+n-1;
        int r1=m-1, r2=n-1;
        while(w>=0){
            if(r1>=0 && r2>=0)
                arr1[w] = arr1[r1] > arr2[r2] ? arr1[r1--] : arr2[r2--];
            else if(r1>=0)
                arr1[w]=arr1[r1--];
            else
                arr1[w]=arr2[r2--];
            w--;
        }
        for(int x : arr1){
            System.out.print(x + " ");
        }
    }

    // T.C - O(N) ||| S.C - O(N)
    private static void mergeTwoSortedArray(int[] arr1, int[] arr2, int[] finalArr) {
        int i=0,j=0,k=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] <= arr2[j])
                finalArr[k++] = arr1[i++];
            else
                finalArr[k++] = arr2[j++];
        }
        while (i<arr1.length) finalArr[k++] = arr1[i++];
        while (j<arr2.length) finalArr[k++] = arr2[j++];
    }
}
