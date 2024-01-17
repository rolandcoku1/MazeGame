import javax.swing.*;
public class GraphicsFrame extends JFrame {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 650;
    private final MazeGeneration maze = new MazeGeneration(WINDOW_WIDTH,WINDOW_HEIGHT);
    private Player player = new Player(maze);
//    private Music musicPlayer;
//    private String musicFilePath = "C:\\Users\\rolan\\IdeaProjects\\MazeGame\\audio\\Alone_-_Color_Out.mp3"; // replace with actual path
    public GraphicsFrame(){
        this.setTitle("GraphicsFrame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLayout(null);
        this.addKeyListener(new GameControls(player));
        this.add(player.getPlayerLabel());
        this.add(new MazeGraphicsPanel(maze));
        this.setVisible(true);
    }

}
