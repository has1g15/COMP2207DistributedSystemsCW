/**
 * Created by Hannah on 11/12/2016.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Notifiable extends Remote{

    void receiveNotification(Notification notification) throws RemoteException;
}
