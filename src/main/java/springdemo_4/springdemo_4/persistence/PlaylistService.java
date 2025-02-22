package springdemo_4.springdemo_4.persistence;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import springdemo_4.springdemo_4.entity.Playlist;
import springdemo_4.springdemo_4.entity.PlaylistRepository;
import springdemo_4.springdemo_4.model.PlaylistDTO;
import springdemo_4.springdemo_4.model.PlaylistRequest;
import springdemo_4.springdemo_4.model.SongSimpleDTO;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

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

    public void createPlaylist(PlaylistRequest request) {
        Playlist playlist = new Playlist();
        playlist.setName(request.getName());
        playlistRepository.save(playlist);
    }

}
