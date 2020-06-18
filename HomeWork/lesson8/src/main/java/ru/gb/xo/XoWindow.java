package ru.gb.xo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*основной управляющий класс-наследник*/
public class XoWindow extends JFrame {

    /*статические переменные-константы для хранения размера окна*/
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_POS_X = 650;
    private static final int WINDOW_POS_Y = 250;

    /*переменные для ссыли на классы для отрисовки настроек и панели*/
    private XoSettingsWindow settingsWindow;
    private XoFieldPanel fieldPanel;
    /*конструктор главного класса окна*/
    public XoWindow() {
        /*установка размеров и места расположения окна*/
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        /*закрытие окна при нажатии пользователем стандартной кнопки закрытия окна*/
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*заголовок окна*/
        setTitle("Крестики - Нолики");
        /*не позволяет пользователю менять размер окна, изменил на true*/
        setResizable(true);
        /*вызов окна настроек при запуске программы*/
        this.settingsWindow = new XoSettingsWindow(this);
        /*создание кнопок и панели для их размещения*/
        JButton buttonStart = createStartButton();
        JButton buttonExit = createExitButton();
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        /*помещение кнопок и панели для кнопок в окне*/
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonExit);
        add(buttonPanel, BorderLayout.SOUTH);
        /*вызов панели для отрисовки поля и размещение ее в окне*/
        this.fieldPanel = new XoFieldPanel();
        add(fieldPanel, BorderLayout.CENTER);
        /*видимость для пользователя*/
        setVisible(true);
    }
    /*передача настроек игры в панель для игрового поля*/
    public void startGame(int gameMode, int fieldSize, int winLength) {
        this.fieldPanel.startGame(gameMode, fieldSize, winLength);
    }
    /*метод с описанием кнопки для начала игры*/
    private JButton createStartButton() {
        JButton button = new JButton("Начать игру");
        /*описание события по нажатию кнопки*/
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        };
        button.addActionListener(listener);
        return button;
    }

    /*метод с описанием кнопки для завершения игры*/
    private JButton createExitButton() {
        JButton button = new JButton("<html><body><b>Выйти</b></body></html>");
        /*описание события по нажатию кнопки*/
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return button;
    }

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }

    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    public static int getWindowPosX() {
        return WINDOW_POS_X;
    }

    public static int getWindowPosY() {
        return WINDOW_POS_Y;
    }
}
