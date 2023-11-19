package hw_seminar2.server;

import hw_seminar2.server.client.ui.ClientGUI;
import hw_seminar2.server.server.domain.Server;
import hw_seminar2.server.server.ui.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
