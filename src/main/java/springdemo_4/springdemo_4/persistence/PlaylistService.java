package springdemo_4.springdemo_4.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import springdemo_4.springdemo_4.entity.Playlist;
import springdemo_4.springdemo_4.entity.PlaylistRepository;
import springdemo_4.springdemo_4.model.PlaylistDTO;
import springdemo_4.springdemo_4.model.PlaylistRequest;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Page<PlaylistDTO> getPlaylists(int page, int pageSize) {
        return playlistRepository.findPlaylists(PageRequest.of(page, pageSize));
    }

    public Playlist findPlaylist(Long id) {
        return playlistRepository.findById(id).get();
    }

    public void createPlaylist(PlaylistRequest request) {
        Playlist newPlaylist = new Playlist();
        newPlaylist.setName(request.getName());
        newPlaylist.setReleaseYear(request.getReleaseYear());

        playlistRepository.save(newPlaylist);
    }

    public void updatePlaylist(Long id, PlaylistRequest request) {
        Playlist updatedPlaylist = playlistRepository.findById(id).get();
        updatedPlaylist.setName(request.getName());
        updatedPlaylist.setReleaseYear(request.getReleaseYear());

        playlistRepository.save(updatedPlaylist);
    }

    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }

}
