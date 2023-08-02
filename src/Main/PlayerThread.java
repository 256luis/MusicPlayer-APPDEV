package Main;


import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.FileInputStream;
import java.util.EventObject;

public class PlayerThread extends Thread {
    private Song song;
    private AdvancedPlayer player;
    
    private long startTimeMs;
    
    public PlayerThread(Song song, long startTimeMs) {
        this.song = song;
        this.startTimeMs = startTimeMs;
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
            int startFrame = (int)(startTimeMs / (Song.FRAME_TIME * 1000));
            System.out.println(startFrame);
            player.play(startFrame, song.lengthFrames);
        } catch (Exception e) {
            System.out.println("Error occurred when playing the file");
        }
    }
    
    public void close(){
        player.close();
        this.interrupt();
    }
}
