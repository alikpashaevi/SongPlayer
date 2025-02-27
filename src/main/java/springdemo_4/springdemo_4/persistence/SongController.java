package springdemo_4.springdemo_4.persistence;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springdemo_4.springdemo_4.model.SongDTO;
import springdemo_4.springdemo_4.model.SongRequest;

import static springdemo_4.springdemo_4.constants.AuthorizationConstants.ARTIST_OR_ADMIN;
import static springdemo_4.springdemo_4.constants.AuthorizationConstants.USER_OR_ARTIST_OR_ADMIN;

@RestController
@RequiredArgsConstructor
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    @GetMapping
    @PreAuthorize(USER_OR_ARTIST_OR_ADMIN)
    public Page<SongDTO> getSongs(@RequestParam int page, @RequestParam int pageSize) {
        return songService.getSongs(page, pageSize);
    }

    @GetMapping("/{id}")
    @PreAuthorize(USER_OR_ARTIST_OR_ADMIN)
    public SongDTO getSong(@PathVariable Long id) {
        return songService.getSong(id);
    }

    @PostMapping
    @PreAuthorize(ARTIST_OR_ADMIN)
    public ResponseEntity<Object> addSong(@RequestBody SongRequest request) {
        songService.addSong(request);
        return ResponseEntity.ok("Song added successfully");
    }

    @PutMapping("/{id}")
    @PreAuthorize(ARTIST_OR_ADMIN)
    public ResponseEntity<Object> updateSong(@PathVariable Long id, @RequestBody SongRequest request) {
        songService.updateSong(id, request);
        return ResponseEntity.ok("Song updated successfully");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(ARTIST_OR_ADMIN)
    public ResponseEntity<String> deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return ResponseEntity.ok("Song deleted successfully");
    }
//
//    // Additional feature to get a random song
//    @GetMapping("/random")
//    public SongDTO getRandomSong() {
//        return songService.getRandomSong();
//    }

}
