import java.io.*;
import java.util.TreeSet;

public class ObjectReaderWriter {

    public void writeObject(String fileName, SchuelerManager sm) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            oos.writeObject(sm.getSchueler());
            //alternative: alle objekte einzeln speichern mit einem header

            //oos.writeInt(sm.getSchueler().size());
            //for (Schueler s : sm.getSchueler()) {
            //    oos.writeObject(s);
            //}
        }
    }

    public TreeSet<Schueler> readObjects(String fileName) throws IOException, ClassNotFoundException {
            TreeSet<Schueler> schuelerTreeSet = null;

        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            schuelerTreeSet = (TreeSet<Schueler>) ois.readObject();
        }

        return schuelerTreeSet;
    }
}
