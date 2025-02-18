package springdemo_4.springdemo_4.model;

public class AlbumSimpleDTO {

    private Long id;
    private String name;
    private int releaseYear;

    public AlbumSimpleDTO(Long id, String name, int releaseYear) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Long getId() {return id;}

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
    }

}
