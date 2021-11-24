package yochat.client.handlers;

import static yochat.client.ui.clientFrame.txtChat;

import java.io.BufferedReader;

import yochat.client.models.Command;
import static yochat.client.ui.clientFrame.*;

public class ClientThread implements Runnable {

    private BufferedReader reader;

    // constructor
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

                if (command.equalsIgnoreCase(Command.CONNECT)) {
                    txtChat.setText("");
                    txtChat.append(username + " vient de se connecter.\n");
                    txtChat.setCaretPosition(txtChat.getDocument().getLength());
                    btnConnect.setEnabled(false);
                    btnDisconnect.setEnabled(true);
                    tfUsername.setEnabled(false);
                    tfAddress.setEnabled(false);
                    tfPort.setEnabled(false);
                    btnClear.setEnabled(true);
                    btnSend.setEnabled(true);
                    txtMessage.setEnabled(true);
                } else if (command.equalsIgnoreCase(Command.DISCONNECT)) {
                    txtChat.append(username + " vient de se déconnecter .\n");
                    txtChat.setCaretPosition(txtChat.getDocument().getLength());
                    tfAddress.setEditable(true);
                    tfPort.setEditable(true);
                    tfUsername.setEditable(true);
                    btnConnect.setEnabled(true);
                    btnDisconnect.setEnabled(false);
                    btnSend.setEnabled(false);
                    btnClear.setEnabled(false);
                    txtMessage.setEditable(false);
                    tfUsername.requestFocus();
                } else if (command.equalsIgnoreCase(Command.SERVER_ERROR)) {
                    txtChat.append(username + message + "\n");
                    txtChat.setCaretPosition(txtChat.getDocument().getLength());
                    isConnected = false;
                } else if (command.equalsIgnoreCase(Command.CHAT)) {
                    txtChat.append(username + ": " + message + "\n");
                    txtChat.setCaretPosition(txtChat.getDocument().getLength());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
