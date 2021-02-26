package core.gamestates;
import java.util.TimerTask;
import java.util.Timer;
/**
 * klasa odpowiadajaca za sekundnik w naszje grze
 */
public class Time {


    public int secondsPassed = 0;

    Timer myTimer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsPassed++;
        }
    };

    public void start() {
        myTimer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }

}
