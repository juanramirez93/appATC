package com.atc.ui;
import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
    private JLabel imagePanel;
    private JLabel titlePanel;
    private String title;

    public HeaderPanel(String title) {
        this.title = title;
        initializeVariables();
        initializeLayout();
    }

    private void initializeLayout() {
        setImage();
        this.setLayout(new BorderLayout());
        this.add(this.imagePanel, BorderLayout.WEST);
        titlePanel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        this.add(this.titlePanel, BorderLayout.CENTER);
    }

    private void setImage() {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/logo80.png"));
        imagePanel.setIcon(imageIcon);
    }

    private void initializeVariables() {
        this.imagePanel = new JLabel();
        this.titlePanel = new JLabel(title);
    }
}
