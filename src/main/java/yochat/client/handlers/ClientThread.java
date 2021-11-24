package yochat.client.handlers;

import java.io.BufferedReader;
import java.io.PrintWriter;

import yochat.client.Client;
import yochat.client.models.Command;
import yochat.client.models.User;
import static yochat.client.ui.clientFrame.*;

public class ClientThread implements Runnable {

    BufferedReader reader;

    public ClientThread(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        String data[];
        String stream;

        try {
            while ((stream = reader.readLine()) != null) {
                data = stream.split(":");
                System.out.println("stream lu : " + stream);

                String username = data[0];
                String message = data[1];
                String command = data[2];

                if (command == Command.CONNECT) {
                    txtChat.removeAll();
                    txtChat.append(username + " vient de se connecter.\n");
                } else if (command == Command.DISCONNECT) {
                    txtChat.append(username + " vient de se déconnecter .\n");
                } else if (command == Command.SERVER_ERROR) {
                    txtChat.append("SERVEUR : " + message + "\n");
                } else if (command == Command.CHAT) {
                    txtChat.append(username + ": " + message + "\n");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
