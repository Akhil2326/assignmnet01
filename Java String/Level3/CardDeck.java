import java.util.Scanner;

public class CardDeck {

    // Initialize deck of cards
    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Shuffle the deck
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            // Swap cards
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    // Distribute cards to players
    public static String[][] distributeCards(String[] deck, int numCardsToDeal, int numPlayers) {
        if (numCardsToDeal > deck.length) {
            System.out.println("Error: Cannot deal more cards than deck size.");
            return null;
        }
        if (numCardsToDeal % numPlayers != 0) {
            System.out.println("Error: Cards cannot be evenly distributed to players.");
            return null;
        }

        int cardsPerPlayer = numCardsToDeal / numPlayers;
        String[][] playersCards = new String[numPlayers][cardsPerPlayer];

        int cardIndex = 0;
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (int j = 0; j < numPlayers; j++) {
                playersCards[j][i] = deck[cardIndex++];
            }
        }

        return playersCards;
    }

    // Print players and their cards
    public static void printPlayersCards(String[][] playersCards) {
        for (int i = 0; i < playersCards.length; i++) {
            System.out.println("Player " + (i + 1) + "'s cards:");
            for (String card : playersCards[i]) {
                System.out.println("  " + card);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        // Initialize and shuffle deck
        String[] deck = initializeDeck(suits, ranks);
        deck = shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int numPlayers = sc.nextInt();

        System.out.print("Enter number of cards to deal: ");
        int numCardsToDeal = sc.nextInt();

        String[][] playersCards = distributeCards(deck, numCardsToDeal, numPlayers);
        if (playersCards != null) {
            printPlayersCards(playersCards);
        }

        sc.close();
    }
}
