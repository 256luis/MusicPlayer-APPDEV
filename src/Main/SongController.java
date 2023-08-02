package Main;

import java.util.ArrayList;

public class SongController {
    private Song currentSong;
    private SongsDB db = new SongsDB();
    
    private PlayerThread playerThread;
    
    long elapsedTimeMs = 0;
    long startTimeMs = 0;
    
    private int PAUSED = 0;
    private int PLAYING = 1;
    private int STOPPED = 2;
    
    int state = STOPPED;
    
    boolean isReady = false;
    
    public SongController() {   
    
    }
    
    public void loadSongByID(int id) {
        elapsedTimeMs = 0;
        startTimeMs = 0;
        
        if (playerThread != null && playerThread.isAlive()) {
            playerThread.close();
        }
        
        currentSong = db.getSongByID(id);
        
        state = STOPPED;
        isReady = true;
    }
    
    public ArrayList<Song> getSongs() {
        return db.getSongs();
    }
    
    public void play() {
        if (state == PLAYING) return;
        
        state = PLAYING;
        
        startTimeMs = System.currentTimeMillis();
        playerThread = new PlayerThread(currentSong, elapsedTimeMs);
        playerThread.start();
    }
    
    public void pause() {
        if (state == PAUSED) return;
        
        state = PAUSED;
        
        elapsedTimeMs += System.currentTimeMillis() - startTimeMs;
        if (playerThread.isAlive()) {
            playerThread.close();
        }
        
    }
    
    public void setTime() {
        // todo
    }
    
    public Song getCurrentSong() {
        return currentSong;
    }
    
    public void stop() {
        if (state == STOPPED) return;
        
        state = STOPPED;
        
        elapsedTimeMs = 0;
        startTimeMs = 0;
        
        if (playerThread != null && playerThread.isAlive()) {
            playerThread.close();
        }
    }
}
