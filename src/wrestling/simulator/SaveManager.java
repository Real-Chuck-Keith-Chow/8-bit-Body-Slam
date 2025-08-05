package wrestling.simulator;



import java.io.*;
public class SaveManager {
	public static void save(Wrestler player, Title[] titles) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream("career.sav"))) {
            out.writeObject(player);
            out.writeObject(titles);
        }
    }

    public static Object[] load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("career.sav"))) {
            return new Object[]{in.readObject(), in.readObject()};
        }
    }

}
