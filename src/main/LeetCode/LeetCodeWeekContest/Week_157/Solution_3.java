package Week_157;

public class Solution_3 {
    public int getMaximumGold(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (isValid(i,j,grid))
                    max = Math.max(max,DFS(i,j,grid));
            }
        }
        return max;
    }
    // 比较笨重的解
    public int dfs (int x, int y ,int[][] grid, int[][] map){
        map[x][y] = 1;
        int max = Integer.MIN_VALUE;
        if (x+1 < grid.length && grid[x+1][y] != 0 && map[x+1][y] != 1){
            int temp = dfs(x+1,y,grid,map);
            if (temp>max)
                max = temp;
        }

        if (x-1 >=0 && grid[x-1][y] != 0 && map[x-1][y] != 1){
            int temp = dfs(x-1,y,grid,map);
            if (temp > max)
                max = temp;
        }

        if (y+1 <grid[0].length && grid[x][y+1] != 0 && map[x][y+1] != 1){
            int temp = dfs(x, y+1, grid,map);
            if (temp >max)
                max = temp;
        }

        if (y-1 >=0 && grid[x][y-1] != 0 && map[x][y-1] !=1){
            int temp = dfs (x, y-1, grid, map);
            if (temp>max)
                max = temp;
        }

        if (max < 0)
            max = 0;

        map[x][y] = 0;    //深度优先遍历 需要回溯， 回溯后 路径应该清空
        return grid[x][y]+max;
    }

    //比较优雅的方式
    public static final int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int DFS(int x,int y, int[][] grid){
        if (x<0||y<0||x>=grid.length|| y>=grid[0].length|| grid[x][y] ==0)
            return 0;

        int val = grid[x][y];
        grid[x][y] = 0;
        int res = 0;
        for (int[] dir: dirs){
            int next_x = x+dir[0];
            int next_y = y+dir[1];
            res = Math.max(res, DFS(next_x,next_y,grid));
        }
        grid[x][y] = val;
        return res+val;
    }

    public static boolean isValid(int x, int y, int[][] grid){
        int x_up = x-1;
        int x_down = x+1;
        int y_left = y-1;
        int y_right = y+1;

        if (x_up>=0&&x_down<grid.length&& grid[x_up][y]>0 &&grid[x_down][y]>0)
            return false;
        if (y_left>=0 && y_right<grid[0].length &&grid[x][y_left]>0 && grid[x][y_right]>0)
            return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_3().getMaximumGold(new int[][]{{0,6,0},{5,8,7},{0,9,0}}));
    }
}
