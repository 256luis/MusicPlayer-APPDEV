package Main;


import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.FileInputStream;
import java.util.EventObject;

public class PlayerThread extends Thread {
    private Song song;
    private AdvancedPlayer player;
    private boolean keepPlaying = true;
    
    private EventObject playEvent;
    
    private long startTimeMs = 0;
    private long endTimeMs = 0;
    private long timeElapsed = 0;
    
    public PlayerThread(Song song) {
        this.song = song;
        try {
            FileInputStream file = new FileInputStream(song.path);
            player = new AdvancedPlayer(file);
        } catch (Exception e) {
            System.out.println("Error occurred when loading file.");
        }
    }
    
    public void run() {
        System.out.println("in run");
        try {
            startTimeMs = System.currentTimeMillis();
            int startFrame = (int)(timeElapsed / Song.FRAME_TIME);
            
            player.play(startFrame, song.lengthFrames);
        } catch (Exception e) {
            System.out.println("Error occurred when playing the file");
        }
    }
    
    public void pause() {
        endTimeMs = System.currentTimeMillis();
        timeElapsed = endTimeMs - startTimeMs;
        System.out.println(timeElapsed);
        this.close();
    }
    
    public void cont() {
        
    }
    
    public void close(){
        keepPlaying = false;
        player.close();
        this.interrupt();
    }
}
