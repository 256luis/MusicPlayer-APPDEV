package Main;

import java.sql.*;
import java.util.ArrayList;

public class SongsDB {
    Connection c;
    
    private ArrayList<Song> songs = new ArrayList<Song>();
    
    public SongsDB() {
        connectToDatabase();
        importSongs();
    }
    
    private void connectToDatabase() {
        c = null;
     
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:songs.db");
            
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(1);
        }
        System.out.println("Opened database successfully");
    }
    
    // function that pulls all songs from the database
    private void importSongs() {
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from songs"); 
            while (rs.next()) {
                Song s = new Song(
                        rs.getString("artist"),
                        rs.getString("song_name"),
                        rs.getInt("song_length"),
                        rs.getInt("id"),
                        rs.getString("file_path"),
                        rs.getString("lyrics_path")
                );
//                
                // System.out.printf("%s\n", rs.getString("song_name"));
                // System.out.println("in here");
                 songs.add(s);
            }

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
            System.out.println("in catch");
        }
        
        System.out.println("Loaded songs from databse.");
        System.out.printf("%-5s%-30s%-50s%-30s\n",
                "ID", "ARTIST", "NAME", "LENGTH");
        for (Song s : songs) {
            System.out.printf("%-5d%-30s%-50s%-30d\n",
                    s.id,
                    s.artist,
                    s.name,
                    s.lengthSec
            );
        }
    }
    
    public Song getSongByID(int id) {
        for (Song s : songs) {
            if (s.id == id) {
                return s;
            }
        }
        
        return null;
    }
    
    public ArrayList<Song> getSongs() {
        return songs;
    }
}