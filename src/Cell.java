import java.io.Serializable;
public class Cell implements Serializable{
    //Create variables for the indexes of each wall on the boolean array wall;
    private final int topIndex = 0;
    private final int rightIndex = 1;
    private final int bottomIndex = 2;
    private final int leftIndex = 3;
    private final int x;
    private final int y;
    private final boolean[] wall = {true, true, true, true};
    private boolean visited = false;
    private boolean containsTreasure = false;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public boolean hasTopWall(){
        return wall[topIndex];
    }
    public boolean hasLeftWall(){
        return wall[leftIndex];
    }
    public boolean hasBottomWall(){
        return wall[bottomIndex];
    }
    public boolean hasRightWall(){
        return wall[rightIndex];
    }
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setTopWall(boolean isWall) {
        wall[topIndex] = isWall;
    }

    public void setRightWall(boolean isWall) {
        wall[rightIndex] = isWall;
    }

    public void setBottomWall(boolean isWall) {
        wall[bottomIndex] = isWall;
    }

    public void setLeftWall(boolean isWall) {
        wall[leftIndex] = isWall;
    }

    public boolean containsTreasure() {
        return containsTreasure;
    }

    public void setContainsTreasure(boolean containsTreasure){
        this.containsTreasure = containsTreasure;
    }
}
