public class Main {
    public static void main(String[] args){
        Player player = new Player();

        player.drawCards();
        System.out.println("Shuffling ... Shuffling ... Shuffling ...");
        System.out.print("Your hand: ");
        player.printHand();
        System.out.print("You have: ");
        player.evaluate();

    }
}
