package springdemo_4.springdemo_4.persistence;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springdemo_4.springdemo_4.model.PlaylistDTO;
import springdemo_4.springdemo_4.model.PlaylistRequest;

import static springdemo_4.springdemo_4.security.AuthorizationConstants.USER_OR_ARTIST_OR_ADMIN;

@RestController
@RequestMapping("/playlists")
@RequiredArgsConstructor
@PreAuthorize(USER_OR_ARTIST_OR_ADMIN)
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
    public void createPlaylist(@RequestBody @Valid PlaylistRequest request) {
        playlistService.createPlaylist(request);
    }

    @PostMapping("/{playlistId}/songs/{songId}")
    public void addSongToPlaylist(@PathVariable Long playlistId, @PathVariable Long songId) {
        playlistService.addSongToPlaylist(playlistId, songId);
    }

    @PutMapping("/{id}")
    public void updatePlaylist(@PathVariable Long id, @RequestBody @Valid PlaylistRequest request) {
        playlistService.updatePlaylist(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
    }

}
