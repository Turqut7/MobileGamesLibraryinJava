import model.Game;
import model.GameCategory;
import service.impl.MobileGamesLibraryImpl;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MobileGamesLibraryImpl library = new MobileGamesLibraryImpl(100); // Her category ucun fixed 100 game ola biler
        System.out.println("                                                    ***** Welcome to Mobile Games Library *****");
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a new game");
            System.out.println("2. Delete a game");
            System.out.println("3. Search for a game");
            System.out.println("4. Display all games");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter game category (Simulation, Sport, Horror, Story, Casual):");
                    String categoryInput = scanner.nextLine().toUpperCase();
                    GameCategory category;
                    try {
                        category = GameCategory.valueOf(categoryInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid category.");
                        break;
                    }

                    System.out.println("Enter game name:");
                    String name = scanner.nextLine();

                    System.out.println("Enter game size (in MB):");
                    double size = scanner.nextDouble();
                    scanner.nextLine();

                    Game game = new Game(name, category, size);
                    library.addGame(game);
                    break;

                case 2:
                    System.out.println("Enter game category (Simulation, Sport, Horror, Story, Casual):");
                    categoryInput = scanner.nextLine().toUpperCase();
                    try {
                        category = GameCategory.valueOf(categoryInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid category.");
                        break;
                    }

                    System.out.println("Enter game name to delete:");
                    String deleteName = scanner.nextLine();
                    library.deleteGame(deleteName, category);
                    break;

                case 3:
                    System.out.println("Enter game category (Simulation, Sport, Horror, Story, Casual):");
                    categoryInput = scanner.nextLine().toUpperCase();
                    try {
                        category = GameCategory.valueOf(categoryInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid category.");
                        break;
                    }

                    System.out.println("Enter game name to search:");
                    String searchName = scanner.nextLine();
                    Game foundGame = library.searchGame(searchName, category);
                    if (foundGame != null) {
                        System.out.println("Model.Game found: " + foundGame);
                    } else {
                        System.out.println("Model.Game not found in this category.");
                    }
                    break;

                case 4:
                    library.displayAllGames();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
