import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Hannah on 08/12/2016.
 */
public class NotificationSink implements Notifiable {

    Notification notification;

    public static void main (String[] args) throws RemoteException, AlreadyBoundException
    {
        LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        new NotificationSink("reg");
    }

    public NotificationSink(String name) throws RemoteException, AlreadyBoundException
    {
        Registry registry = LocateRegistry.getRegistry();
        registry.bind(name, UnicastRemoteObject.exportObject(this,0));
    }

    public void receiveNotification(Notification notification)
    {
        this.notification = notification;
        System.out.println("Notification received");
        System.out.println("Message: " + notification.getMessage());
        System.out.println("Time Received: " + notification.getTime());
    }
}
