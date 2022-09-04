import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("Running Tests ...");
        Result result = JUnitCore.runClasses(CardTest.class, DeckTest.class, PlayerTest.class, PokerOpsTest.class, RankingTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Tests ran: " + result.getRunCount() +"\nFailed: " +result.getFailureCount());
    }
    
}