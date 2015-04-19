/**
 * https://leetcode.com/problems/implement-strstr/
 *
 * Implementing Rabin–Karp algorithm (Rolling hash)
 *
 */
public class Strstr {
    final int p = 256;
    final int m = 101;

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;

        if (needle.length() == 0)
        {
            return 0;
        }

        int len = needle.length();
        int hash = 0;
        int targetHash = rollingHash(needle);
        for(int i=0;i<=haystack.length() - len;i++){
            if (i == 0){
                hash = rollingHash(haystack.substring(0,len));
            } else{
                hash = rollingHash(hash, haystack.charAt(i-1), haystack.charAt(i+len-1), len);  //Catch: haystack.charAt() should be i+len-1 rather than i
            }

            if (hash == targetHash){
                if (haystack.substring(i,i+len).equals(needle))
                    return i;
            }
        }

        return -1;
    }

    private int rollingHash(String str){
        int hash = 0;
        for(char c: str.toCharArray()){
            hash = (hash*p+c)%m;
        }

        return hash>=0?hash:hash+m;
    }

    private int rollingHash(int oldHash, char prev, char next, int len){
        int hash = ( (oldHash - (int)Math.pow(p,len-1)*prev)*p+next)%m;
        return hash>=0?hash:hash+m;
    }

    public static void main(String[] args) {
        System.out.println(new Strstr().strStr("mississippi", "issi"));
    }
}
