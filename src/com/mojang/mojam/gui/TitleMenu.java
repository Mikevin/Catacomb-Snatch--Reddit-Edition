package com.mojang.mojam.gui;

import java.awt.event.KeyEvent;

import com.mojang.mojam.screen.*;


public class TitleMenu extends GuiMenu {

    public static final int START_GAME_ID = 1000;
    public static final int HOST_GAME_ID = 1002;
    public static final int JOIN_GAME_ID = 1003;
    public static final int EXIT_GAME_ID = 1001;

    public static final int CANCEL_JOIN_ID = 1004;
    public static final int PERFORM_JOIN_ID = 1005;
    public static final int RESTART_GAME_ID = 1006;
    public static final int HELP_ID = 1007;
    

    // public static lol... ;)
    public static String ip = "";

    private int selectedItem = 0;
    private final int gameWidth;

    public TitleMenu(int gameWidth, int gameHeight) {
        super();
        this.gameWidth = gameWidth;

        addButton(new Button(START_GAME_ID, "Start"	, 0, (gameWidth - 128) / 2, 180));
        addButton(new Button(HOST_GAME_ID, 	"Host"	, 0, (gameWidth - 128) / 2, 220));
        addButton(new Button(JOIN_GAME_ID, 	"Join"	, 0, (gameWidth - 128) / 2, 260));
        addButton(new Button(HELP_ID,		"Help"	, 0, (gameWidth - 128) / 2, 300));
        addButton(new Button(EXIT_GAME_ID, 	"Exit"	,  0, (gameWidth - 128) / 2, 340));
        
    }

    public void render(Screen screen) {

        screen.clear(0);
//        screen.blit(Art.titles[1], 0, 10);
        screen.blit(Art.titleScreen, 0, 0);

        super.render(screen);

        screen.blit(Art.lordLard[0][6], (gameWidth - 128) / 2 - 40, 180 + selectedItem * 40);
    }

    @Override
    public void buttonPressed(Button button) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            selectedItem--;
            if (selectedItem < 0) {
                selectedItem = 4;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            selectedItem++;
            if (selectedItem > 4) {
                selectedItem = 0;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            e.consume();
            buttons.get(selectedItem).postClick();
        }
    }

    public void keyReleased(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent arg0) {
    }

}
