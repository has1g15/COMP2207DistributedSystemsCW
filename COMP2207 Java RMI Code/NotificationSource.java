import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
/**
 * Created by Hannah on 08/12/2016.
 */
public class NotificationSource {

    ArrayList<NotificationSink> registeredSinks;
    private final static String NAME = "reg";
    private Registry registry;
    private Notifiable stub;

    public static void main (String[] args) throws RemoteException, NotBoundException, AlreadyBoundException, InterruptedException
    {
        new NotificationSource();
        new UserInputSource();
    }

    public NotificationSource() throws RemoteException, NotBoundException
    {
        registeredSinks = new ArrayList<>();
        registry = LocateRegistry.getRegistry();
        stub = (Notifiable) registry.lookup(NAME);
    }

    public void notify(Notification notification)
    {
        for (NotificationSink sink: registeredSinks)
        {
            sink.receiveNotification(notification);
        }
    }

    public void sendNotification(String message) throws RemoteException
    {
        stub.receiveNotification(new Notification(message));
        notify(new Notification(message));
    }

    public void registerSink(NotificationSink sink)
    {
        registeredSinks.add(sink);
    }
}
