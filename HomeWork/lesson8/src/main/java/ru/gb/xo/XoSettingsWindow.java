package ru.gb.xo;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XoSettingsWindow extends JFrame {
    /*переменные для хранения размера окна настроек*/
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;
    /*переменные для хранения параметров игры - диапазона значений*/
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Размер поля: ";
    private static final String WIN_LENGTH_PREFIX = "Длина победы в символах: ";
    /*перпеменные для ссылки на класса основного окна, связанных кнопок-выбора, слайсеров*/
    private XoWindow xoWindow;
    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;
    /*конструктор окна настроек*/
    public XoSettingsWindow(XoWindow xoWindow) {
        /*установка размера окна*/
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        /*ссылка на основное окно*/
        this.xoWindow = xoWindow;

        /*определение местоположения окна относительно границ основного окна приложения*/
        Rectangle gameWindowBounds = xoWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        /*запрет на изменение окна пользователем*/
        setResizable(false);
        /*название окна*/
        setTitle("Создать игру");
        /*раскладка окна*/
        setLayout(new GridLayout(8, 1));
        /*добавление кнопок и контролей*/
        addGameModeButtons();
        addGameControls();
        /*содание кнопки начала игры*/
        JButton btnStart = new JButton("Создать новую игру");
        /*описание поведения кнопки*/
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classStartGame();
            }
        });
        /*добавление кнопки в окно*/
        add(btnStart);
    }

    private void addGameModeButtons() {
        /*создание надписи*/
        JLabel label = new JLabel(" Выберите режим");
        /*добавление надписи в окно*/
        add(label);
        /*создание кнопок*/
        humVSAI = new JRadioButton("Человек vs Компьютер");
        humVShum = new JRadioButton("Человек vs Человек");
        /*связь кнопок*/
        ButtonGroup buttonGroup = new ButtonGroup();

        buttonGroup.add(humVSAI);
        buttonGroup.add(humVShum);
        /*выбор кнопки по-умолчанию*/
        humVSAI.setSelected(true);
        /*добавление кнопок в окно*/
        add(humVSAI);
        add(humVShum);
    }

    private void addGameControls() {
        /*создание надписи для отображения размера поля и условия выигрыша*/
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        /*создание слайсеров*/
        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

        /*описание поведения слайсера по изменению размера игрового поля*/
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLen.setMaximum(currentValue);
            }
        });
        /*описание поведения слайсера по изменению условия победы*/
        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
            }
        });
        /*добавление объектов в окно*/
        add(lbFieldSize);
        add(slideFieldSize);
        add(lbWinLength);
        add(slideWinLen);
    }
    /*описание метода по началу игры - нажатие кнопки начать игру*/
    private void classStartGame() {
        /*установка режима игры в зависимости от выбранной кнопки*/
        int gameMode;
        if(humVSAI.isSelected()) {
            gameMode = XoFieldPanel.GAME_MODE_HVAI;
        } else if (humVShum.isSelected()) {
            gameMode = XoFieldPanel.GAME_MODE_HVH;
        } else {
            throw new RuntimeException("Данный режим игры не поддерживается");
        }
        /*передача размера поля и условия победы*/
        int fieldSize = slideFieldSize.getValue();
        int winLength = slideWinLen.getValue();
        /*передача настроек в главное окно*/
        xoWindow.startGame(gameMode, fieldSize, winLength);
        /*изменение видимости окна настроек*/
        setVisible(false);
    }


}
