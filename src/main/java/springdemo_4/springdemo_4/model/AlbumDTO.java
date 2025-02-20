package springdemo_4.springdemo_4.model;

public class AlbumDTO {
    private Long id;
    private String name;
    private int ReleaseYear;
    private ArtistSimpleDTO artist;

    public AlbumDTO(Long id, String name, int ReleaseYear, ArtistSimpleDTO artist) {
        this.id = id;
        this.name = name;
        this.ReleaseYear = ReleaseYear;
        this.artist = artist;
    }

    public Long getId() {return id;}

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public ArtistSimpleDTO getArtist() {
        return artist;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Release Year: " + ReleaseYear);
    }

}
