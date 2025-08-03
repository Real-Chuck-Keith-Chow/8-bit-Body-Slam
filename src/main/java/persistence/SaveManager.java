package wrestling.simulator;
import java.io.*;

public class SaveManager {
    public static void saveGame(Wrestler player) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("career.sav"))) {
            oos.writeObject(player);
        }
    }

    public static Wrestler loadGame() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("career.sav"))) {
            return (Wrestler) ois.readObject();
        }
    }
}
