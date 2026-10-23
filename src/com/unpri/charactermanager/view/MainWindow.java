
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.CharacterManager;
import com.unpri.charactermanager.model.Character;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titleLabel = new JLabel("Daftar Karakter");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(10));

        for (Character character : manager.getAllCharacters()) {
            JLabel characterLabel = new JLabel(
                character.getName()
                + " - " + character.getType()
                + " - Level " + character.getLevel()
            );

            characterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(characterLabel);
        }

        panel.add(Box.createVerticalStrut(15));

        JLabel averageLabel = new JLabel(
            String.format(
                "Rata-rata Level: %.2f",
                manager.getAverageLevel()
            )
        );

        averageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        averageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(averageLabel);

        add(new JScrollPane(panel));
    }
}
