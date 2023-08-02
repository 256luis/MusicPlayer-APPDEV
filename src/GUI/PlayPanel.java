package GUI;

import Main.SongController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

public class PlayPanel extends JPanel implements ActionListener {

    private JButton stopButton = new JButton("Stop");
    private JButton playButton = new JButton("Play");
    private JButton pauseButton = new JButton("Pause");

    private SongController songController;
    
    private JLabel titleLabel;
    private JLabel lyricsLabel;
    
    public PlayPanel(SongController songController) {
        this.songController = songController;
        
        // Create title panel at the top with a gradient background
        JPanel titlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(
                        new Point2D.Double(0, 0), Color.BLACK,
                        new Point2D.Double(0, getHeight()), Color.WHITE
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        titleLabel = new JLabel("Title of the Song");
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        // Create lyrics panel in the center with a gradient background
        JPanel lyricsPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(
                        new Point2D.Double(0, 0), Color.BLACK,
                        new Point2D.Double(0, getHeight()), Color.WHITE
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        
        
        lyricsLabel = new JLabel("Lyrics of the Song");
        lyricsLabel.setForeground(Color.WHITE);
        lyricsPanel.add(lyricsLabel);
        
        // Create control panel at the bottom
        Color panelColor = new Color(27, 27, 27);
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        controlPanel.setBackground(panelColor);
        stopButton.addActionListener(this);
        playButton.addActionListener(this);
        pauseButton.addActionListener(this);
        stopButton.setForeground(Color.WHITE);
        playButton.setForeground(Color.WHITE);
        pauseButton.setForeground(Color.WHITE);
        stopButton.setBackground(Color.GRAY);
        playButton.setBackground(Color.GRAY);
        pauseButton.setBackground(Color.GRAY);
        controlPanel.add(stopButton);
        controlPanel.add(playButton);
        controlPanel.add(pauseButton);

        // Use BoxLayout to stack the panels vertically with a small gap between them
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(titlePanel);
        add(Box.createVerticalStrut(10)); // Add a small gap (5 pixels) between titlePanel and lyricsPanel
        add(lyricsPanel);

        // Adjust the height of the control panel
        controlPanel.setPreferredSize(new Dimension(controlPanel.getPreferredSize().width, 50));
        controlPanel.setMaximumSize(new Dimension(controlPanel.getMaximumSize().width, 50));
        
        titlePanel.setPreferredSize(new Dimension(controlPanel.getPreferredSize().width, 120));
        titlePanel.setMaximumSize(new Dimension(controlPanel.getMaximumSize().width, 120));
        
        add(controlPanel);
     
    }
    
    public void refreshLabels() {
        lyricsLabel.setText(songController.getCurrentSong().lyrics);
        titleLabel.setText(songController.getCurrentSong().name);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the button that was clicked
        JButton button = (JButton) e.getSource();

        // Do something based on the button that was clicked
        if (button == stopButton) {
            songController.stop();
        } else if (button == playButton) {
            songController.play();
        } else if (button == pauseButton) {
            songController.pause();
        }
    }
    
}
