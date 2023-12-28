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
    private final int height;
    private final int spacing;
    public Maze(int size){
        this.width = 400;
        this.height = 400;
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
    public void displayMazeGrid(){

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Maze Game");
            JPanel cellPanel = new GenerateMaze(cells,spacing);
            frame.getContentPane().add(cellPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocation(400,200);
            frame.setSize(450, 450);
            frame.setVisible(true);
        });
    }

}
class GenerateMaze extends JPanel{
    private final List<Cell> cells;
    private final int spacing;

    public GenerateMaze(List<Cell> cells, int spacing){
        this.cells = cells;
        this.spacing = spacing;
    }
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        //Set the color of the grid to black
        graphics.setColor(Color.black);

        for (Cell cell : cells) {
            //Set the beginning point coordinates
            int x = cell.getX() * spacing;
            int y = cell.getY() * spacing;

            // Draw top line
            if(cell.getWall()[cell.getTopIndex()]){
                graphics.drawLine(x, y, x + spacing, y);
            }
            // Draw left line
            if(cell.getWall()[cell.getLeftIndex()]) {
                graphics.drawLine(x, y, x, y + spacing);
            }
            // Draw right line
            if(cell.getWall()[cell.getRightIndex()]) {
                graphics.drawLine(x + spacing, y, x + spacing, y + spacing);
            }
            // Draw bottom line
            if(cell.getWall()[cell.getBottomIndex()]) {
                graphics.drawLine(x, y + spacing, x + spacing, y + spacing);
            }
        }
    }
};
class Cell{
    //Create variables for the indexes of each wall on the boolean array wall;
    private final int topIndex = 0;
    private final int rightIndex = 1;
    private final int bottomIndex = 2;
    private final int leftIndex = 3;
    private final int x;
    private final int y;
    private boolean[] wall = {true, true, true, true};
    private boolean visited = false;
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean[] getWall() {
        return wall;
    }
    public int getTopIndex() {
        return topIndex;
    }
    public int getRightIndex() {
        return rightIndex;
    }
    public int getBottomIndex() {
        return bottomIndex;
    }
    public int getLeftIndex() {
        return leftIndex;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public void setTopWall(boolean isWall){
        wall[topIndex] = isWall;
    }
    public void setRightWall(boolean isWall){
        wall[rightIndex] = isWall;
    }
    public void setBottomWall(boolean isWall){
        wall[bottomIndex] = isWall;
    }
    public void setLeftWall(boolean isWall){
        wall[leftIndex] = isWall;
    }
}

