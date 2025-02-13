// https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/

public class SearchWordInMatrix {

	// Rows and columns in given grid
	static int R, C;

	// For searching in all 8 direction
	static int[] xdir = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] ydir = { -1, 0, 1, -1, 1, -1, 0, 1 };

	// This function searches in all 8-direction from point
	// (row, col) in grid[][]
	static boolean search2D(char[][] ch, int row, int col, String word) {
		// If first character of word doesn't match with
		// given starting point in grid.
		if (ch[row][col] != word.charAt(0))
			return false;

		int len = word.length();

		// Search word in all 8 directions
		// starting from (row,col)
		for (int dir = 0; dir < 8; dir++) {
			// Initialize starting point
			// for current direction
			int k, rowdir = row + xdir[dir], coldir = col + ydir[dir];

			// First character is already checked,
			// match remaining characters
			for (k = 1; k < len; k++) {
				// If out of bound break
				if (rowdir >= R || rowdir < 0 || coldir >= C || coldir < 0)
					break;

				// If not matched, break
				if (ch[rowdir][coldir] != word.charAt(k))
					break;

				// Moving in particular direction
				rowdir += xdir[dir];
				coldir += ydir[dir];
			}

			// If all character matched, then value of must
			// be equal to length of word
			if (k == len)
				return true;
		}
		return false;
	}

	// Searches given word in a given
	// matrix in all 8 directions
	static void patternSearch(char[][] grid, String word) {
		// Consider every point as starting
		// point and search given word
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (search2D(grid, row, col, word))
					System.out.println("pattern found at " + row + ", " + col);
			}
		}
	}

	public static void main(String[] args) {

		R = 3;
		C = 13;
		char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
				{ 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
				{ 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
		patternSearch(grid, "GEEKS");

	}

}
