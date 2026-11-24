
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.CharacterManager;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager v0.5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(12, 12));
        getContentPane().setBackground(AppTheme.BG_MAIN);

        add(createTopPanel(), BorderLayout.NORTH);
        add(createCharacterScrollPane(), BorderLayout.CENTER);
        add(createLegendPanel(), BorderLayout.EAST);
        add(createStatusBar(), BorderLayout.SOUTH);

        setMinimumSize(new Dimension(650, 450));
        pack();
        setLocationRelativeTo(null);
    }

    // NORTH: Header dan statistik
    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(
            new BoxLayout(topPanel, BoxLayout.Y_AXIS)
        );
        topPanel.setBackground(AppTheme.BG_MAIN);

        JLabel title = new JLabel("CHARACTER MANAGER");
        title.setFont(AppTheme.FONT_TITLE);
        title.setForeground(AppTheme.TEXT_MAIN);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitle = new JLabel(
            "Manage your characters and their abilities"
        );
        subtitle.setFont(AppTheme.FONT_BODY);
        subtitle.setForeground(AppTheme.TEXT_LIGHT);
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(AppTheme.BG_MAIN);
        header.setBorder(new EmptyBorder(10, 15, 10, 15));

        header.add(title);
        header.add(Box.createVerticalStrut(5));
        header.add(subtitle);

        JPanel statistics = createStatisticsPanel();

        topPanel.add(header);
        topPanel.add(statistics);

        return topPanel;
    }

    // Panel tambahan: GridLayout 2x2
    private JPanel createStatisticsPanel() {
        List<Character> characters = manager.getAllCharacters();

        int total = characters.size();
        int totalLevel = 0;
        int highLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();

            if (character.getLevel() >= AppTheme.HIGH_LEVEL_THRESHOLD) {
                highLevel++;
            }
        }

        double average = total == 0 ? 0 : (double) totalLevel / total;

        JPanel panel = new JPanel(new GridLayout(2, 2, 8, 8));
        panel.setBackground(AppTheme.BG_MAIN);
        panel.setBorder(new EmptyBorder(5, 15, 10, 15));

        panel.add(createStatLabel("Total Characters: " + total));
        panel.add(createStatLabel(
            String.format("Average Level: %.1f", average)
        ));
        panel.add(createStatLabel("High Level: " + highLevel));
        panel.add(createStatLabel("Roles: " + CharacterType.values().length));

        return panel;
    }

    private JLabel createStatLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(AppTheme.FONT_BODY);
        label.setForeground(AppTheme.TEXT_MAIN);
        label.setBorder(AppTheme.CARD_BORDER);
        return label;
    }

    // CENTER: Daftar karakter dalam JScrollPane
    private JScrollPane createCharacterScrollPane() {

        JPanel characterPanel = new JPanel(
            new GridLayout(0, 2, 12, 12)
        );
        characterPanel.setBackground(AppTheme.BG_MAIN);
        characterPanel.setBorder(new EmptyBorder(12, 12, 12, 12));

        for (Character character : manager.getAllCharacters()) {
            characterPanel.add(createCharacterCard(character));
        }

        // Panel pembungkus kartu
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(AppTheme.BG_MAIN);

        // Kartu diletakkan di NORTH panel pembungkus
        wrapper.add(characterPanel, BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane(wrapper);

        scroll.setPreferredSize(new Dimension(720, 480));
        scroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );
        scroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        return scroll;
    }

    // Kartu karakter
    private JPanel createCharacterCard(Character character) {

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        card.setOpaque(true);
        card.setBackground(
            AppTheme.colorFor(character.getType())
        );

        card.setBorder(AppTheme.CARD_BORDER);

        JLabel name = new JLabel(character.getName());
        name.setFont(AppTheme.FONT_TITLE);
        name.setForeground(AppTheme.TEXT_MAIN);

        JLabel role = new JLabel(
            "Role: " + character.getType()
        );
        role.setFont(AppTheme.FONT_BODY);
        role.setForeground(AppTheme.TEXT_MAIN);

        JLabel level = new JLabel(
            "Level: " + character.getLevel()
        );

        if (character.getLevel() >= AppTheme.HIGH_LEVEL_THRESHOLD) {
            level.setForeground(AppTheme.GOLD);
            level.setFont(AppTheme.FONT_TITLE);
        } else {
            level.setForeground(AppTheme.TEXT_MAIN);
            level.setFont(AppTheme.FONT_BODY);
        }

        card.setBorder(
            BorderFactory.createCompoundBorder(
                AppTheme.CARD_BORDER,
                new EmptyBorder(12, 12, 12, 12)
            )
        );

        card.add(name);
        card.add(Box.createVerticalStrut(6));
        card.add(role);
        card.add(level);

        card.setToolTipText(character.getType().toString());
        card.setAlignmentX(Component.LEFT_ALIGNMENT);

        return card;
    }

    // EAST: Legenda din CharacterType.values()
    private JPanel createLegendPanel() {

        JPanel legendPanel = new JPanel();

        // Target BoxLayout adalah legendPanel
        legendPanel.setLayout(
            new BoxLayout(legendPanel, BoxLayout.Y_AXIS)
        );

        legendPanel.setBackground(AppTheme.BG_MAIN);
        legendPanel.setBorder(new EmptyBorder(15, 10, 15, 15));

        JLabel title = new JLabel("CHARACTER ROLES");
        title.setFont(AppTheme.FONT_TITLE);
        title.setForeground(AppTheme.TEXT_MAIN);

        legendPanel.add(title);
        legendPanel.add(Box.createVerticalStrut(15));

        for (CharacterType type : CharacterType.values()) {

            JLabel role = new JLabel(
                "● " + type.toString()
            );

            role.setFont(AppTheme.FONT_BODY);
            role.setForeground(AppTheme.colorFor(type));

            legendPanel.add(role);
            legendPanel.add(Box.createVerticalStrut(12));
        }

        legendPanel.add(Box.createVerticalGlue());

        return legendPanel;
    }

    // SOUTH: Status bar
    private JPanel createStatusBar() {

        JPanel statusBar = new JPanel();
        statusBar.setLayout(
            new BoxLayout(statusBar, BoxLayout.X_AXIS)
        );

        statusBar.setBackground(AppTheme.BG_MAIN);
        statusBar.setBorder(new EmptyBorder(10, 15, 10, 15));

        JLabel status = new JLabel(
            "Total Characters: " +
            manager.getAllCharacters().size()
        );

        JLabel version = new JLabel("v0.5");

        status.setFont(AppTheme.FONT_BODY);
        version.setFont(AppTheme.FONT_MONO);

        status.setForeground(AppTheme.TEXT_MAIN);
        version.setForeground(AppTheme.TEXT_LIGHT);

        statusBar.add(status);
        statusBar.add(Box.createHorizontalGlue());
        statusBar.add(version);

        return statusBar;
    }
}
