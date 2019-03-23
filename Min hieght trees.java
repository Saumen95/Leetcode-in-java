import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        int minHeight = Integer.MAX_VALUE;
        HashMap<Integer,List<Integer>> neighbors = new HashMap<>();
        for(int i=0;i<edges.length;i++){  
            if(neighbors.containsKey(edges[i][0])){
                neighbors.get(edges[i][0]).add(edges[i][1]);
            }else{
                List<Integer>  list = new ArrayList<>();
                list.add(edges[i][1]);
                neighbors.put(edges[i][0],list);
            }
            if(neighbors.containsKey(edges[i][1])){
                neighbors.get(edges[i][1]).add(edges[i][0]);
            }else{
                List<Integer>  list = new ArrayList<>();
                list.add(edges[i][0]);
                neighbors.put(edges[i][1],list);
            }
        }
        for(int i=0;i<n;i++){
            int max = 0;  
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> tempQueue = new LinkedList<>();  
            queue.add(i);
            max++;
            while(!queue.isEmpty()||!tempQueue.isEmpty()){
                if(!queue.isEmpty()){  
                    int a = queue.poll();
                    visited[a] = true;
                    if(neighbors.get(a)!=null){
                        for(int j=0;j<neighbors.get(a).size();j++){
                            int neighbor = neighbors.get(a).get(j);
                            if(!visited[neighbor]) tempQueue.add(neighbor);
                        }
                    }
                }else{ 
                    if(!tempQueue.isEmpty()) 
                        max++;
                    queue = new LinkedList<>(tempQueue);
                    tempQueue.clear();;
                }
            }
            if(max<minHeight){
                minHeight=max;
                res.clear();
                res.add(i);
            }else if(max==minHeight){
                res.add(i);
            }
        }
        return res;
    }
}