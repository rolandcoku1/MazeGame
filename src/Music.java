import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class Music {
    private Clip clip;

    public static void main(String[] args) {
        String filepath = "C:\\Users\\rolan\\IdeaProjects\\MazeGame\\audio\\Alone_-_Color_Out.mp3";
        new Music().playMusic(filepath);
        JOptionPane.showMessageDialog(null, "Press ok to stop playing");
    }

    public void playMusic(String location) {
        try {
            File musicPath = new File(location);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.err.println("File not found: " + location);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
