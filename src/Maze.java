import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import javax.swing.*;
public class Maze{
    private List<Cell> cells = new ArrayList<>();
    private final int mazeSize;
    private final int GRIDSIZE = 10;
    private final int width;
    private final int spacing;
    public Maze(int size){
        this.width = 400;
        //Calculate the space between each line of the maze
        this.spacing = (int)Math.floor((double) width/GRIDSIZE);
        this.mazeSize = size;

        //Create the cells objects
        for (int x = 0; x < size; x++){
           for (int y = 0; y < size; y++){
               cells.add(new Cell(x,y));
           }
        }
    }
    public void generateMazeDFS(){
        Cell startCell = cells.getFirst();
        startCell.setVisited(true);
        dfs(startCell);
        new Display(cells,spacing).MazeGrid();
    }

    private void dfs(Cell startCell){
        Stack<Cell> stack = new Stack<>();
        stack.push(startCell);
        while (!stack.isEmpty()){
            Cell currentCell = stack.peek();
            List<Cell> neighbors = getUnvisitedNeighbors(startCell);
            if(!neighbors.isEmpty()){
                Collections.shuffle(neighbors);
                removeWall(currentCell, neighbors.getFirst());
                neighbors.getFirst().setVisited(true);
                dfs(neighbors.getFirst());
            } else {
                stack.pop();
            }

        }
    }
    private List<Cell> getUnvisitedNeighbors(Cell cell){
        List<Cell> neighbors = new ArrayList<>();

        if (cell.getY()>0){
            Cell topCell = cells.get(index(cell.getX(), cell.getY())-1);
            if(!topCell.isVisited()){
                neighbors.add(topCell);
            }
        }
        if (cell.getX()>0){
            Cell leftCell = cells.get(index(cell.getX()-1, cell.getY()));
            if (!leftCell.isVisited()) {
                neighbors.add(leftCell);
            }
        }
        if (cell.getY()<mazeSize-1){
            Cell bottomCell = cells.get(index(cell.getX(), cell.getY()+1));
            if(!bottomCell.isVisited()){
                neighbors.add(bottomCell);
            }
        }
        if (cell.getX()<mazeSize-1){
            Cell rightCell = cells.get(index(cell.getX()+1, cell.getY()));
            if(!rightCell.isVisited()){
                neighbors.add(rightCell);
            }
        }

        return neighbors;
    }

    private void removeWall(Cell currentCell, Cell neighbor){
        int dx = currentCell.getX() - neighbor.getX();
        int dy = currentCell.getY() - neighbor.getY();

        if ((dx == 1)&&(dy == 0)){
            currentCell.setLeftWall(false);
            neighbor.setRightWall(false);
        } else if ((dx == -1)&&(dy==0)) {
            currentCell.setRightWall(false);
            neighbor.setLeftWall(false);
        } else if ((dy == 1)&&(dx == 0)) {
            currentCell.setTopWall(false);
            neighbor.setBottomWall(false);
        } else if ((dy == -1)&&(dx == 0)) {
            currentCell.setBottomWall(false);
            neighbor.setTopWall(false);
        }
    }
    private int index(int x, int y){
        return x*mazeSize + y;
    }

}
;

