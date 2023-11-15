package Praktikum_11_15;

public class TicTacToe {
    final char [] standartSigns= {'O','.','X'};
    final char [] texturedSigns= {'A','.','B'};

    int [] board = new int[9];
    int [] board2 = {-1,0,-1,1,1,0,0,-1,1};
    int [] board3 = {-1,0,-1,1,1,0,0,-1,1,0};
    int [] board4 = {-1,0,-1,1,1,0,0,-1,2};

    public static void main(String [] args){
        TicTacToe ttt = new TicTacToe();
        
        System.out.println(ttt.isValidBoard(ttt.board));
        System.out.println(ttt.isValidBoard(ttt.board2));
        System.out.println(ttt.isValidBoard(ttt.board3));
        System.out.println(ttt.isValidBoard(ttt.board4));
        ttt.printBoard(ttt.board2);
        System.out.println(ttt.board2String(ttt.board2, ttt.standartSigns));
        System.out.println(ttt.board2String(ttt.board2, ttt.texturedSigns));
        System.out.println(ttt.board2String(ttt.board3, ttt.standartSigns));
    }

    boolean isValidBoard(int [] board){
        for (int i : board) {
            if(!(i==-1 || i == 1 || i==0)){
                return false;
            }
        }
        return board.length == 9;
    }
    boolean checkDraw(int [] board){
        for (int i : board) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
    boolean checkWin(){
        return false;
    }
    void printBoard(int [] board){
        int ZeilenUmbruchCounter =0;
        if (isValidBoard(board)) {
            for (int i : board) {
                if(ZeilenUmbruchCounter==3){
                    System.out.println("");
                    ZeilenUmbruchCounter=0;
                }
                if (i == 1) {
                    System.out.print("X ");
                } else if(i == -1) {
                    System.out.print("O ");
                } else {
                    System.out.print("  ");
                }
                ZeilenUmbruchCounter++;
            }
        }

    }

    String board2String(int[] board, char[] symbol){
        int ZeilenUmbruchCounter =0;
        String boardString = "";
        for (int i : board) {
                if(ZeilenUmbruchCounter==3){
                    boardString += "\n";
                    ZeilenUmbruchCounter=0;
                }
                if (i == -1) {
                    boardString += symbol[0]+ " ";
                } else if(i == 0) {
                    boardString += symbol[1]+ " ";
                } else {
                    boardString += symbol[2]+ " ";
                }
                ZeilenUmbruchCounter++;
        }
        return isValidBoard(board) == false ? "invalid": "\n"+boardString;
    }

}
