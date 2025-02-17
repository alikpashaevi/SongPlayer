package springdemo_4.springdemo_4.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "song")
@SequenceGenerator(name = "song_seq_gen", sequenceName = "song_seq", allocationSize = 1)
public class Song {

    @Id
    @GeneratedValue(generator = "song_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Double duration;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
