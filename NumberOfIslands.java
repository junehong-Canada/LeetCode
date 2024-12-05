/**
  Using DFS(Depth First Search)
*/

public class NumberOfIslands {
  // A utility function to do DFS for a 2D
  //  boolean matrix. It only considers
  //  the 8 neighbours as adjacent vertices
  static void DFS(int[][] M, int i, int j, int ROW, int COL) {
    // Base condition
    // if i less than 0 or j less than 0 or
    // i greater than ROW-1 or j greater than COL-
    // or if M[i][j] != 1 then we will simply return
    if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != 1)
      return;

    if (M[i][j] == 1) {
      M[i][j] = 0;
      DFS(M, i + 1, j, ROW, COL);     //right side traversal
      DFS(M, i - 1, j, ROW, COL);     //left side traversal
      DFS(M, i, j + 1, ROW, COL);     //upward side traversal
      DFS(M, i, j - 1, ROW, COL);     //downward side traversal
      DFS(M, i + 1, j + 1, ROW, COL); //upward-right side traversal
      DFS(M, i - 1, j - 1, ROW, COL); //downward-left side traversal
      DFS(M, i + 1, j - 1, ROW, COL); //downward-right side traversal
      DFS(M, i - 1, j + 1, ROW, COL); //upward-left side traversal
    }
  }

  static int countIslands(int[][] M) {
    int ROW = M.length;
    int COL = M[0].length;
    int count = 0;

    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COL; j++) {
        if (M[i][j] == 1) {
          M[i][j] = 0;
          count++;
          DFS(M, i + 1, j, ROW, COL);     //right side traversal
          DFS(M, i - 1, j, ROW, COL);     //left side traversal
          DFS(M, i, j + 1, ROW, COL);     //upward side traversal
          DFS(M, i, j - 1, ROW, COL);     //downward side traversal
          DFS(M, i + 1, j + 1, ROW, COL); //upward-right side traversal
          DFS(M, i - 1, j - 1, ROW, COL); //downward-left side traversal
          DFS(M, i + 1, j - 1, ROW, COL); //downward-right side traversal
          DFS(M, i - 1, j + 1, ROW, COL); //upward-left side traversal
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] M = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

    System.out.println("Number of islands is: " + countIslands(M));
  }
}

/**
public class NumberOfIslands {
  static final int ROW = 5, COL = 5;

  boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
    return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
  }

  void DFS(int M[][], int row, int col, boolean visited[][]) {
    int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1};
    int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1};

    visited[row][col] = true;

    for (int k = 0; k < 8; ++k) {
      if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
        DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }
  }

  int countIslands(int M[][]) {
    boolean visited[][] = new boolean[ROW][COL];

    int count = 0;
    for (int i = 0; i < ROW; ++i) {
      for (int j = 0; j < COL; ++j) {
        if (M[i][j] == 1 && !visited[i][j])
        {
          DFS(M, i, j, visited);
          ++count;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
      int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                                { 0, 1, 0, 0, 1 },
                                { 1, 0, 0, 1, 1 },
                                { 0, 0, 0, 0, 0 },
                                { 1, 0, 1, 0, 1 } };

      NumberOfIslands I = new NumberOfIslands();
      System.out.println("Number od islands is: " + I.countIslands(M));
  }
}
*/

/**
 * Given an m x n 2D binary grid which represents a map of '1's (lad) and '0's (water),
 * return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrouded by water.
 *
 * Example 1:
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 */

/**
Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1}}
Output : 5
*/
