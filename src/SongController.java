public class SongController {
    private Song currentSong;
    private SongsDB db = new SongsDB();
    
    private PlayerThread playerThread;
    
    public SongController() {
        
    }
    
    public void loadSongByID(int id) {
        currentSong = db.getSongByID(id);
    }
    
    public void play() {
        playerThread = new PlayerThread(currentSong);
        playerThread.start();
    }
    
    public void pause() {
        playerThread.stop();
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
