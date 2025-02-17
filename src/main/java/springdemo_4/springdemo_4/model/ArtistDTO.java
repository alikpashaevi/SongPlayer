package springdemo_4.springdemo_4.model;

import java.util.List;

public class ArtistDTO {
    private Long id;
    private String name;
    private String monthlyListeners;
    private List<AlbumDTO> albums;

    public ArtistDTO(Long id, String name, String monthlyListeners, List<AlbumDTO> albums) {
        this.id = id;
        this.name = name;
        this.monthlyListeners = monthlyListeners;
        this.albums = albums;
    }

    public Long getId() {return id;}

    public String getName() {
        return name;
    }

    public String getMonthlyListeners() {
        return monthlyListeners;
    }

    public List<AlbumDTO> getAlbums() {
        return albums;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
    }
}
