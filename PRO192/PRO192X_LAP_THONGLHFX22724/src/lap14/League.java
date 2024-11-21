package lap14;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team<?>> {
    private String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    // Thêm đội vào giải đấu
    public boolean add(T team) {
        if (league.contains(team)) {
            return false;
        }
        league.add(team);
        return true;
    }

    // Hiển thị bảng xếp hạng
    public void showLeagueTable() {
        Collections.sort(league);
        for (T team : league) {
            System.out.println(team.getName() + ": " + team.getRanking());
        }
    }
    public String getName() {
        return name;
    }
    public ArrayList<T> getLeague() {
        return league;
    }
    public void setLeague(ArrayList<T> league) {
        this.league = league;
    }
    public void setName(String name) {
        this.name = name;
    }
}

