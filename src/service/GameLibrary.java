package service;

import model.Game;
import model.GameCategory;

public interface GameLibrary {
    void addGame(Game game);

    void deleteGame(String gameName, GameCategory category);

    Game searchGame(String gameName, GameCategory category);

    void displayAllGames();
}