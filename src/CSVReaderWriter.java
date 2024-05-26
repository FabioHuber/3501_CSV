import java.io.*;

public class CSVReaderWriter {
    public void csvRead(String filename, SchuelerManager sm) throws IOException, CorruptDataException {
        int lineCounter = 3;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String zeile;
            String[] token;

            zeile = bufferedReader.readLine(); // 1. Zeile überspringen
            bufferedReader.readLine(); // 2. Zeile überspringen

            // solange lesen, bis Dateiende erreicht
            while ((zeile = bufferedReader.readLine()) != null) {
                // Zerlegen einer Zeile, Trennzeichen Semikolon ';'
                token = zeile.split(";");

                if (token.length == 3) { //korrekte Anzahl an Elementen
                    sm.addSchueler(new Schueler(token[0], Integer.parseInt(token[1]), Float.parseFloat(token[2])));
                } else {
                    throw new CorruptDataException("Zeile " + lineCounter + ": Datensatz hat inkorrekte Daten");
                }
                lineCounter++;
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new CorruptDataException("Zeile " + lineCounter + ": Datensatz hat inkorrekte Daten");
        }
    }

    public void csvWrite(String fileName, SchuelerManager sm) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            //Überschrift in CSV-File speichern
            pw.println("Notenliste 3CHIT;;");
            pw.println("Schüler;Semesternote;Prozent");
            for (Schueler s : sm.getSchueler()) {
                pw.printf("%s;%d;%.2f", s.getName(), s.getNote(), s.getProzent());
                pw.print(System.lineSeparator());
            }
        }
    }
}