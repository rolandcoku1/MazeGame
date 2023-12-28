
public class Main {

    public static void main(String[] args) {
        Maze maze = new Maze(10);
        maze.generateMazeDFS();
        maze.displayMazeGrid();
    }
}