import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandExecutor {
    ConnectionHandler handler = new ConnectionHandler();

    public void commandManager() throws Exception {
        System.out.println();
        System.out.println("Input Command");
        String input;

        int creds;
        String username;
        String uuid;
        Scanner sc = new Scanner(System.in);
        String[] responses = {"How many credits would you like to add", "How many credits would you like to deduct", "Getting Credits", "Adding Credits", "Removing Credits", "Invalid Input/Arguments","Removing Profile"};
        input = sc.nextLine();
        if (input.equals("credits add") || input.equals(" credits add") || input.equals("credits add ")) {
            System.out.println(responses[0]);
            creds = sc.nextInt();
            System.out.println("Enter uuid");
            uuid = sc.next();
            handler.AddCreds(uuid, creds);
            System.out.println();
            commandManager();
        } else
        if (input.equals("credits remove") || input.equals(" credits remove") || input.equals("credits remove ")) {
            System.out.println(responses[1]);
            creds = sc.nextInt();
            System.out.println("Enter UUID");
            uuid = sc.next();
            System.out.println("Processing Command");
            handler.RemoveCreds(uuid,creds);
            System.out.println();
            commandManager();
        } else
        if (input.equals("credits") || input.equals(" credits") || input.equals("credits ") || input.equals(" credits ")) {
            System.out.println("Enter uuid");
            uuid = sc.next();
            System.out.println(responses[2]);
            handler.ReadCreds(uuid);
            System.out.println();
            commandManager();
        } else
        if (input.equals("credits profile create") || input.equals(" credits profile create") || input.equals(" credits profile create ") || input.equals("credits profile create ")) {
            System.out.println("Enter uuid");
            uuid = sc.nextLine();
            System.out.println("Enter username");
            username = sc.next();
            System.out.println(responses[0]);
            creds = sc.nextInt();
            handler.createProfile(uuid,username,creds);
            System.out.println();
            commandManager();
        } else if (input.equals("help") || input.equalsIgnoreCase(" help") || input.equals(" help ") || input.equals("help ")){
            System.out.println("Commands List:\n- credits add\n- credits remove\n -credits profile create\n- credits profile delete");
            commandManager();

        } else if (input.equalsIgnoreCase("credits profile delete") || input.equalsIgnoreCase("credits profile delete ")||input.equalsIgnoreCase(" credits profile delete")){
            System.out.println("Enter UUID");
            uuid = sc.next();
            System.out.println("Are you sure you want to remove the profile? (y/n)");
            String choice = "";
            choice = sc.next();
            System.out.println("");
            String resp = "";
            if (choice.equalsIgnoreCase("y")) {
                handler.DropProfile(uuid);
                commandManager();
            } else {
                System.out.println("Exiting Program");
                return;
            }




        } else {
            System.out.println("Invalid Command, please try again");
            System.out.println("");
            System.out.println();
            commandManager();
        }

    }
}
