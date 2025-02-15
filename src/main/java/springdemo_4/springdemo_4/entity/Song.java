package springdemo_4.springdemo_4.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "song")
@SequenceGenerator(name = "song_seq_gen", sequenceName = "song_seq", allocationSize = 1)
public class Song {

    @Id
    @GeneratedValue(generator = "song_seq_gen", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "artist")
    private String artist;

    @Column(name = "duration")
    private double duration;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
