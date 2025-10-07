package schedular;
import java.util.ArrayList;

public class DaySchedule implements Comparable<DaySchedule> {
    private String dayName;
    private ArrayList<Game> games;

    public DaySchedule() {
        this.games = new ArrayList<>();
    }

    public DaySchedule(String dayName) {
        this.dayName = dayName;
        this.games = new ArrayList<>();
    }

    public DaySchedule(String dayName, ArrayList<Game> games) {
        this.dayName = dayName;
        this.games = games;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return dayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DaySchedule)) return false;
        DaySchedule d = (DaySchedule) o;
        return dayName.equals(d.dayName);
    }

    @Override
    public int hashCode() {
        return dayName.hashCode();
    }

    @Override
    public int compareTo(DaySchedule other) {
        return this.dayName.compareTo(other.dayName);
    }
}