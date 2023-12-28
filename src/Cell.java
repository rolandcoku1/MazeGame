public class Cell {
    //Create variables for the indexes of each wall on the boolean array wall;
    private final int topIndex = 0;
    private final int rightIndex = 1;
    private final int bottomIndex = 2;
    private final int leftIndex = 3;
    private final int x;
    private final int y;
    private boolean[] wall = {true, true, true, true};
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

    public boolean ContainsTreasure() {
        return containsTreasure;
    }

    public void setContainsTreasure(boolean containsTreasure){
        this.containsTreasure = containsTreasure;
    }
}
