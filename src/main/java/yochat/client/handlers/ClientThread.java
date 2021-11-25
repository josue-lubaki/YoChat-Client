package yochat.client.handlers;

import static yochat.client.ui.clientFrame.isConnected;
import static yochat.client.ui.clientFrame.txtChat;
import static yochat.client.ui.clientFrame.updateComponentContextConnect;
import static yochat.client.ui.clientFrame.updateComponentContextDisconnect;
import static yochat.client.ui.clientFrame.updateDashBoard;

import java.io.BufferedReader;

import javax.swing.JOptionPane;

import yochat.client.models.Paquet;
import yochat.client.models.User;
import yochat.client.utility.Command;

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
                    updateDashBoard("SERVEUR", "Tu es à présent connecter.");
                    updateComponentContextConnect();
                    JOptionPane.showMessageDialog(null, "Bienvenue " + myUsername, "SUCCESS",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case Command.DISCONNECT:
                    updateDashBoard("SERVEUR", "Tu es à présent déconnecter.");
                    updateComponentContextDisconnect();
                    break;

                case Command.CHAT:
                    username = username.equals(myUsername) ? "Moi" : username;
                    updateDashBoard(username, message);
                    break;

                case Command.SERVER_ERROR:
                    updateDashBoard(username, message);
                    isConnected = false;
                    updateComponentContextDisconnect();
                    return;

                case Command.LIST:
                    // split the list of users
                    String[] partMessage = message.split(":");
                    // split partMessage
                    String[] users = partMessage[1].trim().split(" ");

                    txtChat.append(username + " : " + partMessage[0] + "\n");
                    for (String user : users) {
                        txtChat.append("     " + user + "\n");
                    }

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
