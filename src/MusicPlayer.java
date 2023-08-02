import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JFrame;

public class MusicPlayer extends JFrame {
    CardLayout cl;
    
    SongController songController;
    
    public MusicPlayer() {
        super("Music Player");
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        cl = new CardLayout();
        setLayout(cl);
        
        setVisible(true);
        
        songController = new SongController();
        songController.loadSongByID(2);
        songController.play();
//        
        try {
            Thread.sleep(2500);
            songController.pause();
            Thread.sleep(500);
            songController.play();
        } catch (Exception e) {
            
        }
        
        
    }
    
    public static void main(String[] args) {
        new MusicPlayer();
    }
    
}
