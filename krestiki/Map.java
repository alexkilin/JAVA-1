package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;

    int[][] field;
    int fieldSizeX;
    int fieldSizeY;
    int winLength;

    int cellHeight;
    int cellWidth;

    int XField;
    int YField;

    boolean isInit = false;


    public Map() {
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        System.out.println(cellX + " " + cellY);
        XField = cellX;
        YField = cellY;
        System.out.println("есть ход");
        GameLogik.map[YField][XField] = GameLogik.DOT_X;
        if (GameLogik.checkWin(GameLogik.DOT_X)) {
            {System.out.println("Победил человек");}
        }
        if (GameLogik.isMapFull()) {
            System.out.println("Ничья");
            //break;
        }
          GameLogik.BestTurn = false;
           for (int i = 0; i < fieldSizeX; i++) { //подбор хода искусственным интеллектом для целей победы
              for (int j = 0; j < fieldSizeX; j++) { // следующим ходом
                if (GameLogik.map[i][j]==GameLogik.DOT_EMPTY) {
                       GameLogik.map[i][j]=GameLogik.DOT_O;
                        if (GameLogik.checkWin(GameLogik.DOT_O)) {
                            GameLogik.ai_X = j;
                            GameLogik.ai_Y = i;
                           GameLogik.BestTurn = true;
                            //   System.out.println("aiход победа" + (i+1)+(j+1));}
                       }
                        GameLogik.map [i][j]=GameLogik.DOT_EMPTY;
                     }
                    if (GameLogik.BestTurn) break;   }

                if (GameLogik.BestTurn) break;  }


           if (!GameLogik.BestTurn) {
                for (int i = 0; i < fieldSizeX; i++) { //подбор хода искусственным интеллектом для целей блокировки...
                   for (int j = 0; j < fieldSizeX; j++) {// если нет хода для победы
                       if (GameLogik.map[i][j] == GameLogik.DOT_EMPTY) {
                           GameLogik.map[i][j] = GameLogik.DOT_X;
                           if (GameLogik.checkWin(GameLogik.DOT_X)) {
                               GameLogik.ai_X = j;
                               GameLogik.ai_Y = i;
                               GameLogik.BestTurn = true;
                           }
                           //  System.out.println("aiход блокирование" + (i+1)+(j+1));}
                           GameLogik.map[i][j] = GameLogik.DOT_EMPTY;
                       }
                        if (GameLogik.BestTurn) break;
                    }
                   if (GameLogik.BestTurn) break;
                }
            }
             if (!GameLogik.BestTurn) {
                for (int i = 0; i < fieldSizeX; i++) { //подбор хода искусственным интеллектом для целей победы
                    for (int j = 0; j < fieldSizeX; j++) {// через 2 хода
                        if (GameLogik.map[i][j] == GameLogik.DOT_EMPTY) {
                           GameLogik.map[i][j] = GameLogik.DOT_O;
                            for (int k = 0; k < fieldSizeX; k++) {
                               for (int m = 0; m < fieldSizeX; m++) {
                                    if (GameLogik.map[k][m] == GameLogik.DOT_EMPTY) {
                                      GameLogik.map[k][m] = GameLogik.DOT_O;
                                       if (GameLogik.checkWin(GameLogik.DOT_O)) {
                                           GameLogik.ai_X = j;
                                           GameLogik.ai_Y = i;
                                           GameLogik.BestTurn = true;
                                          // System.out.println("aiход по алгоритму на два хода вперед " + (i + 1) + (j + 1));
                                        }
                                       GameLogik.map[k][m] = GameLogik.DOT_EMPTY;
                                  }
                                   if (GameLogik.BestTurn) break; }
                               if (GameLogik.BestTurn) break;
                          }
                           GameLogik.map[i][j] = GameLogik.DOT_EMPTY;}
                      if (GameLogik.BestTurn) break;}
                   if (GameLogik.BestTurn) break; }
           }
         GameLogik.aiTurn();
           GameLogik.BestTurn=false;


        if (GameLogik.checkWin(GameLogik.DOT_O)) {
            System.out.println("Победил Искуственный Интеллект");}


       // GameLogik.printMap();

        repaint();
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.println(mode + " " + fieldSizeX + " " + fieldSizeY + " " + winLength);

        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        field = new int[fieldSizeY][fieldSizeX];

        isInit = true;
        GameLogik.SIZE=fieldSizeX;
        GameLogik.DOTS_TO_WIN=winLength;
        GameLogik.initMap();
     //   System.out.println("инициализация поля");

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
      //  GameLogik.printMap();
        //    GameLogik.humanTurn();

        //  g.drawOval((2 + XField * (panelWidth / fieldSizeX)), (2 + YField * (panelHeight / fieldSizeY)), cellWidth - 4, cellHeight - 4);
      //  GameLogik.map[YField][XField] = GameLogik.DOT_X;




        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                //   if (GameLogik.map[i][j] == GameLogik.DOT_O) {
                //       g.drawOval((2 + j * (panelWidth / fieldSizeX)), (2 + i * (panelHeight / fieldSizeY)), cellWidth - 4, cellHeight - 4);
                //  }
                if (GameLogik.map[i][j] == GameLogik.DOT_X) {
                    g.drawLine(2 + j * (panelWidth / fieldSizeX), ((i+1) * (panelHeight / fieldSizeY)-4), ((j * (panelWidth / fieldSizeX))+((panelWidth / fieldSizeX)-4)),((i* (panelHeight / fieldSizeX))+4));
                    g.drawLine(2 + j * (panelWidth / fieldSizeX), 2 + i * (panelHeight / fieldSizeY), ((j * (panelWidth / fieldSizeX))+((panelWidth / fieldSizeX)-4)),((i* (panelHeight / fieldSizeX))+((panelWidth / fieldSizeX)-4)));
                }

            }
        }
      //  GameLogik.aiTurn();
        GameLogik.printMap();
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (GameLogik.map[i][j] == GameLogik.DOT_O) {
                    g.drawOval((2 + j * (panelWidth / fieldSizeX)), (2 + i * (panelHeight / fieldSizeY)), cellWidth - 4, cellHeight - 4);
                    //if (GameLogik.map[i][j] == GameLogik.DOT_X) {
                    //       g.drawOval((2 + j * (panelWidth / fieldSizeX)), (2 + i * (panelHeight / fieldSizeY)), cellWidth - 54, cellHeight - 54);
                    //    }

                }


            }
        }
    }
}