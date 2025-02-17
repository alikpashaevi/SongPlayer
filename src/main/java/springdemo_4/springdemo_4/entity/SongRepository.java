package springdemo_4.springdemo_4.entity;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springdemo_4.springdemo_4.model.SongDTO;

public interface SongRepository extends JpaRepository<Song, Long> {
    @Query(
            "SELECT NEW springdemo_4.springdemo_4.model.SongDTO(" +
                    "s.id, s.name, s.duration, " +
                    "NEW springdemo_4.springdemo_4.model.AlbumDTO(p.id, p.name, p.releaseYear), " +
                    "NEW springdemo_4.springdemo_4.model.ArtistDTO(a.id, a.name, a.monthlyListeners)) " +
                    "FROM Song s " +
                    "JOIN s.album p " +
                    "JOIN s.artist a"
    )
    Page<SongDTO> findSongs(Pageable pageable);
}
