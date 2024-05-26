import java.io.Serializable;
import java.util.Objects;

public class Schueler implements Comparable<Schueler>, Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int note;
    private float prozent;

    public Schueler(String name, int note, float prozent) {
        this.name = name;
        this.note = note;
        this.prozent = prozent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public float getProzent() {
        return prozent;
    }

    public void setProzent(float prozent) {
        this.prozent = prozent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schueler schueler = (Schueler) o;

        return Objects.equals(name, schueler.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "name: " + name + System.lineSeparator() +
                "note: " + note + System.lineSeparator() +
                "prozent: " + prozent + System.lineSeparator();
    }

    @Override
    public int compareTo(Schueler o) {
        if (this == o) return 0;
        if (o == null || getClass() != o.getClass()) return -1;

        return this.name.compareTo(o.getName());
    }
}