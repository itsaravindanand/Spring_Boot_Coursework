package com.in28minutes.learn_spring_framework.game;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import com.in28minutes.learn_spring_framework.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GamingConfiguration {

    //creation of the Pacman Game Object of type GamingConsole
    @Bean
    public GamingConsole pacmanGame() {
        var pacmanGame = new PacmanGame();
        return pacmanGame;
    }

    //Creating a object for the GameRunner with the GamingConsole object created with the pacmanGame() bean method
    @Bean
    @Primary
    public GameRunner createGameRunnerAsBeanMethodCall() {
        var gameRunner = new GameRunner(pacmanGame());
        return gameRunner;
    }

    //Creating an object for the GameRunner by auto-wiring the GamingConsole object created in pacmanGame() bean method
    @Bean
    public GameRunner createGameRunnerAsParameter(GamingConsole pacmanGam) {
        var gameRunner = new GameRunner(pacmanGam);
        return gameRunner;
    }
}
