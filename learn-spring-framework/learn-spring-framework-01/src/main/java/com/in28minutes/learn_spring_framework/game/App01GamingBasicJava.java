package com.in28minutes.learn_spring_framework.game;

import com.in28minutes.learn_spring_framework.game.*;

public class App01GamingBasicJava {
    public static void main(String[] args) {
//        Tight Coupling demonstration
//        Object Creation for MarioGame using var

//        Using marioGame or superContraGame needs changes in the GameRunner Class as there is no common interface
//        var gameRunner = new GameRunner(marioGame);
//        var gameRunner = new GameRunner(superContraGame);
//        var gameRunner = new GameRunner(pacmanGame);


        //Since we use var all the methods in MarioGame() can be accessed, including the interface methods
        //Instead of var, we can use GamingConsole or MarioGame, but when you use GamingConsole, only the interface method can be accessed
        var marioGame = new MarioGame();
        var superContraGame = new SuperContraGame();
        var pacmanGame = new PacmanGame();


//        this is after the implementation of interface
//        No need to change the Objects in GameRunner class as we used interface there
//        Just change the object passed into the GameRunner Constructor to execute the respective implementation
        var gameRunner = new GameRunner(marioGame); //Object Creation + Wiring the dependency object of any type of game
        gameRunner.run();
    }
}
