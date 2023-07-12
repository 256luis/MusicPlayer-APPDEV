import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JFrame;

public class MusicPlayer extends JFrame {

    SongSelect songSelect;
    SongPlaying songPlaying;
    CardLayout cl;
    
    SQLiteJDBC db;
    
    public MusicPlayer() {
        super("Music Player");
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        cl = new CardLayout();
        setLayout(cl);
        
        songSelect = new SongSelect();
        songPlaying = new SongPlaying();
        
        db = new SQLiteJDBC();
        
        ArrayList<Song> songs = db.getSongs();
        
        add(songSelect, "SongSelect");
        add(songPlaying, "SongPlaying");
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MusicPlayer();
    }
    
}
