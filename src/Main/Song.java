package Main;

import java.io.FileInputStream;

public class Song {
    public static final float FRAME_TIME = 0.026f;
    
    public String artist;
    public String name;
    public int lengthSec;
    public int lengthFrames;
    public int id;
    public String path;
    public String lyrics;

    public Song(String artist, String name, int length, int id, String path, String lyricsPath) {
        this.artist = artist;
        this.name = name;
        this.lengthSec = length;
        this.id = id;
        this.path = path;
        
        try {
            FileInputStream fis = new FileInputStream(lyricsPath);
            byte[] bytes = new byte[(int)fis.getChannel().size()];
            fis.read(bytes);
            lyrics = new String(bytes);
        } catch (Exception e) {
            System.out.println("Error reading lyrics file");
        }
        
        this.lengthFrames = (int)(length / FRAME_TIME);
    }
}
