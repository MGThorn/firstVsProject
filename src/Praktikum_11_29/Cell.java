public class Cell {
    private boolean alive;
    int cellNumber;
    int aliveNeighbors;

    Cell(int cellNumber){
        this.cellNumber = cellNumber;
        this.alive = false;
        this.aliveNeighbors = 0;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void addNeigbor(){
        aliveNeighbors++; 
    }

    public void resetNeigbors(){
        this.aliveNeighbors = 0;
    }
}
