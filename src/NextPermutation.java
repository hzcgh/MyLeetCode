/**
 * Created by Peter on 3/24/2015.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0)
            return;

        int index;
        for (index = num.length - 1; index >= 0; index--) {
            if (index != num.length - 1) {
                if (num[index] < num[index + 1]) {
                    break;
                }
            }
        }

        if (index == -1) {
            // This is the largest permutation, reverse the whole array
            reverse(num, 0, num.length - 1);
            return;
        }

        int min = Integer.MAX_VALUE;
        int index2 = index;
        for (int i = num.length - 1; i >= index; i--) {
            if (num[i] > num[index]) {
                if (num[i] - num[index] < min) {
                    min = num[i] - num[index];
                    index2 = i;
                }
            }
        }


        swap(num, index, index2);
        reverse(num, index + 1, num.length - 1);

    }

    private void reverse(int[] num, int start, int end) {
        if (start >= end)
            return;
        for (int i = 0; i <= (end - start)/2; i++) {
            swap(num, start + i, end - i);
        }
    }

    private void swap(int[] num, int m, int n) {
        int tmp = num[m];
        num[m] = num[n];
        num[n] = tmp;
    }

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1,3,2});
    }
}
