package springdemo_4.springdemo_4.model;

public class SongDTO {
    private long id;
    private String name;
    private String artist;
    private double duration;
    private PlaylistDTO playlist;


    public SongDTO(long id, String name, String artist, double duration, PlaylistDTO playlist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.playlist = playlist;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }

    public PlaylistDTO getPlaylist() {
        return playlist;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDuration(int duration) {
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
