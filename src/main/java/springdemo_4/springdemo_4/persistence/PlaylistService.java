package springdemo_4.springdemo_4.persistence;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import springdemo_4.springdemo_4.entity.Playlist;
import springdemo_4.springdemo_4.entity.PlaylistRepository;
import springdemo_4.springdemo_4.entity.Song;
import springdemo_4.springdemo_4.entity.SongRepository;
import springdemo_4.springdemo_4.error.NotFoundException;
import springdemo_4.springdemo_4.model.PlaylistDTO;
import springdemo_4.springdemo_4.model.PlaylistRequest;
import springdemo_4.springdemo_4.model.SongSimpleDTO;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final SongService songService;
//    private final SongRepository songRepository;

    private NotFoundException buildNotFoundException(long id) {
        return new NotFoundException("Playlist with id " + id + " not found");
    }

    private PlaylistDTO convertToPlaylistDTO(Playlist playlist) {
        return new PlaylistDTO(playlist.getId(), playlist.getName(),
                playlist.getSongs().stream()
                        .map(song -> new SongSimpleDTO(song.getId(), song.getName(), song.getDuration())).collect(Collectors.toList())
        );
    }

    public Page<PlaylistDTO> getPlaylists(int page, int pageSize) {

        Page<Playlist> playlists = playlistRepository.getPlaylists(PageRequest.of(page, pageSize));

        return playlists.map(this::convertToPlaylistDTO);
    }

    public PlaylistDTO getPlaylist(Long id) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
        return convertToPlaylistDTO(playlist);
    }

    public void createPlaylist(PlaylistRequest request) {
        Playlist playlist = new Playlist();
        playlist.setName(request.getName());
        playlistRepository.save(playlist);
    }

    public void updatePlaylist(Long id, PlaylistRequest request) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
        if (!Objects.equals(request.getName(), playlist.getName())) {
            playlist.setName(request.getName());
        }
        playlistRepository.save(playlist);
    }

    public void deletePlaylist(Long id) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
        playlistRepository.delete(playlist);
    }

    // add song to playlist
    @Transactional
    public void addSongToPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(() -> buildNotFoundException(playlistId));

        Song song = songService.findSongForOthers(songId);

        if (!playlist.getSongs().contains(song)) {
            playlist.getSongs().add(song);
            playlistRepository.save(playlist);
        }
    }

}
