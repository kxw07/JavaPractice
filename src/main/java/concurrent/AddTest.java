package concurrent;

public class AddTest {
    public volatile int i;
    public synchronized void add() {
        i++;
    }
}

