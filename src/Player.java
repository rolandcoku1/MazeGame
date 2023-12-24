public class Player {
    private int playerPositionY;
    private int playerPositionX;
    private int treasureCount;
    private int pointsEarned;

    public Player(){
        this.playerPositionX = 0;
        this.playerPositionY = 0;
        this.pointsEarned = 0;
        this.treasureCount = 0;
    }

    public Player(int playerPositionY, int playerPositionX, int treasureCount, int pointsEarned){
        this.playerPositionY = playerPositionY;
        this.playerPositionX = playerPositionX;
        this.treasureCount = treasureCount;
        this.pointsEarned = pointsEarned;
    }

    public void movePlayer(){

    }

    public int collectTreasure(){
        return 1;
    }

    public boolean isAnExit(){
        return true;
    }


}
