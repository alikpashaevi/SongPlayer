package springdemo_4.springdemo_4.persistence;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdemo_4.springdemo_4.model.SongDTO;
import springdemo_4.springdemo_4.model.SongRequest;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public Page<SongDTO> getSongs(@RequestParam int page, @RequestParam int pageSize) {
        return songService.getSongs(page, pageSize);
    }

    @GetMapping("/{id}")
    public SongDTO getSong(@PathVariable Long id) {
        return songService.getSong(id);
    }

    @PostMapping
    public ResponseEntity<Object> addSong(@RequestBody SongRequest request) {
        songService.addSong(request);
        return ResponseEntity.ok("Song added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSong(@PathVariable Long id, @RequestBody SongRequest request) {
        songService.updateSong(id, request);
        return ResponseEntity.ok("Song updated successfully");
    }

    @DeleteMapping("/{id}")
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
