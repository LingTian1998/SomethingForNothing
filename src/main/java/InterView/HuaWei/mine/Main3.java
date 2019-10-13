package InterView.HuaWei.mine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    private static HashSet<String> set = new HashSet<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            set.clear();

            int N = Integer.valueOf(scanner.nextLine());
            int M = Integer.valueOf(scanner.nextLine());

            HashMap<String,Integer> pathMap = new HashMap<>();

            Node[] nodes =new Node[N+1];
            for (int i=1;i<=N; i++){
                nodes[i] = new Node();
            }

            for (int i =0; i<M; i++){
                String msg = scanner.nextLine();
                String[] data = new String[4];
                data = msg.split(",");
                int node_1 = Integer.valueOf(data[0].substring(1,data[0].length()));
                int node_2 = Integer.valueOf(data[1].substring(1,data[1].length()));
                nodes[node_1].nodeHashMap.put(new Edge(data[2],Integer.valueOf(data[3])),nodes[node_2]);
                pathMap.put(data[2],Integer.valueOf(data[3]));

                nodes[node_1].node_index = node_1;
                nodes[node_2].node_index = node_2;
            }

            for (int i=1; i<=N; i++){
                for (Map.Entry<Edge,Node> entry : nodes[i].nodeHashMap.entrySet()){
                    String temp = entry.getKey().name;
                    findCircle(temp,entry.getValue());
                }
            }


            int min_edgeVal = Integer.MAX_VALUE;
            String name = "";

            for (String s: set){
                boolean ifCircle = isCircle(s);
                if (ifCircle){
                    String[] edges = s.split("A");
                    for (String string: edges){
                        String pathname = "A" + string;
                        int val = pathMap.get(pathname);

                        if (val<min_edgeVal)
                        {
                            min_edgeVal = val;
                            name = pathname;
                        }
                    }
                }
            }

            System.out.println(name);
            return;
        }
    }

    public static void findCircle(String path,Node node){
        if (!set.contains(path)){
            set.add(path);

            for (Map.Entry<Edge,Node> entry : node.nodeHashMap.entrySet()){
                String temp = path+ entry.getKey().name;
                findCircle(temp,entry.getValue());
            }
        }else {
            return;
        }

    }

    public static boolean isCircle(String data){
        char[] chars = data.toCharArray();
        char first = chars[0];
        for (int i=1; i<chars.length; i++){
            if (chars[i]==first)
                return true;
        }
        return false;
    }
}
class Node{
    int node_index;
    HashMap<Edge,Node> nodeHashMap = new HashMap<>();
}
class Edge{
    String name;
    int val;
    public Edge(String name,int val){
        this.name = name;
        this.val = val;
    }
}