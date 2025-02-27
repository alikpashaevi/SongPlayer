package springdemo_4.springdemo_4.persistence;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import springdemo_4.springdemo_4.entity.ArtistRepository;
import springdemo_4.springdemo_4.entity.Song;
import springdemo_4.springdemo_4.entity.SongRepository;
import springdemo_4.springdemo_4.error.NotFoundException;
import springdemo_4.springdemo_4.model.*;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final AlbumService albumService;
    private final ArtistService artistService;

    private NotFoundException buildNotFoundException(long id) {
        return new NotFoundException("Song with id " + id + " not found");
    }

    private SongDTO mapSong(Song song) {
        return new SongDTO(song.getId(), song.getName(), song.getDuration(),
                new AlbumSimpleDTO(
                        song.getAlbum().getId(),
                        song.getAlbum().getName(),
                        song.getAlbum().getReleaseYear()
                ),
                new ArtistSimpleDTO(
                        song.getArtist().getId(),
                        song.getArtist().getName(),
                        song.getArtist().getMonthlyListeners()
                )
        );
    }

    public Page<SongDTO> getSongs(int page, int pageSize) {
        return songRepository.findSongs(PageRequest.of(page, pageSize));
    }

    public Song findSongForOthers(Long songId) {
        return songRepository.findById(songId).orElseThrow(() -> buildNotFoundException(songId));
    }

    public SongDTO getSong(Long id) {
        Song song = songRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
        return mapSong(song);
    }

    public void addSong(SongRequest request) {
        Song newSong = new Song();
        newSong.setName(request.getName());
        newSong.setArtist(artistService.findArtistForOthers(request.getArtistId()));
        newSong.setDuration(request.getDuration());
        newSong.setAlbum(albumService.findAlbumForOthers(request.getAlbumId()));
        songRepository.save(newSong);
    }

    public void updateSong(Long id, SongRequest request) {
        Song song = songRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
        song.setName(request.getName());
        song.setDuration(request.getDuration());
        if (!Objects.equals(request.getAlbumId(), song.getAlbum().getId())) {
            song.setAlbum(albumService.findAlbumForOthers(request.getAlbumId()));
        }
        if (!Objects.equals(request.getArtistId(), song.getArtist().getId())) {
            song.setArtist(artistService.findArtistForOthers(request.getArtistId()));
        }
        songRepository.save(song);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
