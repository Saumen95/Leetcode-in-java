class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int []> res = new ArrayList<int []>();
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0){
            return res;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
    
        boolean [][] visitedUpLeft = new boolean[m][n];
        LinkedList<int []> que = new LinkedList<int []>();
        for(int i = 0; i<m; i++){
            if(!visitedUpLeft[i][0]){
                visitedUpLeft[i][0] = true;
                que.add(new int[]{i, 0});
            }
        }
        
        for(int j = 0; j<n; j++){
            if(!visitedUpLeft[0][j]){
                visitedUpLeft[0][j] = true;
                que.add(new int[]{0, j});
            }
        }
        
        while(!que.isEmpty()){
            int [] cur = que.poll();
            for(int [] dir : dirs){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x<0 || x>=m || y<0 || y>=n || visitedUpLeft[x][y] || matrix[x][y]<matrix[cur[0]][cur[1]]){
                    continue;
                }
                
                visitedUpLeft[x][y] = true;
                que.add(new int[]{x, y});
            }
        }
        
        
        boolean [][] visitedLowRight = new boolean[m][n];
        for(int i = 0; i<m; i++){
            if(!visitedLowRight[i][n-1]){
                visitedLowRight[i][n-1] = true;
                que.add(new int[]{i, n-1});
            }
        }
        
        for(int j = 0; j<n; j++){
            if(!visitedLowRight[m-1][j]){
                visitedLowRight[m-1][j] = true;
                que.add(new int[]{m-1, j});
            }
        }
        
        while(!que.isEmpty()){
            int [] cur = que.poll();
            if(visitedUpLeft[cur[0]][cur[1]]){
                res.add(cur);
            }
            
            for(int [] dir : dirs){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x<0 || x>=m || y<0 || y>=n || visitedLowRight[x][y] || matrix[x][y]<matrix[cur[0]][cur[1]]){
                    continue;
                }
                
                visitedLowRight[x][y] = true;
                que.add(new int[]{x, y});
            }
        }
        
        return res;
    }
}
