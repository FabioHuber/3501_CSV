import java.io.IOException;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        SchuelerManager schuelerManager = new SchuelerManager();
        CSVReaderWriter csvReaderWriter = new CSVReaderWriter();
        BinaryReaderWriter binaryReaderWriter = new BinaryReaderWriter();
        ObjectReaderWriter objectReaderWriter = new ObjectReaderWriter();

        try {
            System.out.println("Lese CSV");
            csvReaderWriter.csvRead("Noten3CHIT.csv", schuelerManager);
            System.out.println(schuelerManager);

            System.out.println("Schreibe CSV");
            csvReaderWriter.csvWrite("NotenNeu.csv", schuelerManager);

            System.out.println("Schreibe Binary");
            binaryReaderWriter.writeBinary("Noten.dat", schuelerManager);

            System.out.println("Lese Binary");
            binaryReaderWriter.readBinary("Noten.dat", schuelerManager);
            System.out.println(schuelerManager);

            System.out.println("Serialisiere Schüler");
            objectReaderWriter.writeObject("Noten.ser", schuelerManager);

            System.out.println("Deserialisiere Schüler");
            TreeSet<Schueler> schuelerTreeSet = objectReaderWriter.readObjects("Noten.ser");
            System.out.println(schuelerTreeSet);

        } catch (IOException | CorruptDataException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
