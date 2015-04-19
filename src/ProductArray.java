/**
 * http://stackoverflow.com/questions/2680548/given-an-array-of-numbers-return-array-of-products-of-all-other-numbers-no-div
 * http://www.geeksforgeeks.org/a-product-array-puzzle/
 */
public class ProductArray {
    public int[] product(int[] nums){
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int product = 1;
        for(int i=0;i<left.length;i++){
            left[i] = i==0? 1: product*nums[i-1];
            product = left[i];
        }

        product = 1;
        for(int i=right.length-1;i>=0;i--){
            right[i] = i==right.length-1? 1: product*nums[i+1];
            product = right[i];
        }

        for(int i=0;i<nums.length;i++){
            nums[i] = left[i] * right[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] ret = new ProductArray().product(new int[]{10, 3, 5, 6, 2});
        for (int i : ret) {
            System.out.println(i);
        }
    }
}
