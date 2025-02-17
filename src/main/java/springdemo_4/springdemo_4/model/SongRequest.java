package springdemo_4.springdemo_4.model;

public class SongRequest {
    private String name;
    private Double duration;
    private Long AlbumId;
    private Long artistId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Long getAlbumId() {
        return AlbumId;
    }

    public void setAlbumId(Long AlbumId) {
        this.AlbumId = AlbumId;
    }
}
