// C++ implementation of the solution to count the number of islands in a 2D binary grid using Depth-First Search (DFS)

// If we are allowed to modify the original matrix, we can avoid an additional visited matrix.
// Whenever we visit a cell in matrix, we change its value to 0 so that it is not visited again

#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    void dfs(vector<vector<char>>& grid, int i, int j) {
        // Base condition: check for out-of-bounds or water.
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] == '0') {
            return;
        }

        // Mark the current cell as visited.
        grid[i][j] = '0';

        // Explore all four directions.
        dfs(grid, i + 1, j); // Down
        dfs(grid, i - 1, j); // Up
        dfs(grid, i, j + 1); // Right
        dfs(grid, i, j - 1); // Left
    }

    int numIslands(vector<vector<char>>& grid) {
        if (grid.empty()) return 0;

        int num_islands = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == '1') { // New island found
                    num_islands++;
                    dfs(grid, i, j); // Mark all parts of the island as visited.
                }
            }
        }
        return num_islands;
    }
};

int main() {
    Solution solution;
    vector<vector<char>> grid = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    };

    cout << "Number of islands: " << solution.numIslands(grid) << endl; // Output: 3

    grid = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };

    cout << "Number of islands: " << solution.numIslands(grid) << endl; // Output: 1

    return 0;
}

/*
Explanation
	1.	DFS Function:
	•	The dfs function is a helper that recursively marks all connected ‘1’s in the grid as ‘0’ (visited). It stops recursion for out-of-bounds indices or cells with ‘0’.
	2.	Iterating Through the Grid:
	•	The main function numIslands loops through all cells in the grid.
	•	If a cell with ‘1’ is encountered, it indicates the start of a new island. Increment the count of islands and call dfs to mark the entire island.
	3.	Base Conditions:
	•	The dfs function stops processing when indices are out of bounds or when a cell contains ‘0’.
	4.	Input and Output:
	•	The grid is modified in place during the DFS traversal.
	•	The total count of islands is returned.

Complexity
	•	Time Complexity: O(m*n), where m is the number of rows and n is the number of columns. Each cell is visited once.
	•	Space Complexity: O(m*n) for the recursion stack in the worst case when all cells are land.

Edge Cases
	1.	Empty grid:
	•	Input: grid = {} or grid = {{}}
	•	Output: 0
	2.	No land:
	•	Input: grid = {{'0', '0'}, {'0', '0'}}
	•	Output: 0
	3.	All land:
	•	Input: grid = {{'1', '1'}, {'1', '1'}}
	•	Output: 1
*/
