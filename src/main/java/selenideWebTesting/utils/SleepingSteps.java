package selenideWebTesting.utils;

public class SleepingSteps {

    public static void stopAction(Integer time){

        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
