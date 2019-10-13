package before_start;

public class Solution_3 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length ==0)
            return false;
        if (matrix[0].length == 0)
            return false;

        int i=0;
        int j= matrix[i].length - 1;

        while (i < matrix.length && j>=0){
            if (matrix[i][j]>target)
                j--;
            else if (matrix[i][j]<target)
                i++;
            else
                return true;
        }
        return false;
    }
}
