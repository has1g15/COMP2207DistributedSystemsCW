/**
 * Created by Hannah on 11/12/2016.
 */
import java.util.Scanner;

public class UserInput {

    String message;

    public UserInput()
    {
        System.out.println("What message would you like to send?");
        Scanner input = new Scanner(System.in);
        message = input.nextLine();
    }

    public String getMessage()
    {
        return message;
    }
}
