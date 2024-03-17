package revise_DSA.Recursion.Backtracking;

public class K_Knights {

    public static void main(String[] args) {
        int n=4;
        boolean[][] board = new boolean[n][n];
        knights(board, 0, 0, 4);
    }

    static void knights(boolean[][] board, int row, int col, int p){
        if(p == 0){
            display(board);
            System.out.println();
            return;
        }

        if (row == board.length - 1 && col == board.length - 1) {
            return;
        }

        if(col == board.length){
            knights(board, row+1, 0, p);
            return;
        }

        if(isSafe(board, row, col)){
            board[row][col] = true;
            knights(board, row, col+1, p-1);
            board[row][col] = false;
        }

        knights(board, row, col+1, p);

    }

    static boolean isSafe(boolean[][] board, int row, int col){
        if(isValid(board, row-2, col-1)){
            if(board[row-2][col-1]){
                return false;
            }
        }

        if(isValid(board, row-1, col-2)){
            if(board[row-1][col-2]){
                return false;
            }
        }

        if(isValid(board, row-2, col+1)){
            if(board[row-2][col+1]){
                return false;
            }
        }

        if(isValid(board, row-1, col+2)){
            if(board[row-1][col+2]){
                return false;
            }
        }

        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col){
     if(row >= 0 && row < board.length && col >= 0 && col < board.length){
         return true;
     }
     return false;
    }

    static void display(boolean[][] board){
        for(boolean[] arr : board){
            for(boolean row: arr){
                if(row){
                    System.out.print("K");
                }
                else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
