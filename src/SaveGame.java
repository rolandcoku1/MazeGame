import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.List;


public class SaveGame {
    public static void saveGame(List<Cell> cellS){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("maze.dat"))){
            objectOutputStream.writeObject(cellS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<Cell> loadGame(){
        try {
            Object object = new ObjectInputStream(new FileInputStream("maze.dat")).readObject();
            if(object instanceof List){
                return (List<Cell>) object;
            } else {
                System.out.println("Error: Object is not a List");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
