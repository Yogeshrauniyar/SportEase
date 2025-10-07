package schedular;
import java.util.*;

public class Schedular {
    private Set<Game> games = new HashSet<>();
    private Set<Player> players = new HashSet<>();
    private Set<DaySchedule> days = new HashSet<>();

    private Map<Game, TreeSet<DaySchedule>> gameDayMap = new HashMap<>();
    private Map<Game, TreeSet<Player>> gamePlayerMap = new HashMap<>();
    private Map<String, DaySchedule> dayNameScheduleMap = new HashMap<>();

    public Map<String, DaySchedule> getDayNameScheduleMap() { return dayNameScheduleMap; }
    public void setDayNameScheduleMap(Map<String, DaySchedule> dayNameScheduleMap) { this.dayNameScheduleMap = dayNameScheduleMap; }
    public int getNumberGames() { return games.size(); }
    public int getNumberofPlayers() { return players.size(); }
    public int getNumberofDays() { return days.size(); }

    public String addGame(String name, int nop) throws GameAlreadyExistsException {
        Game g = new Game(name, nop);
        games.add(g);
        return "SUCCESS";
    }

    public String addSchedule(String dayName, String[] gameNames)
            throws PlayerAlreadyExistsException, InvalidGameException, DayAlreadyScheduledException {
        DaySchedule d = searchDay(dayName);
        if (d == null) {
            d = new DaySchedule(dayName);
        }
        ArrayList<Game> gamesList = d.getGames();
        Set<Game> uniqueGames = new HashSet<>(gamesList);
        int originalnog = uniqueGames.size();
        for (String game : gameNames) {
            Game g = searchGame(game);
            if (g == null) {
                continue;
            }
            uniqueGames.add(g);
            TreeSet<DaySchedule> daySchedules = gameDayMap.get(g);
            if (daySchedules == null) {
                daySchedules = new TreeSet<>();
                gameDayMap.put(g, daySchedules);
            }
        }
        if (originalnog == uniqueGames.size()) {
            throw new DayAlreadyScheduledException("Day Already Scheduled");
        }
        gamesList.clear();
        gamesList.addAll(uniqueGames);
        d.setGames(gamesList);
        days.add(d);
        dayNameScheduleMap.put(dayName, d);
        return "SUCCESS";
    }

    private DaySchedule searchDay(String dayName) {
        for (DaySchedule day : this.days) {
            if (day.getDayName().equals(dayName)) {
                return day;
            }
        }
        return null;
    }

    public String addPlayer(String name, String[] gameNames)
        throws PlayerAlreadyExistsException, InvalidGameException {
    ArrayList<Game> gamesList = new ArrayList<>();
    for (String game : gameNames) {
        Game g = searchGame(game);
        if (g == null) {
            throw new InvalidGameException(game + " does not exist ");
        }
        gamesList.add(g);
    }
    Player p = new Player(name, gamesList);
    players.add(p); // Only add after all games are validated
    return "SUCCESS";
}

    public Set<Game> getGames() { return games; }
    public void setGames(Set<Game> games) { this.games = games; }

    private Game searchGame(String name) {
        for (Game g : this.games) {
            if (g.getGameName().equals(name))
                return g;
        }
        return null;
    }

    public StringBuffer displayGamewiseSchedule(String gameName) {
        StringBuffer sb = new StringBuffer();
        Game g = searchGame(gameName);
        if (g == null) {
            sb.append(gameName + " is not part of the Schedule.");
            return sb;
        }
        if (gameDayMap.containsKey(g)) {
            sb.append(gameName + " is played on ");
            sb.append("\n\t" + "Days:" + gameDayMap.get(g));
        } else {
            sb.append(gameName + " is not scheduled on any day...");
        }
        if (gamePlayerMap.containsKey(g)) {
            sb.append("\n" + gameName + " is played by ");
            sb.append("\n\t" + "Players:" + gamePlayerMap.get(g));
        } else {
            sb.append("No player plays this game...");
        }
        return sb;
    }

    public StringBuffer displayPlayerwiseSchedule(String name) {
        StringBuffer sb = new StringBuffer();
        if (!players.contains(new Player(name))) {
            sb.append("No such Player exists ... ");
            return sb;
        }
        ArrayList<Player> playersList = new ArrayList<>(this.players);
        Player p = new Player(name, null);
        Collections.sort(playersList);
        int index = Collections.binarySearch(playersList, p);
        ArrayList<Game> gamesList = playersList.get(index).getGames();
        Iterator<Game> it = gamesList.iterator();
        sb.append(name + " plays ");
        while (it.hasNext()) {
            Game g = it.next();
            sb.append("\n\t " + g + " on " + gameDayMap.get(g));
        }
        return sb;
    }

    public StringBuffer displayDaywiseSchedule(String name) {
        StringBuffer sb = new StringBuffer();
        DaySchedule day = new DaySchedule(name);
        if (!days.contains(day)) {
            sb.append("No such day exists in the schedule...");
            return sb;
        }
        ArrayList<DaySchedule> daysList = new ArrayList<>(this.days);
        Collections.sort(daysList);
        int index = Collections.binarySearch(daysList, day);
        ArrayList<Game> gamesList = daysList.get(index).getGames();
        Iterator<Game> it = gamesList.iterator();
        sb.append("On " + name);
        while (it.hasNext()) {
            Game g = it.next();
            sb.append("\n\t" + g + " is played by " + gamePlayerMap.get(g));
        }
        return sb;
    }
}