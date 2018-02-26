package code;

public class EightQueen {
	private static final int MAX_NUM = 8;
	private int[][] board = new int[MAX_NUM][MAX_NUM];
	private int count = 0;
	public static void main(String[] args) {
		EightQueen eq = new EightQueen();
		eq.putChess(0);
	}
	
	public void putChess(int y) {
		if(y == MAX_NUM) {
			printBoard();
		}
		for(int i = 0; i < MAX_NUM; i++) {
			if(check(i, y)) {
				board[i][y] = 1;
				putChess(y+1);
				board[i][y] = 0;
			}
		}
	}
	
	public boolean check(int x, int y) {
		for(int j = 0; j < y; j++) {
			if(board[x][j] == 1) return false;
			if(x-1-j >= 0 && y-1-j >= 0 && board[x-1-j][y-1-j] == 1) return false;
			if(x+1+j < MAX_NUM && y-1-j >= 0 && board[x+1+j][y-1-j] == 1) return false;
		}
		return true;
	}
	
	public void printBoard() {
		System.out.println("========  " + ++count + "  ========");
		for(int j = 0; j < MAX_NUM; j++) {
			for(int i = 0; i < MAX_NUM; i++) {
				System.out.print(board[i][j] + "  ");
			}
			System.out.println();
		}
	}
}

