/**
 * Created by Peter on 4/9/2015.
 */
public class Strstr2 {
    int d = 256;
    int q = Integer.MAX_VALUE;

     int search(String haystack, String needle)
    {
        int M = (needle).length();
        int N = (haystack).length();
        int i, j;
        int p = 0;  // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M-1; i++)
            h = (h*d)%q;

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < M; i++)
        {
            p = (d*p + needle.charAt(i))%q;
            t = (d*t + haystack.charAt(i))%q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++)
        {

            // Check the hash values of current window of text and pattern
            // If the hash values match then only check for characters on by one
            if ( p == t )
            {
            /* Check for characters one by one */
                for (j = 0; j < M; j++)
                {
                    if (haystack.charAt(i+j) != needle.charAt(j))
                        break;
                }
                if (j == M)  // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                {
                    return i;
                }
            }

            // Calculate hash value for next window of text: Remove leading digit,
            // add trailing digit
            if ( i < N-M )
            {
                t = (d*(t - haystack.charAt(i)*h) + haystack.charAt(i+M))%q;

                // We might get negative value of t, converting it to positive
                if(t < 0)
                    t = (t + q);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Strstr2().search("mississippi", "issi"));
    }
}
