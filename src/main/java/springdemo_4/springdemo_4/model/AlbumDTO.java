package springdemo_4.springdemo_4.model;

public class AlbumDTO {
    private Long id;
    private String name;
    private int ReleaseYear;

    public AlbumDTO(Long id, String name, int ReleaseYear) {
        this.id = id;
        this.name = name;
        this.ReleaseYear = ReleaseYear;
    }

    public Long getId() {return id;}

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
