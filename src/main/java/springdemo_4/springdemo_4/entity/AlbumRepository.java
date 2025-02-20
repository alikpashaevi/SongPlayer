package springdemo_4.springdemo_4.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springdemo_4.springdemo_4.model.AlbumDTO;

public interface AlbumRepository extends JpaRepository<Album, Long> {

//    @Query("SELECT NEW springdemo_4.springdemo_4.model.AlbumDTO(" +
//            "a.id, a.name, a.releaseYear, " +
//            "NEW springdemo_4.springdemo_4.model.ArtistDTO(art.id, art.name, art.monthlyListeners, null )) " +
//            "FROM Album a " +
//            "JOIN a.artist art")

    @Query("SELECT a FROM Album a JOIN FETCH a.artist")
    Page<Album> findAlbums(Pageable pageable);
}
