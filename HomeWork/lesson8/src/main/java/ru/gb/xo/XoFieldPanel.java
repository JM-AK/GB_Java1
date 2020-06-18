package ru.gb.xo;

import javax.swing.*;
import java.awt.*;

public class XoFieldPanel extends JPanel {

    public static final int GAME_MODE_HVAI = 0;
    public static final int GAME_MODE_HVH = 1;
    private int fieldSize;

    public XoFieldPanel() {
        setBackground(Color.LIGHT_GRAY);
    }

    public void startGame(int gameMode, int fieldSize, int winLength) {
        System.out.printf(" Game mode: %d%n Field size: %d%n Win length: %d%n", gameMode, fieldSize, winLength);
        this.fieldSize = fieldSize;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 1; i < fieldSize; i++) {
            int cellSizeY = XoWindow.getWindowHeight() / fieldSize;
            int cellSizeX = XoWindow.getWindowWidth() / fieldSize;
            int startX = XoWindow.getWindowPosX();
            int startY = XoWindow.getWindowPosY();
            /*горизонтальные линии*/
            g.drawLine(startX, startY+i * cellSizeY, startX+fieldSize*cellSizeX, startY+i * cellSizeY);
            /*вертикальные линии*/
            g.drawLine(startX+i * cellSizeX, startY, startX+i * cellSizeX, startY+fieldSize*cellSizeY);
        }
    }

}
