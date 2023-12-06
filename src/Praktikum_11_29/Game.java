

import java.util.Random;

public class Game {
    Cell[] board;
    int size;
    int []  directions;
    Random rnd;
   
    

    Game(int size) {

        this.size = size;

        //init CellBoard
        board = new Cell[size * size];
        for (int i = 0; i < board.length; i++) {
            board[i] = new Cell(i);
        }

        //init directions
        directions = new int[8];
        directions[0] = - (size+1); //up left DiagonalNeigbor
        directions[1] = - size;     //up Neigbor
        directions[2] = - (size-1); //up right DiagonalNeigbor
        directions[3] = - 1;        //left Neigbor 
        directions[4] = + 1;        //right Neigbor
        directions[5] = + (size+1); //down left DiagonalNeigbor
        directions[6] = + size;     //down DiagonalNeigbor
        directions[7] = + (size-1); //down right DiagonalNeigbor

        //init rnd
        rnd = new Random();
    }

    //restarts the simulation with random presets
    public void restart(int maxSimulationCycles) {
        for (int index = 0; index < board.length; index++) {
            board[index].setAlive(rnd.nextBoolean());
        }

        
        while (updateBoard() && maxSimulationCycles > 0) {
            try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
            maxSimulationCycles--;
            printBoard();
        }
    }

    //restarts the simulation with particular presets by adding int CellNumbers to which cell is alive 
    public void restart(int... aliveCellsNumbers) {
        for (Cell cell : board) {
            cell.setAlive(false);
        }
        for (int i : aliveCellsNumbers) {
            board[i].setAlive(true);
        }

        while (updateBoard()) {
            try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
            printBoard();
        }
    }

    //updates each next cycle of time of the simulation
    public boolean updateBoard(){
        addAliveNeigboursToCell();


        for (Cell cell : board) {
            if (cell.aliveNeighbors==3) {
                cell.setAlive(true);        //Hat eine unbelebte Zelle exakt 3 belebte Nachbarn, dann ist die Zelle im nächsten Zeitschritt belebt.     
            } else if (cell.aliveNeighbors<2) {
                cell.setAlive(false);       //Eine lebende Zelle mit nur einem oder keinem Nachbarn stirbt an Einsamkeit im nächsten Zeitschritt.
            } else if (cell.aliveNeighbors>3){
                cell.setAlive(false);       //Eine lebende Zelle mit mehr als drei Nachbarn stirbt im nächsten Zeitschritt an Überbevölkerung.
            }
            //an sonten "Eine lebende Zelle mit zwei oder drei Nachbarn bleibt im nächsten Zeitschritt am Leben."
        }

        return isStillRunning();
    }


    //alters the number of Neigbours a cell has that are alive 
    private void addAliveNeigboursToCell() {
        for (int i = 0; i < board.length; i++) {
            board[i].resetNeigbors();

            for (int n : directions) {
                if (i+n<0 || i+n>= board.length) { // checking if neigbour is in bounds of board arr
                    continue; 
                }
                if (i+1%size==0 || i%size==0 ) { // checking if neigbour is in bounds left
                    continue; 
                }
                if (i+1%size==0 || i%size==0 ) { // checking if neigbour is in bounds right
                    continue; 
                }

                if (board[i+n].isAlive()) {
                    board[i].addNeigbor();
                }
            }
        }
    }


    // to Check if there are any alive Cells in Board at all
    private boolean isStillRunning() {
        for (Cell cell : board) {
            if (cell.isAlive()) {
                return true;
            }
        }
        return false;
    }

    //To print out the board
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
