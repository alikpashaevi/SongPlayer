package springdemo_4.springdemo_4.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springdemo_4.springdemo_4.model.ArtistDTO;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    @Query("SELECT NEW springdemo_4.springdemo_4.model.ArtistDTO(" +
            "a.id, a.name, a.monthlyListeners, " +
            "(SELECT NEW springdemo_4.springdemo_4.model.AlbumDTO(" +
            "al.id, al.name, al.releaseYear, null ) " +
            "FROM Album al WHERE al.artist.id = a.id) " +
            ") FROM Artist a")
    Page<ArtistDTO> findArtists(Pageable pageable);
}
