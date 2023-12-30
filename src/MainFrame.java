import javax.swing.*;
public class MainFrame extends JFrame {
    Player player = new Player();
    public MainFrame(){
        this.setTitle("Maze Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,650);
        this.setLayout(null);
        this.addKeyListener(new GameControls(player));
        this.add(player.getPlayerLabel());
        this.add(new MazePanel());

        this.setVisible(true);
    }
}
