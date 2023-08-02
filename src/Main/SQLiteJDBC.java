package Main;

import java.sql.*;
import java.util.ArrayList;

public class SQLiteJDBC {
    Connection c;
    
    public SQLiteJDBC() {
        c = null;
     
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:songs.db");
             
            String sql = "CREATE TABLE IF NOT EXISTS SONGS ("
                    + "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + "ARTIST VARCHAR(50) NOT NULL,"
                    + "SONG_NAME VARCHAR(50) NOT NULL,"
                    + "LENGTH INTEGER NOT NULL)";
        
            Statement stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    
    public ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<Song>();
        
        try {
            String query = "SELECT * FROM SONGS;";
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query); 
            while (rs.next()) {
                Song s = new Song(
                        rs.getString("ARTIST"),
                        rs.getString("SONG_NAME"),
                        rs.getInt("LENGTH")
                );
                
                songs.add(s);
            }

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        
        return songs;
    }
}