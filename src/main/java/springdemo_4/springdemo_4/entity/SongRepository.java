package springdemo_4.springdemo_4.entity;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springdemo_4.springdemo_4.model.SongDTO;

public interface SongRepository extends JpaRepository<Song, Long> {
    @Query(
            "SELECT NEW springdemo_4.springdemo_4.model.SongDTO" +
                    "(s.id, s.name, s.artist, s.duration, " +
                    "new springdemo_4.springdemo_4.model.PlaylistDTO" +
                    "(p.id, p.name, p.releaseYear)) " +
                    "FROM Song s JOIN s.playlist p"
    )
    Page<SongDTO> findSongs(Pageable pageable);
}
