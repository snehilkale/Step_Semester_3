package assignment;
public class problem1 {

    public static void busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            System.out.println("Row 0, Total 0");
            return;
        }

        int bestRowIndex = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int currentRowTotal = 0;
            for (int j = 0; j < grid[i].length; j++) {
                currentRowTotal += grid[i][j];
            }

            if (currentRowTotal > maxTotal) {
                maxTotal = currentRowTotal;
                bestRowIndex = i;
            }
        }

        System.out.println("Row " + bestRowIndex + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        busiestRow(grid);
    }
}
