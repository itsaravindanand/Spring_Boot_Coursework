package com.in28minutes.learn_spring_framework.game;

public class SuperContraGame implements GamingConsole {
    public void up() {
        System.out.println("Go Up");
    }

    public void down() {
        System.out.println("Sit Down");
    }

    public void left() {
        System.out.println("Go Back");
    }

    public void right() {
        System.out.println("Shoot Bullet");
    }
}
