package world.ucode.settings;

import world.ucode.main.GameGeometry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterSkin extends JPanel implements ActionListener {

    private static final String dinoString = "normal";
    private static final String redString = "red";
    private static final String greenString = "green";
    private GameGeometry gg;

    public CharacterSkin(GameGeometry gg) {
        super(new BorderLayout());
        this.gg = gg;

        JLabel label = new JLabel("Dino's skin color");
        label.setFont(new Font("Calibri", Font.PLAIN, 15));

        JRadioButton dinoButton = new JRadioButton(dinoString);
        dinoButton.setActionCommand(dinoString);

        JRadioButton redButton = new JRadioButton(redString);
        redButton.setActionCommand(redString);

        JRadioButton greenButton = new JRadioButton(greenString);
        greenButton.setActionCommand(greenString);

        dinoButton.setSelected(true);

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(dinoButton);
        group.add(redButton);
        group.add(greenButton);

        //Register a listener for the radio buttons.
        dinoButton.addActionListener(this);
        redButton.addActionListener(this);
        greenButton.addActionListener(this);

        //Put the radio buttons in a row in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(1, 0));
        radioPanel.add(dinoButton);
        radioPanel.add(redButton);
        radioPanel.add(greenButton);

        add(label, BorderLayout.BEFORE_FIRST_LINE);
        add(radioPanel, BorderLayout.LINE_START);
    }

    // Listens to the radio buttons.
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == dinoString) {
            gg.setDinoSkin(GameGeometry.ColorSkin.NORMAL);
        } else if (e.getActionCommand() == redString) {
            gg.setDinoSkin(GameGeometry.ColorSkin.RED);
        } else {
            gg.setDinoSkin(GameGeometry.ColorSkin.GREEN);
        }
    }
}

