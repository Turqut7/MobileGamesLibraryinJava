package service.impl;

import model.Game;
import model.GameCategory;
import service.GameLibrary;

public class MobileGamesLibraryImpl implements GameLibrary {
    private Game[][] games;
    private int[] counts;

    public MobileGamesLibraryImpl(int capacityPerCategory) {
        games = new Game[GameCategory.values().length][capacityPerCategory];
        counts = new int[GameCategory.values().length];
    }

    @Override
    public void addGame(Game game) {
        int categoryIndex = game.getCategory().ordinal();
        if (counts[categoryIndex] < games[categoryIndex].length) {
            games[categoryIndex][counts[categoryIndex]] = game;
            counts[categoryIndex]++;
            System.out.println("Model.Game added successfully.");
        } else {
            System.out.println("Library is full for the category " + game.getCategory() + ". Cannot add more games.");
        }
    }

    @Override
    public void deleteGame(String gameName, GameCategory category) {
        int categoryIndex = category.ordinal();
        for (int i = 0; i < counts[categoryIndex]; i++) {
            if (games[categoryIndex][i].getName().equalsIgnoreCase(gameName)) {
                for (int j = i; j < counts[categoryIndex] - 1; j++) {
                    games[categoryIndex][j] = games[categoryIndex][j + 1];
                }
                games[categoryIndex][counts[categoryIndex] - 1] = null;
                counts[categoryIndex]--;
                System.out.println("Model.Game deleted successfully.");
                return;
            }
        }
        System.out.println("Model.Game not found.");
    }

    @Override
    public Game searchGame(String gameName, GameCategory category) {
        int categoryIndex = category.ordinal();
        for (int i = 0; i < counts[categoryIndex]; i++) {
            if (games[categoryIndex][i].getName().equalsIgnoreCase(gameName)) {
                return games[categoryIndex][i];
            }
        }
        return null;
    }

    @Override
    public void displayAllGames() {
        boolean isEmpty = true;
        for (GameCategory category : GameCategory.values()) {
            int categoryIndex = category.ordinal();
            if (counts[categoryIndex] > 0) {
                System.out.println("Category: " + category);
                for (int i = 0; i < counts[categoryIndex]; i++) {
                    System.out.println(games[categoryIndex][i]);
                }
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("No games available.");
        }
    }
}