package springdemo_4.springdemo_4.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "playlist")
@SequenceGenerator(name = "playlist_seq_gen", sequenceName = "playlist_seq", allocationSize = 1)
public class Playlist {

    @Id
    @GeneratedValue(generator = "playlist_seq_gen", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "release_year")
    private int releaseYear;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
