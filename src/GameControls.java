import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameControls implements KeyListener {
    private final Player player;
    private String gameStatus;

    public GameControls(Player player){
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent keyPress){
        int keyCode = keyPress.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_UP:
                System.out.println(player.getPlayerPositionY());
                player.movePlayerUp();
                break;
            case KeyEvent.VK_DOWN:
                player.movePlayerDown();
                break;
            case KeyEvent.VK_LEFT:{
                player.movePlayerLeft();
                break;
            }
            case KeyEvent.VK_RIGHT:
                player.movePlayerRight();
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent keyPress) {

    }
    @Override
    public void keyTyped(KeyEvent KeyPress){

    }
}
