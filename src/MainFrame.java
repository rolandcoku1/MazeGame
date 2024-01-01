import javax.swing.*;
public class MainFrame extends JFrame {
    MazeGeneration maze  = new MazeGeneration(10);
    Player player = new Player(maze);
    public MainFrame(){
        this.setTitle("MazeGeneration Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,650);
        this.setLayout(null);
        this.addKeyListener(new GameControls(player));
        this.add(player.getPlayerLabel());
        this.add(new MazePanel(maze));

        this.setVisible(true);
    }
}
