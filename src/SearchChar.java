import java.util.Stack;

/**
 * http://www.careercup.com/question?id=5726366532108288
 */
public class SearchChar {
    public char searchChar(char[] sortedStr, char c)
    {
        int length = sortedStr.length;
        if (c>= sortedStr[length-1] || c<sortedStr[0])
            return sortedStr[0];
        else
        {
/*
            return searchChar(sortedStr, c, 0, length-1);
*/
            return searchCharIterative(sortedStr, c);
        }
    }

    public char searchChar(char[] sortedStr, char c, int start, int end)
    {
        if (start>=end)
            return sortedStr[end];

        int mid = (start+end)/2;

        if (sortedStr[mid] == c)
            return sortedStr[mid+1];
        else if (sortedStr[mid] > c)
        {
            return searchChar(sortedStr, c, start, mid);
        } else
        {
            return searchChar(sortedStr, c, mid+1, end);
        }
    }

    public char searchCharIterative(char[] sortedStr, char c){
        int start = 0;
        int end = sortedStr.length-1;

        while(start<end){
            int mid = (start+end)/2;
            if (sortedStr[mid] == c)
                return sortedStr[mid+1];
            else if (sortedStr[mid] > c){
                end = mid;
            } else{
                start = mid+1;
            }
        }
        return sortedStr[end];
    }

    public static void main(String[] args) {
        SearchChar s = new SearchChar();
        System.out.println(s.searchChar("cfjpv".toCharArray(),'a'));
        System.out.println(s.searchChar("cfjpv".toCharArray(),'c'));
        System.out.println(s.searchChar("cfjpv".toCharArray(),'k'));
        System.out.println(s.searchChar("cfjpv".toCharArray(),'z'));
        System.out.println(s.searchChar("cfk".toCharArray(),'f'));
        System.out.println(s.searchChar("cfk".toCharArray(),'c'));
        System.out.println(s.searchChar("cfk".toCharArray(),'d'));
        System.out.println(s.searchChar("acegi".toCharArray(),'f'));

/*        Stack<String> s = new Stack<>();
        s.push(null);
        s.push(null);
        System.out.println(s.size());
        s.pop();
        System.out.println(s.size());*/
    }

/*    public boolean isSameTree(TreeNode p, TreeNode q) {
*//*        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        if (p.val!=q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);*//*

        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();

        stackP.push(p);
        stackQ.push(q);

        while (stackP.size()!=0 && stackQ.size()!=0){
            TreeNode newP = stackP.pop();
            TreeNode newQ = stackQ.pop();

            if (newP == null && newQ == null)
                continue;
            else if (newP == null || newQ == null)
                return false;

            if (newP.val != newQ.val)
                return false;

            stackP.push(newP.left);
            stackP.push(newP.right);

            stackQ.push(newQ.left);
            stackQ.push(newQ.right);
        }

        if (stackP.size() == 0 && stackQ.size() == 0)
            return true;
        else
            return false;
    }

     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
     }*/
}
