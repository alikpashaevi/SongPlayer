package springdemo_4.springdemo_4.model;

import springdemo_4.springdemo_4.entity.Artist;

public class SongDTO {
    private Long id;
    private String name;
    private Double duration;
    private PlaylistDTO playlist;
    private ArtistDTO artist;


    public SongDTO(Long id, String name, Double duration, PlaylistDTO playlist, ArtistDTO artist) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.playlist = playlist;
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

    public PlaylistDTO getPlaylist() {
        return playlist;
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

    public void setPlaylist(PlaylistDTO playlist) {
        this.playlist = playlist;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Artist: " + artist);
        System.out.println("Duration: " + duration);
        System.out.println("Playlist: " + playlist.getName());
    }
}
