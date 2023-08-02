package Main;

import java.util.ArrayList;

public class SongController {
    private Song currentSong;
    private SongsDB db = new SongsDB();
    
    private PlayerThread playerThread;
    
    long elapsedTimeMs = 0;
    long startTimeMs = 0;
    
    public SongController() {
        
    }
    
    public void loadSongByID(int id) {
        if (playerThread != null && playerThread.isAlive()) {
            playerThread.close();
        }
        
        currentSong = db.getSongByID(id);
    }
    
    public ArrayList<Song> getSongs() {
        return db.getSongs();
    }
    
    public void play() {
        startTimeMs = System.currentTimeMillis();
        playerThread = new PlayerThread(currentSong, elapsedTimeMs);
        playerThread.start();
    }
    
    public void pause() {
        elapsedTimeMs = System.currentTimeMillis() - startTimeMs;
        if (playerThread.isAlive()) {
            playerThread.close();
        }
    }
    
    public void setTime() {
        // todo
    }
    
    public void stop() {
        playerThread.close();
    }
}
