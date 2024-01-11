import javax.swing.*;

public class MainFrame extends JFrame {

    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 650;
    private final MazeGeneration maze = new MazeGeneration(WINDOW_WIDTH,WINDOW_HEIGHT);
    private Player player = new Player(maze);
//    private Music musicPlayer;
//    private String musicFilePath = "C:\\Users\\rolan\\IdeaProjects\\MazeGame\\audio\\Alone_-_Color_Out.mp3"; // replace with actual path

    public MainFrame() {
        this.setTitle("MazeGeneration Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setLayout(null);

//        // Initialize musicPlayer
//        musicPlayer = new Music();
//
//        // Start playing the music
//        musicPlayer.playMusic(musicFilePath);
//
//        // Display a message dialog (optional)
//        JOptionPane.showMessageDialog(null, "Press OK to stop playing");
//
//        // Stop playing the music when the user clicks OK
//        musicPlayer.stopMusic();

        this.addKeyListener(new GameControls(player));
        this.add(player.getPlayerLabel());
        this.add(new MazePanel(maze));

        this.setVisible(true);
    }

}
