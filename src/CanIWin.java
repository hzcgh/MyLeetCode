import java.util.HashSet;
import java.util.Set;

/**
 * Created by fchen on 2/28/2015.
 */
public class CanIWin {
    Boolean canIWin(int maxChooseableInteger, int desiredTotal)
    {
        return canIWin(maxChooseableInteger, desiredTotal, new HashSet<>(), 0);
    }

    Boolean canIWin(int maxChooseableInteger, int desireTotal, Set<Integer> alreadyUsed, int currentTotal)
    {
        for(int i=maxChooseableInteger;i>=1;i--)
        {
            if (alreadyUsed.contains(i))
                continue;
            if (currentTotal+i>=desireTotal)
                return true;
            else
            {
                Set<Integer> alreadyUsedNew = new HashSet<>(alreadyUsed);
                alreadyUsedNew.add(i);
                if (canIWin(maxChooseableInteger, desireTotal, alreadyUsedNew, currentTotal+i) == false) // There's no way for second player to win
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanIWin c = new CanIWin();
        System.out.println(c.canIWin(5,12));
    }

}
