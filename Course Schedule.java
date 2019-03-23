import java.util.LinkedList;
import java.util.Queue;

class Solution{
    // can anyone finish?
    public boolean canfinish(int numCourses, int[][]prerequisites){
        int[]map = new int[numCourses];
        for(int i = 0;i<prerequisites.length; i++){
            map[prerequisites[i][i]]++;
        }
        // mapping all coursese in a map
        Queue<Integer>que = new LinkedList<Integer>();
        for (int i= 0; i< map.length; i++){
            if(map[i] = 0)
            que.add(i);
        }
        // counting prereq
        int count = que.size();
        while(que.isEmpty()){
            int k = que.remove();
            for(int i = 0; i<prerequisites.length; i++){
                if(k == prerequisites[i][0]){
                    int l = prerequisites[i][1];
                    map[l]--;
                    if(map[l]== 0){
                        que.add(l);
                        ++count;
                    }
                }
            }
        }
        return count == numCourses;
    }
}