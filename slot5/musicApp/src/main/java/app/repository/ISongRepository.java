package app.repository;

import app.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    void update(Song song);

    void remove(Song song);
}
