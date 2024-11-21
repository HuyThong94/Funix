package lap14;

public class Lap_14_1 {
    public static void main(String[] args) {
        // Tạo các đội bóng đá
        Team<FootballPlayer> footballTeam1 = new FootballTeam("Team A", 90);
        Team<FootballPlayer> footballTeam2 = new FootballTeam("Team B", 85);
        Team<FootballPlayer> footballTeam3 = new FootballTeam("Team C", 95);

        // Tạo giải đấu bóng đá
        League<Team<FootballPlayer>> footballLeague = new League<>("Premier League");

        // Thêm các đội vào giải đấu
        footballLeague.add(footballTeam1);
        footballLeague.add(footballTeam2);
        footballLeague.add(footballTeam3);

        // Hiển thị bảng xếp hạng
        System.out.println("Bảng thi đấu của " + footballLeague.getName() + ":");
        footballLeague.showLeagueTable();
    }
}
