package lap14;

import java.util.ArrayList;

public abstract class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    private int ranking;
    private ArrayList<T> members = new ArrayList<>();

    public Team(String name, int ranking) {
        this.name = name;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public int getRanking() {
        return ranking;
    }

    // Thêm một thành viên vào đội
    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " đã có trong đội.");
            return false;
        }
        members.add(player);
        System.out.println(player.getName() + " đã được thêm vào đội " + this.name);
        return true;
    }

    @Override
    public int compareTo(Team<T> other) {
        // So sánh đội dựa trên thứ hạng (ranking) giảm dần
        return Integer.compare(other.getRanking(), this.ranking);
    }
}
