package springdemo_4.springdemo_4.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springdemo_4.springdemo_4.entity.PlaylistRepository;
import springdemo_4.springdemo_4.entity.Song;
import springdemo_4.springdemo_4.entity.SongRepository;
import springdemo_4.springdemo_4.model.PlaylistDTO;
import springdemo_4.springdemo_4.model.SongDTO;
import springdemo_4.springdemo_4.model.SongRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final PlaylistService playlistService;

    public SongService(SongRepository songRepository, PlaylistService playlistService) {
        this.songRepository = songRepository;
        this.playlistService = playlistService;
    }

    private SongDTO mapSong(Song song) {
        return new SongDTO(song.getId(), song.getName(), song.getArtist(), song.getDuration(),
                new PlaylistDTO(
                        song.getPlaylist().getId(),
                        song.getPlaylist().getName(),
                        song.getPlaylist().getReleaseYear()
                )
        );
    }

    public Page<SongDTO> getSongs(int page, int pageSize) {
        return songRepository.findSongs(PageRequest.of(page, pageSize));
    }

    public SongDTO getSong(Long id) {
        Song song = songRepository.findById(id).get();
        return mapSong(song);
    }

    public void addSong(SongRequest request) {
        Song newSong = new Song();
        newSong.setName(request.getName());
        newSong.setArtist(request.getArtist());
        newSong.setDuration(request.getDuration());
        newSong.setPlaylist(playlistService.findPlaylist(request.getPlaylistId()));
        songRepository.save(newSong);
    }

    public void updateSong(Long id, SongRequest request) {
        Song song = songRepository.findById(id).get();
        song.setName(request.getName());
        song.setArtist(request.getArtist());
        song.setDuration(request.getDuration());
        if (request.getPlaylistId() != song.getPlaylist().getId()) {
            song.setPlaylist(playlistService.findPlaylist(request.getPlaylistId()));
        }
        songRepository.save(song);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }



}
