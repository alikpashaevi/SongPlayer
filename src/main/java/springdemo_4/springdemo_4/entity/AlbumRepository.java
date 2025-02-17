package springdemo_4.springdemo_4.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springdemo_4.springdemo_4.model.AlbumDTO;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    @Query("SELECT NEW springdemo_4.springdemo_4.model.AlbumDTO(p.id, p.name, p.releaseYear) FROM Album p")
    Page<AlbumDTO> findAlbums(Pageable pageable);
}
