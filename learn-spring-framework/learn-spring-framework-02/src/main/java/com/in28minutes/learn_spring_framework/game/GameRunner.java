package com.in28minutes.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
//    GameRunner class Tightly Coupled with MarioGame or SuperContra Game
//    private MarioGame game;
//    private SuperContraGame game;
//
//    public GameRunner(MarioGame marioGame) {
//        this.game = marioGame;
//    }
//
//    public GameRunner(SuperContraGame contraGame){
//        this.game = contraGame;
//    }

//    Loosely Coupled using Interface
    private GamingConsole game;

    //Constructor based injection
    //@Qualifier("pacmanGame") -> another way of using qualifier
    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.right();
        game.left();
    }
}
