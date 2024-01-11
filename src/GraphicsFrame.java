import javax.swing.*;
import java.awt.*;

public class GraphicsFrame extends JFrame {
    public GraphicsFrame(int WINDOW_WIDTH, int WINDOW_HEIGHT, MazeGeneration maze){
        this.setTitle("GraphicsFrame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

//        ImageIcon background = new ImageIcon("C:\\Users\\rolan\\IdeaProjects\\MazeGame\\src\\background.png");
//        background = new ImageIcon(background.getImage().getScaledInstance(WINDOW_WIDTH,WINDOW_HEIGHT, Image.SCALE_SMOOTH));
//        JLabel backgroundLabel = new JLabel();
//        backgroundLabel.setBounds(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
//        backgroundLabel.setIcon(background);
//        this.add(backgroundLabel);


//        ImageIcon wall = new ImageIcon("C:\\Users\\rolan\\IdeaProjects\\MazeGame\\src\\wall.png");
//        wall = new ImageIcon(wall.getImage().getScaledInstance(maze.getSpacing()/4,maze.getSpacing()/4, Image.SCALE_SMOOTH));
//        JLabel wallLabel = new JLabel();
//        wallLabel.setBounds(0,0,maze.getSpacing()/4,maze.getSpacing()/4);
//        wallLabel.setIcon(wall);

//        this.setLayout(null);

        this.add(new MazeGraphicsPanel(maze));

        this.setVisible(true);
    }

}
