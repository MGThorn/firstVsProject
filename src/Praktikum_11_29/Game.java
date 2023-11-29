public class Game {
    Cell[] board;
    int size;
    int []  directions;

    Game(int size) {
        this.size = size;
        board = new Cell[size * size];
        for (int i = 0; i < board.length; i++) {
            board[i] = new Cell(i);
        }

        directions = new int[8];
        directions[0] = - (size+1);
        directions[1] = - size;
        directions[2] = - (size-1);
        directions[3] = - 1;
        directions[4] = + 1;
        directions[5] = + (size+1);
        directions[6] = + size;
        directions[7] = + (size-1);

         //check up left DiagonalNeigbor
         board[i-(size+1)].isAlive();
         //check up Neigbor
         board[i - size].isAlive();
         //check up right DiagonalNeigbor
         board[i - (size-1)].isAlive();
         //check left Neigbor 
         board[i - 1].isAlive();
         //check right Neigbor
         board[i + 1].isAlive();
         //check down left DiagonalNeigbor
         board[i + (size+1)].isAlive();
         //check down DiagonalNeigbor
         board[i + size].isAlive();
         //check down right DiagonalNeigbor
         board[i + (size-1)].isAlive();
    }

    public void restart(int... aliveCellsNumbers) {
        for (int i : aliveCellsNumbers) {
            board[i].setAlive(true);
        }

        while (update()) {
            printBoard();
        }
    }

    public boolean update(){
        for (int i = 0; i < board.length; i++) {
            board[i].resetNeigbors();

            for (int n : directions) {
                if (board[i+n].isAlive()) {
                    board[i].addNeigbor();
                }
            }
        }

        for (Cell cell : board) {
            if (cell.isAlive()) {
                return true;
            }
        }
    }

    public void printBoard() {
        int tempCounter = 0;
        for (Cell cell : board) {
            tempCounter++;
            if (cell.isAlive()) {
                System.out.print("[A]");
            } else {
                System.out.print("[ ]");
            }
            if (tempCounter >= this.size) {
                tempCounter -= this.size;
                System.out.println("");
            }
        }
    }
}
