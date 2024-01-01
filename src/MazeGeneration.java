import java.util.*;

public class MazeGeneration {
    private final List<Cell> cells = new ArrayList<>();
    private final int mazeSize;
    private final int spacing;
    private final Random random = new Random();

    public MazeGeneration(int mazeSize){
        this.mazeSize = mazeSize;
        int width = 400;
        //Calculate the space between each line of the maze
        this.spacing = (int)Math.floor((double) width / mazeSize);

        this.createCells();
        this.generateMazeDFS();
        this.addTreasures();
    }
    //Create the cells objects
    public void createCells(){
        for (int y = 0; y < mazeSize; y++){
            for (int x = 0; x < mazeSize; x++){
                cells.add(new Cell(x,y));
            }
        }
    }
    //Choose the starting cell for the maze and call the "Depth First Search" algorithm to generate maze, then display maze grid.
    public void generateMazeDFS(){
        Cell startCell = cells.getFirst();
        startCell.setVisited(true);
        dfs(startCell);
    }

    //DFS algorithm using stack to keep track of all the neighbors of each cell and recurse through all of them randomly
    Stack<Cell> stack = new Stack<>();
    private void dfs(Cell currentCell){
        stack.push(currentCell);
        while (!stack.isEmpty()) {
            currentCell = stack.peek();//Use of peek() method to get the cell on top of the stack without removing it and set it as current cell
            List<Cell> neighbors = getUnvisitedNeighbors(currentCell);
            if (!neighbors.isEmpty()) {
                Collections.shuffle(neighbors);
                Cell neighbor = neighbors.getFirst();
                removeWall(currentCell, neighbor);
                neighbor.setVisited(true);

                dfs(neighbor);//Recursive call to dfs algorithm to every neighbor of the current cell until we reach a cell with no unvisited neighbors

            } else {
                stack.pop();//Call to pop() method to remove the top cell from the stack when that cell has no more unvisited neighbors
                //This way we move on to the last visited cell which had unvisited neighbors
            }

        }
    }

    //Method check if each cell we are currently visiting on DFS algorithm has unvisited neighbors and if it does return a List of each of them
    private List<Cell> getUnvisitedNeighbors(Cell cell){
        List<Cell> neighbors = new ArrayList<>();

        //Check if our current cell has an available top neighbor
        if (cell.getY()>0){
            Cell topCell = cells.get(index(cell.getX(), cell.getY()-1)); //If it does have one we access this cell simply by reducing the y coordinate by 1 - !!!!!!!!!!!!!!!!!!!!!!!!!!
            if(!topCell.isVisited()){//Check if the top cell is a visited cell or not
                neighbors.add(topCell);
            }
        }

        //Check the same for the left side of current cell
        if (cell.getX()>0){
            Cell leftCell = cells.get(index(cell.getX()-1, cell.getY()));//Access the left neighbor by reducing x coordinate by 1;
            if (!leftCell.isVisited()) {
                neighbors.add(leftCell);
            }
        }

        //Check the bottom cell by comparing current cells y coordinate with the size of our maze;
        if (cell.getY()<mazeSize-1){
            Cell bottomCell = cells.get(index(cell.getX(), cell.getY()+1));//Access the bottom neighbor by adding 1 to the y coordinate of the current cell
            if(!bottomCell.isVisited()){
                neighbors.add(bottomCell);
            }
        }

        //Check the right cell
        if (cell.getX()<mazeSize-1){
            Cell rightCell = cells.get(index(cell.getX()+1, cell.getY()));//Access it by adding 1 to the x coordinate
            if(!rightCell.isVisited()){
                neighbors.add(rightCell);
            }
        }
        return neighbors;
    }

    private void removeWall(Cell currentCell, Cell neighbor){
        //Calculate if the neighbor cell is to the right, left, top or bottom of the current cell and remove the walls between them
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

    //Since we have a one dimensional array list to store all the cells of the grid we need to calculate the index of the cell in the array list
    //based on the cells x and y coordinates.
    public int index(int x, int y){
        return y*mazeSize + x;
    }

    public void addTreasures(){
        for (Cell cell : cells){
            cell.setContainsTreasure(random.nextBoolean());
        }
    }

    public List<Cell> getCells() {
        return cells;
    }
    public int getSpacing() {
        return spacing;
    }
    public int getMazeSize() {
        return mazeSize;
    }
}

