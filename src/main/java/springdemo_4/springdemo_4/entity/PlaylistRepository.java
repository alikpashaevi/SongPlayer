package springdemo_4.springdemo_4.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springdemo_4.springdemo_4.model.PlaylistDTO;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    @Query("SELECT p FROM Playlist p")
    Page<Playlist> getPlaylists(Pageable pageable);
}
