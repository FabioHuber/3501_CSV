import java.util.TreeSet;

public class SchuelerManager {
    private TreeSet<Schueler> schueler;

    public SchuelerManager() {
        schueler = new TreeSet<>();
    }

    public void addSchueler(Schueler s) {
        schueler.add(s);
    }

    public TreeSet<Schueler> getSchueler() {
        return schueler;
    }

    public void removeSchueler(Schueler s) {
        schueler.remove(s);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Schüler 3CHIT \n");
        for (Schueler s : schueler) {
            sb.append(s);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
