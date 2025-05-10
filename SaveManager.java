package wrestling.simulator;

import java.io.*;

public class SaveManager {
    public static void saveGame(Wrestler player) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("career.sav"))) {  // Fixed: Added missing ")" and renamed variable
            oos.writeObject(player);
        } // try-with-resources auto-closes the stream
    }

    public static Wrestler loadGame() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("career.sav"))) {  // Fixed: Added missing ")"
            return (Wrestler) ois.readObject();
        }
    }
}
