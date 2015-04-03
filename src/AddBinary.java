/**
 * https://leetcode.com/problems/add-binary/
 *
 * TODO
 * My implementation pass the tests, but it can be more concise:
 * 1) don't reverse the input strings
 * 2) Only use one while loop
 * https://leetcode.com/discuss/16267/simple-accepted-java-solution
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int carry = 0;
        int i;
        for(i=0;i<a.length() && i< b.length();i++){
            int first = a.charAt(i)-'0';
            int second  = b.charAt(i)-'0';

            int sum = first + second + carry;
            switch(sum){
                case 0:
                    carry = 0;
                    sb.append("0");
                    break;
                case 1:
                    carry = 0;
                    sb.append("1");
                    break;
                case 2:
                    carry = 1;
                    sb.append("0");
                    break;
                case 3:
                    carry = 1;
                    sb.append("1");
                    break;
            }
        }

        String c = a.length() > b.length()? a:b;

        for(;i<c.length();i++){
            int sum = c.charAt(i)+carry-'0';
            if (sum==0){
                carry =0;
                sb.append(0);
            } else if (sum == 1){
                carry =0;
                sb.append(1);
            } else{
                carry = 1;
                sb.append(0);
            }
        }

        if (carry == 1)
            sb.append(1);

        StringBuilder result = new StringBuilder();

        boolean skip = true;
        for(int j=sb.length()-1;j>=0;j--){
            if (sb.charAt(j)=='1')
                skip=false;
            if (sb.charAt(j) == '0' && skip)
                continue;
            result.append(sb.charAt(j));
        }

        if (result.length() == 0)
            result.append(0);

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11","1"));
    }
}

