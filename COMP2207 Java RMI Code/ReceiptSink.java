import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

/**
 * Created by Hannah on 13/12/2016.
 */
public class ReceiptSink extends NotificationSink {

    public ReceiptSink(String name) throws RemoteException, AlreadyBoundException
    {
        super(name);
    }

    public void receiveNotification(Notification notification)
    {
        System.out.println("Notification Received");
    }
}

