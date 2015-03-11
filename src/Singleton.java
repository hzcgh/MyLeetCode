/**
 * Created by fchen on 2/22/2015.
 */
public class Singleton {
    private static Object obj;
    private Singleton(){}
    public static synchronized Object getInstance(){
        if (obj == null)
            obj = new Object();
        return obj;
    }

}
