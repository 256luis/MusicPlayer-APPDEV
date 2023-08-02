package GUI;

import Main.MusicPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    public MenuPanel(MusicPlayer musicPlayer) {
        setOpaque(true); // Set the panel as opaque
        setPreferredSize(new Dimension(500, 100)); // Increase the height to make both buttons visible
        setBackground(Color.DARK_GRAY);

        // Create and style buttons
        JButton homeButton = new JButton("Home");
        JButton searchButton = new JButton("Search");
        homeButton.setForeground(Color.WHITE);
        searchButton.setForeground(Color.WHITE);
        homeButton.setBackground(Color.DARK_GRAY);
        searchButton.setBackground(Color.DARK_GRAY);

        // Set layout for the MenuPanel to vertically stack the buttons
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Add some vertical spacing between buttons
        add(Box.createVerticalStrut(10));

        // Add the home button
        add(homeButton);

        // Add some more vertical spacing between buttons
        add(Box.createVerticalStrut(10));

        // Add the search button
        add(searchButton);

        // Add vertical glue to push the buttons to the top
        add(Box.createVerticalGlue());

        // Add ActionListener to the search button to switch to SearchPanel
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.switchToPanel("SearchPanel");
            }
        });
    }
}