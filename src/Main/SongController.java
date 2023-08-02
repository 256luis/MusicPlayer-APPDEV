package Main;

import java.util.ArrayList;

public class SongController {
    private Song currentSong;
    private SongsDB db = new SongsDB();
    
    private PlayerThread playerThread;
    
    public SongController() {
        
    }
    
    public void loadSongByID(int id) {
        currentSong = db.getSongByID(id);
        playerThread = new PlayerThread(currentSong);
    }
    
    public ArrayList<Song> getSongs() {
        return db.getSongs();
    }
    
    public void play() {
        playerThread.start();
    }
    
    public void pause() {
        playerThread.pause();
    }
    
    public void resume() {
        playerThread.cont();
    }
    
    public void setTime() {
        // todo
    }
    
    public void stop() {
        playerThread.close();
    }
}
