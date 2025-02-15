package springdemo_4.springdemo_4.model;

public class PlaylistDTO {
    private long id;
    private String name;
    private int ReleaseYear;

    public PlaylistDTO(long id, String name, int ReleaseYear) {
        this.id = id;
        this.name = name;
        this.ReleaseYear = ReleaseYear;
    }

    public long getId() {return id;}

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Release Year: " + ReleaseYear);
    }

}
