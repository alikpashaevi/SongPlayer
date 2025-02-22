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

    @PostMapping
    public void createPlaylist(@RequestBody PlaylistRequest request) {
        playlistService.createPlaylist(request);
    }

}
