import java.util.Stack;

/**
 * Created by fchen on 2/15/2015.
 */
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)){
                if (stack.size() <2)
                    throw new IllegalArgumentException();
                Integer n2 = stack.pop();
                Integer n1 = stack.pop();
                Integer ret = null;

                switch (token){
                    case "+":
                        ret = n1+n2;
                        break;
                    case "-":
                        ret = n1 - n2;
                        break;
                    case "*":
                        ret  = n1 * n2;
                        break;
                    case "/":
                        if (n2 == 0)
                            throw  new ArithmeticException();
                        ret = n1 / n2;
                        break;
                }
                stack.push(ret);
            } else {
                try {
                    Integer n = Integer.parseInt(token);
                    stack.push(n);

                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }
        }

        if (stack.size()!=1)
            throw new IllegalArgumentException();

        return stack.pop();
    }
}
