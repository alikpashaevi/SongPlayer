package springdemo_4.springdemo_4.model;

public class SongDTO {
    private Long id;
    private String name;
    private Double duration;
    private AlbumDTO album;
    private ArtistDTO artist;


    public SongDTO(Long id, String name, Double duration, AlbumDTO album, ArtistDTO artist) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.album = album;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArtistDTO getArtist() {
        return artist;
    }

    public Double getDuration() {
        return duration;
    }

    public AlbumDTO getAlbum() {
        return album;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(ArtistDTO artist) {
        this.artist = artist;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public void setAlbum(AlbumDTO album) {
        this.album = album;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Artist: " + artist);
        System.out.println("Duration: " + duration);
        System.out.println("Playlist: " + album.getName());
    }
}
