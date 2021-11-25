package yochat.client.handlers;

import static yochat.client.ui.clientFrame.txtChat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import yochat.client.models.Paquet;
import yochat.client.models.User;
import yochat.client.utility.Command;
import static yochat.client.ui.clientFrame.*;

/**
 * Classe qui gère les communications avec le serveur, particulièrement écouter
 * ce dont le serveur envoie.
 * 
 * @author Josue Lubaki & Ismael Coulibaly
 * @version 1.0
 */
public class ClientThread implements Runnable {

    private BufferedReader reader = null;

    // constructor
    public ClientThread(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        String[] data;
        String stream;
        String myUsername = "";

        try {
            while ((stream = reader.readLine()) != null) {
                data = stream.split("%%");
                System.out.println("stream lu : " + stream);

                Paquet paquet = new Paquet(new User(data[0]), data[1], data[2]);
                String username = paquet.getUser().getUsername(), message = paquet.getMessage(),
                        command = paquet.getCommand();

                switch (command) {
                case Command.CONNECT:
                    txtChat.setText("");
                    myUsername = message.split(" ")[0];
                    updateDashBoard("SERVEUR", "Tu es désormais connecter.");
                    updateComponentContextConnect();

                    break;

                case Command.DISCONNECT:
                    updateDashBoard(username, "Je suis à présent déconnecter.");
                    updateComponentContextDisconnect();
                    break;

                case Command.CHAT:
                    username = username.equals(myUsername) ? "Moi" : username;
                    updateDashBoard(username, message);
                    break;

                case Command.SERVER_ERROR:
                    txtChat.append(username + message + "\n");
                    txtChat.setCaretPosition(txtChat.getDocument().getLength());
                    isConnected = false;
                    break;

                case Command.LIST:
                    // TODO : Si lea commande égale à LIST
                    break;

                default:
                    break;
                }
            }
        } catch (Exception e) {
            // updateDashBoard("Console", e.getMessage());
            e.printStackTrace();
        }
    }
}
