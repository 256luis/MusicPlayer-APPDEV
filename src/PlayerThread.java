
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
        try {
            long timeStart = System.currentTimeMillis();
            System.out.println(timeStart);
            int start = 0;
            player.play(start, song.lengthFrames);
        } catch (Exception e) {
            System.out.println("Error occurred when playing the file");
        }
    }
    
    public void pause() {
        endTimeMs = System.currentTimeMillis();
    }
    
    public void cont() {
        
    }
    
    public void close(){
        keepPlaying = false;
        player.close();
        this.interrupt();
    }
}
