package GUI;

import Main.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.border.Border;

public class SongPanel extends JPanel {
    private SongController songController;
    private PlayPanel playPanel;
    
    public SongPanel(ArrayList<Song> songs, SongController songController, PlayPanel playPanel) {
        this.songController = songController;
        this.playPanel = playPanel;
        
        Color color = new Color(33, 35, 36);
        setBackground(color);

        // Create a panel to hold the song labels
        JPanel songLabelsPanel = new JPanel();
        songLabelsPanel.setLayout(new GridLayout(0, 1)); // Single column layout
        songLabelsPanel.setBackground(color);

        JLabel featuredSongsLabel = new JLabel("Featured Songs");
        featuredSongsLabel.setForeground(Color.WHITE);
        // Add some padding to the featuredSongsLabel
        featuredSongsLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        songLabelsPanel.add(featuredSongsLabel);

        // Placeholder song names
        for (int i = 1; i <= 10; i++) {
            JLabel songLabel = new JLabel("Song " + i);
            songLabel.setForeground(Color.WHITE);
            songLabel.setBorder(createSongLabelBorder());
            songLabelsPanel.add(songLabel);
        }

        // Fill the actual songs from the ArrayList, if available
        int songCount = Math.min(songs.size(), 10);
        for (int i = 0; i < songCount; i++) {
            Song song = songs.get(i);
            JLabel songLabel = (JLabel) songLabelsPanel.getComponent(i + 1); // Skip the "Featured Songs" label
            songLabel.setText(song.name);
            songLabel.addMouseListener(new SongLabelMouseListener(songLabel, song.id));
        }

        // Make the panel scrollable
        JScrollPane scrollPane = new JScrollPane(songLabelsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(200, 400));
        scrollPane.setBorder(null);

        JViewport viewport = scrollPane.getViewport();
        viewport.setBackground(color);

        // Add the scrollable panel to the SongPanel
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    // Create a custom border for the song labels
    private Border createSongLabelBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY), // Bottom border
                BorderFactory.createEmptyBorder(5, 0, 5, 0) // Add some padding
        );
    }

    // Custom MouseListener for the song labels
    private class SongLabelMouseListener extends MouseAdapter {
        private final JLabel label;
        private final int songId;

        public SongLabelMouseListener(JLabel label, int songId) {
            this.label = label;
            this.songId = songId;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // Handle the click event
            highlightSelectedSong(label);
            songController.loadSongByID(songId);
            songController.play();
            playPanel.refreshLabels();
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // Handle mouse enter event (optional)
            label.setForeground(Color.RED);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Handle mouse exit event (optional)
            label.setForeground(Color.WHITE);
        }
    }


    // Method to highlight the selected song
    private void highlightSelectedSong(JLabel selectedLabel) {
        // Reset the foreground color of all song labels
        Component[] components = getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                ((JLabel) component).setForeground(Color.WHITE);
            }
        }

        // Highlight the selected song label
        selectedLabel.setForeground(Color.RED);
    }
}
