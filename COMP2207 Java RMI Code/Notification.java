import java.io.Serializable;
import java.time.Instant;

/**
 * Created by Hannah on 08/12/2016.
 */
public class Notification implements Serializable{

    private final String message;
    private final Instant time;

    public Notification(String message)
    {
        this.message = message;
        time = Instant.now();
    }

    public String getMessage()
    {
        return message;
    }

    public Instant getTime()
    {
        return time;
    }
}
