import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandExecutor {
    ConnectionHandler handler = new ConnectionHandler();

    public void commandManager() throws Exception {
        System.out.println("Input Command");
        String input;

        int creds;
        String username;
        String uuid;
        Scanner sc = new Scanner(System.in);
        String[] responses = {"How many credits would you like to add", "How many credits would you like to deduct", "Getting Credits", "Adding Credits", "Removing Credits", "Invalid Input/Arguments"};
        input = sc.nextLine();
        if (input.equals("credits add") || input.equals(" credits add") || input.equals("credits add ")) {
            System.out.println(responses[0]);
            creds = sc.nextInt();
            System.out.println("Enter uuid");
            uuid = sc.next();
            handler.AddCreds(uuid, creds);
        } else
        if (input.equals("credits remove") || input.equals(" credits remove") || input.equals("credits remove ")) {
            System.out.println(responses[1]);
            creds = sc.nextInt();
            System.out.println("Enter UUID");
            uuid = sc.next();
            System.out.println("Processing Command");
            handler.RemoveCreds(uuid,creds);

        } else
        if (input.equals("credits") || input.equals(" credits") || input.equals("credits ") || input.equals(" credits ")) {
            System.out.println("Enter uuid");
            uuid = sc.next();
            System.out.println(responses[2]);
            handler.ReadCreds(uuid);
        } else
        if (input.equals("credits profile create") || input.equals(" credits profile create") || input.equals(" credits profile create ") || input.equals("credits profile create ")) {
            System.out.println("Enter uuid");
            uuid = sc.nextLine();
            System.out.println("Enter username");
            username = sc.next();
            System.out.println(responses[0]);
            creds = sc.nextInt();
            handler.createProfile(uuid,username,creds);
        } else {
            System.out.println("Invalid Command, please try again");
            System.out.println("");
            commandManager();

        }
    }
}
