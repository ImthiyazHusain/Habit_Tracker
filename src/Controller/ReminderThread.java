package Controller;

public class ReminderThread extends Thread {

    private final String habitName;
    private final int seconds;

    public ReminderThread(String habitName, int seconds) {
        this.habitName = habitName;
        this.seconds = seconds;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(seconds * 1000);
            System.out.println("\n⏰ Reminder: Do your habit -> " + habitName);
        } catch (InterruptedException e) {
            System.out.println("Reminder interrupted");
        }
    }
}