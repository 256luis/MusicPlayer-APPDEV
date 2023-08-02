package GUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kurt ian rumbaua
 */
import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {

    public SearchPanel() {
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.GRAY);

        // Create a label to indicate the search panel
        JLabel searchLabel = new JLabel("Search Panel");
        searchLabel.setForeground(Color.WHITE);
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        // Center the label in the panel
        setLayout(new GridBagLayout());
        add(searchLabel);
    }
}
