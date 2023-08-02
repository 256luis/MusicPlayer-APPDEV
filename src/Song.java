public class Song {
    public static final float FRAME_TIME = 0.026f;
    
    public String artist;
    public String name;
    public int lengthSec;
    public int lengthFrames;
    public int id;
    public String path;
    
    
    public Song(String artist, String name, int length, int id, String path) {
        this.artist = artist;
        this.name = name;
        this.lengthSec = length;
        this.id = id;
        this.path = path;
        
        this.lengthFrames = (int)(length / FRAME_TIME);
    }
}
