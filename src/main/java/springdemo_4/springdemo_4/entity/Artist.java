package springdemo_4.springdemo_4.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "artist")
@SequenceGenerator(name = "artist_seq_gen", sequenceName = "artist_seq", allocationSize = 1)
public class Artist {

    @Id
    @GeneratedValue(generator = "artist_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "monthly_listeners")
    private String monthlyListeners;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Album> albums;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonthlyListeners() {
        return monthlyListeners;
    }

    public void setMonthlyListeners(String monthlyListeners) {
        this.monthlyListeners = monthlyListeners;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
