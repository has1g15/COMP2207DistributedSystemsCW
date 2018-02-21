import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Hannah on 13/12/2016.
 */
public class UserInputSource extends NotificationSource {

    ArrayList<UserInput> userInputs;

    public UserInputSource() throws InterruptedException, RemoteException, NotBoundException
    {
        super();
        System.out.print("Creating user");
        Thread.sleep(1000);
        System.out.print(" -");
        Thread.sleep(1000);
        System.out.print("-");
        Thread.sleep(1000);
        System.out.print(">");
        System.out.println();
        userInputs = new ArrayList<>();
        while(true)
        {
            try
            {
                UserInput userInput = new UserInput();
                userInputs.add(userInput);
                sendNotification(userInput.getMessage());
            } catch (RemoteException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendNotification(String message) throws RemoteException
    {
        super.sendNotification(message);
    }
}

