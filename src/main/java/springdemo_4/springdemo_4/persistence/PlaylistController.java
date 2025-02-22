package springdemo_4.springdemo_4.persistence;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import springdemo_4.springdemo_4.model.PlaylistDTO;
import springdemo_4.springdemo_4.model.PlaylistRequest;

@RestController
@RequestMapping("/playlists")
@AllArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    @GetMapping
    public Page<PlaylistDTO> getPlaylists(@RequestParam int page, @RequestParam int pageSize) {
        return playlistService.getPlaylists(page, pageSize);
    }

    @GetMapping("/{id}")
    public PlaylistDTO getPlaylist(@PathVariable Long id) {
        return playlistService.getPlaylist(id);
    }

    @PostMapping
    public void createPlaylist(@RequestBody PlaylistRequest request) {
        playlistService.createPlaylist(request);
    }

    @PostMapping("/{playlistId}/songs/{songId}")
    public void addSongToPlaylist(@PathVariable Long playlistId, @PathVariable Long songId) {
        playlistService.addSongToPlaylist(playlistId, songId);
    }

    @PutMapping("/{id}")
    public void updatePlaylist(@PathVariable Long id, @RequestBody PlaylistRequest request) {
        playlistService.updatePlaylist(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
    }

}
