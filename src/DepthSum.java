import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * http://www.careercup.com/question?id=5670717928505344
 */
public class DepthSum {
    public interface NestedInteger{
        boolean isInteger();
        Integer getInteger();
        List<NestedInteger> getList();
    }

    class ComplexInteger{
        private int level = 1;
        private NestedInteger nestedInteger;

        public ComplexInteger(int level, NestedInteger n){
            this.level = level;
            this.nestedInteger = n;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public NestedInteger getNestedInteger() {
            return nestedInteger;
        }

        public void setNestedInteger(NestedInteger nestedInteger) {
            this.nestedInteger = nestedInteger;
        }
    }

    static class NestedIntegerImpl implements NestedInteger{
        Object value;

        public NestedIntegerImpl(Object object){
            this.value = object;
        }

        @Override
        public boolean isInteger() {
            return !(value instanceof List);
        }

        @Override
        public Integer getInteger() {
            return (Integer) value;
        }

        @Override
        public List<NestedInteger> getList() {
            return (List<NestedInteger>) value;
        }
    }

    public int depthSum(List<NestedInteger> input){
        Stack<ComplexInteger> stack = new Stack<>();
        Integer sum = 0;

        for(NestedInteger n:input){
            if (n.isInteger())
                sum+=n.getInteger();
            else{
                stack.push(new ComplexInteger(1,n));
            }
        }

        while(!stack.isEmpty()){
            ComplexInteger complex  = stack.pop();
            NestedInteger nestedInteger = complex.getNestedInteger();
            if (nestedInteger.isInteger()){
                sum+= nestedInteger.getInteger()* complex.getLevel();
            } else{
                List<NestedInteger> list = nestedInteger.getList();
                for(NestedInteger n:list){
                    stack.push(new ComplexInteger(complex.getLevel()+1, n));
                }
            }
        }

        return sum;
    }

    public  static void main(String[] args){
        {
            //{{1,1},2,{1,1}}
            final NestedInteger n1 = new NestedIntegerImpl(1);
            final NestedInteger n2 = new NestedIntegerImpl(1);
            final NestedInteger n3 = new NestedIntegerImpl(2);

            final NestedInteger n4 = new NestedIntegerImpl(new ArrayList<NestedInteger>() {{
                add(n1);
                add(n2);
            }});

            List<NestedInteger> input1 = new ArrayList<NestedInteger>() {{
                add(n4);
                add(n3);
                add(n4);
            }};

            DepthSum d = new DepthSum();
            System.out.println(d.depthSum(input1));
        }
        {
            //{1,{4,{6}}}
            final NestedInteger n1 = new NestedIntegerImpl(6);
            final NestedInteger n2 = new NestedIntegerImpl(new ArrayList<NestedInteger>(){{
                add(n1);
            }});
            final NestedInteger n3 = new NestedIntegerImpl(new ArrayList<NestedInteger>(){{
                add(new NestedIntegerImpl(4));
                add(n2);
            }});
            List<NestedInteger> input2 = new ArrayList<NestedInteger>(){{
               add(new NestedIntegerImpl(1));
                add(n3);
            }};
            DepthSum d = new DepthSum();

            System.out.println(d.depthSum(input2));
        }

    }

}
