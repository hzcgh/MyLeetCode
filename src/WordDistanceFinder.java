import java.util.*;

class WordDistanceFinder{

    private Map<String, List<Integer>> index;

    public WordDistanceFinder(String[] input)
    {
        index = new HashMap<>();
        for(int i=0;i<input.length;i++)
        {
            if (index.get(input[i]) == null)
            {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                index.put(input[i],list);
            } else{
                List<Integer> list = index.get(input[i]);
                list.add(i);
            }
        }

    }

    public int distance(String first, String second)
    {
        if (first == null || second == null)
            return -1;

        else if (first.equals(second))
            return 0;

        List<Integer> firstList = index.get(first);
        List<Integer> secondList = index.get(second);

        if (firstList == null || secondList == null)
        {
            return -1;
        }

        List<Integer> longer;
        List<Integer> shorter;

        if (firstList.size() > second.length())
        {
            longer = firstList;
            shorter= secondList;
        } else{
            longer = secondList;
            shorter = firstList;
        }

        Integer min = Integer.MAX_VALUE;

        for(Integer i: shorter)
        {
            int ret = findMinimumVale(longer, i);
            if (ret< min)
                min = ret;
        }

        return min;

    }

    private int findMinimumVale(List<Integer> list, Integer target)
    {
        if (target > list.get(list.size()-1))
        {	// All elements in the list are smaller than target
            return target - list.get(list.size()-1);
        } else if (target < list.get(0))
        {
            // All elements in the list are larger than target
            return list.get(0) - target;
        } else{
            int index = findFirstElementLargerThanTarget(list, target, 0, list.size()-1);
            int ret1 = list.get(index) - target;
            int ret2 = target - list.get(index -1);
            return ret1<ret2? ret1:ret2;
        }
    }

    // Return the index
    public int findFirstElementLargerThanTarget(List<Integer> list, Integer target, int head, int tail)
    {
        if (list.get(head)> target)
            return head;
        else if (list.get(tail)< target )
            return -1;
        if (tail - head == 1)
            return tail;

        int mid = (head+tail)/2;

        if (list.get(mid) > target)
            return findFirstElementLargerThanTarget(list,target, head, mid);
        else if (list.get(mid) < target)
            return findFirstElementLargerThanTarget(list, target, mid, tail);
        else
            return mid;
    }

    public static void main(String[] args) {
       /* List<Integer> list= Arrays.asList(new Integer[]{3, 6, 8, 10, 13, 15});
        Integer target = 20;
        WordDistanceFinder w = new WordDistanceFinder(new String[]{});
        System.out.println(w.findFirstElementLargerThanTarget(list,target,0,list.size()-1));
    */
        WordDistanceFinder finder = new WordDistanceFinder(new String[]{"the","quick","brown","fox","something","something","quick","foo","bar","fox"});
        System.out.println(finder.distance("quick","fox"));

    }
}