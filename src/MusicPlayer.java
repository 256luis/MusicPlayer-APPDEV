import java.awt.CardLayout;
import javax.swing.JFrame;

public class MusicPlayer extends JFrame {

    SongSelect songSelect;
    SongPlaying songPlaying;
    CardLayout cl;
    
    public MusicPlayer() {
        super("Music Player");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        cl = new CardLayout();
        setLayout(cl);
        
        songSelect = new SongSelect();
        songPlaying = new SongPlaying();
        
        add(songSelect, "SongSelect");
        add(songPlaying, "SongPlaying");
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MusicPlayer();
    }
    
}
