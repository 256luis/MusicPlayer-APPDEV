package Main;

import GUI.MenuPanel;
import GUI.SongPanel;
import GUI.PlayPanel;
import GUI.SearchPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MusicPlayer extends JFrame {

    JPanel navigationPanel; // New panel to hold both menuPanel and songPanel
    JPanel cardsPanel;
    CardLayout cardLayout;
    MenuPanel menuPanel;
    SongPanel songPanel;
    PlayPanel playPanel;
    SearchPanel searchPanel;

    SongController songController;

    public MusicPlayer() {
        super("Music Player");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set the background color of the JFrame to pitch black
        Color backgroundColor = new Color(27, 27, 27);

        // Set the layout for the main content pane (BorderLayout)
        setLayout(new BorderLayout());

        // Create the main panel to hold MenuPanel and SongPanel
        navigationPanel = new JPanel();
        navigationPanel.setLayout(new BorderLayout()); // Use BorderLayout for the navigationPanel
        navigationPanel.setOpaque(true); // Set it to be opaque
        navigationPanel.setBackground(null); // Set the background to null to inherit the frame's background
        navigationPanel.setPreferredSize(new Dimension(200, 600)); // Adjust the width as needed
        navigationPanel.setBorder(new EmptyBorder(10, 10, 10, 5)); // Add a small gap (5 pixels top and bottom, 10 pixels left and right)

        // Create the panels
        menuPanel = new MenuPanel(this);
        // Pass the list of songs to the SongPanel constructor
        songController = new SongController();
        ArrayList<Song> songs = songController.getSongs();

        songPanel = new SongPanel(songs);
        playPanel = new PlayPanel();
        searchPanel = new SearchPanel();

        // Set the background color of the panels to black gray
        Color panelColors = new Color(33, 35, 36);
        menuPanel.setBackground(panelColors);
        songPanel.setBackground(panelColors);
        playPanel.setBackground(panelColors); // Set the playPanel's background to black
        searchPanel.setBackground(Color.DARK_GRAY);

        // Add MenuPanel and SongPanel to the main panel with gaps
        navigationPanel.add(menuPanel, BorderLayout.NORTH); // Place menuPanel at the top with a gap of 5 pixels
        navigationPanel.add(songPanel, BorderLayout.CENTER); // Place songPanel in the center with a gap of 5 pixels

        // Create a panel to hold both navigationPanel and playPanel initially
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(navigationPanel, BorderLayout.WEST);
        mainPanel.add(playPanel, BorderLayout.CENTER);
        mainPanel.setBackground(backgroundColor);

        // Create a panel to hold both mainPanel and searchPanel using CardLayout
        cardsPanel = new JPanel();
        cardLayout = new CardLayout();
        cardsPanel.setLayout(cardLayout);

        // Add the mainPanel and searchPanel to the cardsPanel
        cardsPanel.add(mainPanel, "MainPlayPanel");
        cardsPanel.add(searchPanel, "SearchPanel");

        // Add the cardsPanel to the center of the main content pane
        add(cardsPanel, BorderLayout.CENTER);

        // Add an empty border to the playPanel for a small gap
        playPanel.setBorder(new EmptyBorder(10, 5, 10, 10));

        setVisible(true);

        for (Song s : songs) {
            System.out.println("Artist: " + s.artist + ", Song Name: " + s.name + ", Length: " + s.lengthSec + " seconds");
        }
        
//        
//        try {
//            Thread.sleep(2000);
//        } catch (Exception e) {
//            
//        }
//        
        songController.loadSongByID(2);
        songController.play();
        
        try {
            Thread.sleep(2000);
            songController.pause();
            Thread.sleep(2000);
            songController.play();
        } catch (Exception e) {
            System.out.println(e);
        }
} 
    // Method to switch between panels
    public void switchToPanel(String panelName) {
        // Show the specified panel using CardLayout
        cardLayout.show(cardsPanel, panelName);

        // Repaint the frame to reflect the changes
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new MusicPlayer();
    }
}
