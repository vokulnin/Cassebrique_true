package com.example.vokulnin.cassebrique;

/**
 * Created by vokulnin on 28/03/2018.
 */

public class BrickGenerator {

    public Game main;
    public int Line_size;
    public int colone_size;
    public float width = 1000;
    public float height = 250;

    public BrickGenerator(Game Main , int X , int Y) {
        main = Main;
        Line_size = X;
        colone_size = Y;
        width = main.width;
        height = main.height * 0.4f;
    }
    public void setLevel (int X , int Y){
        Line_size =X;
        colone_size = Y;
    }

    public void Generate(){
        for(int i =0;i<Line_size;i++){
            for(int j =0;j<colone_size;j++){
                main.bricks.add(new Brick(main ,   (int)(width/Line_size)*i , (int)(height/colone_size)*j , (int)(width/Line_size), (int)(height/colone_size)));
                main.gamestate.Brick_left +=1;
            }
        }
    }

}
