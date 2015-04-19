package Booking.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Peter on 4/10/2015.
 */
public class BookingCodingTest {


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num;
        int[] progression;

        num = Integer.valueOf(in.readLine());
        progression = new int[num];
        String[] tmp = in.readLine().split(" ");
        for(int i=0;i<num;i++){
            progression[i] = Integer.valueOf(tmp[i]);
        }
       // progression = Arrays.stream( in.readLine().split(" ")).mapToInt(i->Integer.valueOf(i)).toArray();

        Map<Integer,Integer> map = new HashMap<>();


        int diff = 0;
        int first = progression[0];
        if (progression[1] - progression[0] == progression[2] - progression[1]){
            diff = progression[1] - progression[0];

            int start = 0;
            int end = num - 1;

            while (end - start > 1){
                int mid  = start + (end-start)/2;
                if (progression[mid] == first+mid*diff){
                    start = mid;
                } else{
                    end = mid;
                }
            }

            System.out.println(first+end*diff);
        }
        else {
            int firstDiff = progression[1] - progression[0];
            int secondDiff = progression[2] - progression[1];
            int thirdDiff = progression[3] - progression[2];

            if (thirdDiff == firstDiff){
                System.out.println(first+thirdDiff*2);
            } else{
                System.out.println(first+thirdDiff);
            }
        }
    }
}
