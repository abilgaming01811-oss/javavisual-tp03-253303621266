
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.CharacterManager;
import com.unpri.charactermanager.model.Character;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    public MainWindow(CharacterManager manager) {
        super("Character Manager v0.4");
        this.manager = manager;

        initComponents();

        pack();
        setMinimumSize(new Dimension(420, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(
                new BoxLayout(mainPanel, BoxLayout.Y_AXIS)
        );
        mainPanel.setBackground(AppTheme.BG_MAIN);
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(16, 16, 16, 16)
        );

        JLabel titleLabel = new JLabel(
                "Daftar Karakter (" + manager.getAllCharacters().size() + ")"
        );
        titleLabel.setFont(AppTheme.FONT_TITLE);
        titleLabel.setForeground(AppTheme.TEXT_MAIN);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(12));

        for (Character character : manager.getAllCharacters()) {
            mainPanel.add(createCharacterLabel(character));
            mainPanel.add(Box.createVerticalStrut(8));
        }

        add(new JScrollPane(mainPanel));
    }

    private JLabel createCharacterLabel(Character character) {
        String info = character.getName()
                + " | " + character.getType()
                + " | Lv." + character.getLevel()
                + " | HP:" + character.getHitPoints()
                + " | ATK:" + character.getAttack();

        JLabel label = new JLabel(info);
        label.setFont(AppTheme.FONT_BODY);
        label.setForeground(AppTheme.TEXT_LIGHT);
        label.setBackground(AppTheme.colorFor(character.getType()));
        label.setOpaque(true);
        label.setBorder(AppTheme.CARD_BORDER);

        // Properti tambahan 1: informasi role saat kursor diarahkan ke kartu.
        label.setToolTipText(AppTheme.describe(character.getType()));

        // Properti tambahan 2: kursor tangan untuk menandai kartu.
        label.setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        // Mini-challenge: level tinggi ditampilkan emas dan tebal.
        if (character.getLevel() >= AppTheme.HIGH_LEVEL_THRESHOLD) {
            label.setForeground(AppTheme.GOLD);
            label.setFont(AppTheme.FONT_BODY.deriveFont(Font.BOLD));
        }

        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }
}
