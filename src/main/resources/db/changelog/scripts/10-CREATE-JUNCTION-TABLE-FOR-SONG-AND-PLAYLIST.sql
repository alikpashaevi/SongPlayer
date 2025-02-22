CREATE TABLE songs.playlist_song (
   playlist_id BIGINT NOT NULL,
   song_id BIGINT NOT NULL,
   PRIMARY KEY (playlist_id, song_id),
   CONSTRAINT fk_playlist FOREIGN KEY (playlist_id) REFERENCES playlist(id),
   CONSTRAINT fk_song FOREIGN KEY (song_id) REFERENCES song(id)
);

CREATE SEQUENCE songs.playlist_song_seq
    INCREMENT 1
    START 1000;