public class MainController {
    public static void main(String[] args) throws Exception {
        ConnectionHandler ch = new ConnectionHandler();
        CommandExecutor executor = new CommandExecutor();
        ch.tableCheck();
        executor.commandManager();

    }
}
