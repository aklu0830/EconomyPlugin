import java.util.Scanner;

public class login {
    ConnectionHandler ce = new ConnectionHandler();
    Scanner scanner = new Scanner(System.in);
    public void login() throws Exception {
        String username;
        String password;
        System.out.println("Enter Username");
        username = scanner.nextLine();
        System.out.println("Enter Password");
        password = scanner.nextLine();
        ce.login(username,password);
    }
}
