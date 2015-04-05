import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/word-ladder/
 *
 * Lesson learned:
 * How to backtracking while BFS?
 * It's not sufficient to just save the node to a queue, we have save all the paths in the queue;
 * So the queue will look like:
 * {
 *     [node1, node2...node9],
 *     [node1, node2...node10],
 *     [node1, node3...node11]
 *     ...
 * }
 *
 */
public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (oneEditDistance(start, end))
            return 2;

        if (dict.size()==0)
            return 0;

        dict.remove(start);

        Deque<List<String>> queue = new LinkedList<>();
        List<String> list = new LinkedList<>();
        list.add(start);
        queue.add(list);

        while(!queue.isEmpty()){
            List<String> path = queue.poll();
            String node = path.get(path.size()-1);  // find all the adjacent nodes of the last node (i.e. current node)
            Set<String> next = dict.stream().filter(s->oneEditDistance(s,node)).collect(Collectors.toSet());
            dict.removeAll(next);

            for(String s:next){
                List<String> newPath = new LinkedList<>(path);
                newPath.add(s);
                queue.add(newPath);
                if (next.contains(end))
                    return queue.getLast().size();
            }
        }

        return 0;

    }

    public boolean oneEditDistance(String s1, String s2){
        int distance = 0;
        for(int i=0;i<s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i))
                distance++;
        }
        return distance == 1;

    }

    public static void main(String[] args) {
        /*System.out.println(new WordLadder().ladderLength("hit", "cog", new HashSet<>( Arrays.asList("hit","hot","dot","dog","lot","log","cog"))));
        */
        System.out.println(new WordLadder().ladderLength("nape", "mild", new HashSet<>( Arrays.asList("dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"))));
    }
}
