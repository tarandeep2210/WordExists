package myProject;

public class WordExists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] board = {  {'A','B','C','E'},
							{'S','F','C','S'},
							{'A','D','E','E'}  };
		
		
		System.out.println(exists(board , "ABCCSD"));
	}
	
	public static boolean exists(char[][] board , String word){
		
		for(int i=0; i<board.length ; i++){
			for(int j=0; j<board[i].length ; j++){
				if(dfs( i , j , word , board , 0 )){
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	public static boolean dfs(int i , int j , String word ,char[][] board , int k){
		
		 int m = board.length;
		 int n = board[0].length;
		 
		    if(i<0 || j<0 || i>=m || j>=n){
		        return false;
		    }
		
		    if(board[i][j]==word.charAt(k)){
		    	char temp = board[i][j];
		    	board[i][j]='#';
		    	if(k==word.length()-1){
		    		return true;
		    	}
		    	else{
		    		if(dfs(i+1 , j , word , board , k+1)
		    			|| dfs(i-1 , j , word , board , k+1)
		    			|| dfs(i , j+1, word , board , k+1) 
		    			|| dfs(i , j-1 , word , board , k+1)){
		    			return true;
		    		}
		    	}
		    }
		return false;
	}
}
