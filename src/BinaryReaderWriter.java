import java.io.*;

public class BinaryReaderWriter {
    public void writeBinary(String fileName, SchuelerManager sm) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            //Header -> bei uns: Anzahl der Datensätze
            dos.writeInt(sm.getSchueler().size());

            //Datensätze einlesen
            for (Schueler s : sm.getSchueler()) {
                dos.writeUTF(s.getName());
                dos.writeInt(s.getNote());
                dos.writeFloat(s.getProzent());
            }
        }
    }

    public void readBinary(String fileName, SchuelerManager sm) throws IOException {
        sm.getSchueler().clear();
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            // lies Header -> Anzahl der Datensätze
            int noOfRecords = dis.readInt();

            String name;
            int note;
            float prozent;

            for (int i = 0; i < noOfRecords; i++) {
                name = dis.readUTF();
                note = dis.readInt();
                prozent = dis.readFloat();

                sm.addSchueler(new Schueler(name, note, prozent));
            }
        }
    }
}
