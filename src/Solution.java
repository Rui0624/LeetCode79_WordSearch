
public class Solution {
	public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0)
        	return false;
        char[] wordSplit = word.toCharArray();
        
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i = 0; i < board.length; i++){
        	for(int j = 0; j < board[i].length; j++){
        		visited[i][j] = false;
        	}
        }
        
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(searchDFS(board, wordSplit, 0, i, j, visited))
        			return true;
        	}
        }
        
        return false;
    }
	
	
	public boolean searchDFS(char[][] board, char[] wordSplit, int idx, int i, int j, boolean[][] visited){
		if(idx == wordSplit.length)
			return true;
		
		if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j] || board[i][j] != wordSplit[idx])
			return false;
		visited[i][j] = true;
		boolean res = searchDFS(board, wordSplit, idx + 1, i + 1, j, visited) 
					|| searchDFS(board, wordSplit, idx + 1, i, j + 1, visited) 
					||searchDFS(board, wordSplit, idx + 1, i - 1, j, visited) 
					||searchDFS(board, wordSplit, idx + 1, i, j - 1, visited);
		visited[i][j] = false;
		return res;
				
	}
}
