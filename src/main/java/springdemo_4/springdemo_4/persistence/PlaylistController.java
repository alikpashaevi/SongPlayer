package springdemo_4.springdemo_4.persistence;

import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdemo_4.springdemo_4.entity.Playlist;
import springdemo_4.springdemo_4.model.PlaylistDTO;
import springdemo_4.springdemo_4.model.PlaylistRequest;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public Page<PlaylistDTO> getPlaylists(int page, int pageSize) {
        return playlistService.getPlaylists(page, pageSize);
    }

    @GetMapping("/{id}")
    public Playlist getPlaylist(Long id) {
        return playlistService.findPlaylist(id);
    }

    @PostMapping
    ResponseEntity<Void> createPlaylist(@RequestBody PlaylistRequest request) {
        playlistService.createPlaylist(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updatePlaylist(@PathVariable Long id, @RequestBody PlaylistRequest request) {
        playlistService.updatePlaylist(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.ok().build();
    }


}
