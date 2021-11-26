/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.*;

import client.handlers.ClientThread;
import client.models.Paquet;
import client.models.User;
import client.utility.Command;

/**
 *
 * @author coulibai
 */
public class clientFrame extends javax.swing.JFrame {

        public static Boolean isConnected = false;
        private Socket socketClient;
        private PrintWriter printWriterClient;
        public static BufferedReader bufferedReader;
        public static Paquet paquetToSendServer;
        public static User userCurrent;
        public static String userCurrentUsername;
        public static String userCurrentAddress;
        public static int userCurrentPort;
        private final String txtMessageDescription = "Écris ton message ici...";

        /**
         * Creates new form clientFrame
         */
        public clientFrame() {
                initComponents();
        }

        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDesktopPane jDesktopPane = new JDesktopPane();
        tfUsername = new javax.swing.JTextField();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        JLabel lblClient = new JLabel();
        btnConnect = new javax.swing.JButton();
        tfAddress = new javax.swing.JTextField();
        btnDisconnect = new javax.swing.JButton();
        tfPort = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        JScrollPane jScrollPaneMessage = new JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        JScrollPane jScrollPane = new JScrollPane();
        txtChat = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane.setBackground(new java.awt.Color(101, 132, 148));

        tfUsername.setFont(new java.awt.Font("Dialog", Font.BOLD, 12)); // NOI18N
        tfUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfUsername.setText("Username");
        tfUsername.setToolTipText("Enter your username");
        tfUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfUsernameFocusGained();
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                tfUsernameFocusLost();
            }
        });

        lblClient.setFont(new java.awt.Font("Dialog", Font.BOLD, 18)); // NOI18N
        lblClient.setForeground(new java.awt.Color(255, 255, 255));
        lblClient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClient.setText("CLIENT");
        lblClient.setToolTipText("");
        lblClient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblClient.setInheritsPopupMenu(false);

        btnConnect.setBackground(new java.awt.Color(0, 102, 51));
        btnConnect.setFont(new java.awt.Font("Dialog", Font.BOLD, 12)); // NOI18N
        btnConnect.setText("Connect");
        btnConnect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConnect.addActionListener(this::btnConnectActionPerformed);

        tfAddress.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11)); // NOI18N
        tfAddress.setText("localhost");
        tfAddress.setToolTipText("Entrer localhost ou IP Addresse");
        tfAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfAddressFocusGained();
            }

            public void focusLost(java.awt.event.FocusEvent evt){
                tfAddressFocusLost();
            }
        });

        btnDisconnect.setFont(new java.awt.Font("Dialog", Font.BOLD, 12)); // NOI18N
        btnDisconnect.setText("Disconnect");
        btnDisconnect.setEnabled(false);
        btnDisconnect.addActionListener(this::btnDisconnectActionPerformed);

        tfPort.setFont(new java.awt.Font("Dialog", Font.BOLD, 12)); // NOI18N
        tfPort.setText("5000");
        tfPort.setEditable(true);
        tfPort.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                tfPortFocusGained();
            }

            public void focusLost(java.awt.event.FocusEvent evt){
                tfPortFocusLost();
            }
        });

        btnClear.setFont(new java.awt.Font("Dialog", Font.BOLD, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);

        jDesktopPane.setLayer(tfUsername, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(lblClient, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(btnConnect, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(tfAddress, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(btnDisconnect, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(tfPort, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(btnClear, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane8Layout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPane8Layout);
        jDesktopPane8Layout.setHorizontalGroup(
            jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane8Layout.createSequentialGroup()
                        .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfUsername)
                            .addComponent(tfAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(tfPort, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDisconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClient, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );
        jDesktopPane8Layout.setVerticalGroup(
            jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane8Layout.createSequentialGroup()
                .addComponent(lblClient, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane8Layout.createSequentialGroup()
                        .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(jDesktopPane8Layout.createSequentialGroup()
                        .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDisconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfAddress)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPort))))
                .addContainerGap())
        );

        txtMessage.setColumns(20);
        txtMessage.setRows(5);
        txtMessage.setEnabled(false);
        txtMessage.setText(txtMessageDescription);
        jScrollPaneMessage.setViewportView(txtMessage);
        jScrollPaneMessage.getViewport().getView().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtMessageFocusGained();
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtMessageFocusLost();
            }
        });


        btnSend.setBackground(new java.awt.Color(0, 102, 51));
        btnSend.setFont(new java.awt.Font("Dialog", Font.BOLD, 12)); // NOI18N
        btnSend.setText("Send");
        btnSend.setEnabled(false);
        btnSend.addActionListener(this::btnSendActionPerformed);

        txtChat.setEditable(false);
        txtChat.setBackground(new java.awt.Color(102, 102, 102));
        txtChat.setColumns(20);
        txtChat.setFont(new java.awt.Font("Dialog", Font.BOLD, 12)); // NOI18N
        txtChat.setForeground(new java.awt.Color(255, 255, 255));
        txtChat.setRows(5);
        txtChat.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane.setViewportView(txtChat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        /**
         * Methode qui permet de supprimer le message dans le textarea
         */
        protected void btnClearActionPerformed(ActionEvent evt) {
                txtChat.removeAll();
                txtChat.setText("");
        }

        protected void btnSendActionPerformed(ActionEvent evt) {
                try {
                        String message = txtMessage.getText();
                        if (message.isBlank()) {
                                JOptionPane.showMessageDialog(null, "Veuillez entrer un message", "Erreur",
                                                JOptionPane.ERROR_MESSAGE);
                        } else if (message.equals(Command.LIST)) {
                                // configuer le paquet demandand la liste des users connectés au serveur
                                paquetToSendServer.setCommand(Command.LIST);
                                paquetToSendServer.setMessage(message);
                                paquetToSendServer.setUser(userCurrent);

                                // envoyer le paquet au serveur
                                printWriterClient.println(paquetToSendServer.toString());
                        } else {
                                // Configurer le paquet à envoyer
                                paquetToSendServer.setMessage(message);
                                paquetToSendServer.setCommand(Command.CHAT);

                                // Envoyer le paquet
                                printWriterClient.println(paquetToSendServer);
                                txtMessage.setText("");
                                txtMessage.requestFocus();
                        }

                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }

        protected void btnDisconnectActionPerformed(ActionEvent evt) {

                // fermer le socket du client
                try {
                        // Envoyer message au serveur pour le signaler la deconnexion
                        // Configurer le paquet à envoyer
                        paquetToSendServer.setMessage("déconnecte-moi");
                        paquetToSendServer.setCommand(Command.DISCONNECT);
                        printWriterClient.println(paquetToSendServer);

                        // Informer à l'utilisateur qu'il vient d'être déconnecté
                        isConnected = false;

                        // txtChat.append("Déconnexion réussi ! Bye " + userCurrentUsername + "\n");
                        updateComponentContextDisconnect();

                        // Fermer le socket
                        Thread.sleep(1000);
                        socketClient.close();
                } catch (

                IOException ex) {
                        txtChat.append("Error while disconnecting from the server.\n");
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }

        }

        protected void btnConnectActionPerformed(ActionEvent evt) {
                try {
                        // Vérification des champs
                        if (!isPossibleToConnect())
                                return;

                        // Récupérer les informations de l'utilisateur
                        try {
                                bindInfoUser();
                        } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Veuillez entrer un numéro de port valide",
                                                "Erreur", JOptionPane.ERROR_MESSAGE);
                                e.printStackTrace();
                                return;
                        }

                        // Créer le socket client
                        socketClient = connectUserToSocket();
                        isConnected = true;

                        // Créer le Thread pour rester en écoute sur le socket
                        Thread thread = new Thread(new ClientThread(bufferedReader));
                        thread.start();

                        updateComponentContextConnect();

                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,
                                        "Connexion non établie avec le serveur \"" + userCurrentAddress + "\"",
                                        "Erreur", JOptionPane.ERROR_MESSAGE);
                }
        }

        /**
         * Methode qui permet de créer le socket client
         * 
         * @return socketClient
         */
        private Socket connectUserToSocket() throws IOException {
                InetAddress inet = InetAddress.getByName(userCurrentAddress);
                socketClient = new Socket(inet, userCurrentPort);
                InputStreamReader isr = new InputStreamReader(socketClient.getInputStream());
                printWriterClient = new PrintWriter(socketClient.getOutputStream(), true);
                bufferedReader = new BufferedReader(isr);

                paquetToSendServer = new Paquet(userCurrent, "connecte-moi", Command.CONNECT);
                printWriterClient.println(paquetToSendServer);

                return socketClient;
        }

        /**
         * Methode qui permet de récupèrer (bind) les informations de l'utilisateur
         */
        private void bindInfoUser() {
                userCurrent = new User(tfUsername.getText().trim());
                userCurrentUsername = userCurrent.getUsername();
                userCurrentAddress = tfAddress.getText().trim();
                userCurrentPort = Integer.parseInt(tfPort.getText().trim());
        }

        /**
         * Methode qui permet de verifier si l'utilisateur peut se connecter
         */
        private boolean isPossibleToConnect() {
                // Vérifier si l'utilisateur est déjà connecté
                if (isConnected) {
                        JOptionPane.showMessageDialog(null, "Vous êtes déjà connecté au serveur", "INFO",
                                        JOptionPane.INFORMATION_MESSAGE);
                        return false;
                }

                // Vérifier si l'utilisateur a entré son Username
                if (tfUsername.getText().equals("Username") || tfUsername.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Entrer votre username", "Erreur",
                                        JOptionPane.ERROR_MESSAGE);
                        return false;
                }

                return true;
        }

        protected void tfUsernameFocusLost() {
                String str = tfUsername.getText().isBlank() ? "Username" : tfUsername.getText();
                tfUsername.setText(str);
        }

        protected void tfPortFocusLost() {
                String str = tfPort.getText().isBlank() ? "5000" : tfPort.getText();
                tfPort.setText(str);
        }

        protected void tfAddressFocusLost() {
                String str = tfAddress.getText().isBlank() ? "localhost" : tfAddress.getText();
                tfAddress.setText(str);
        }

        protected void tfUsernameFocusGained() {
                String str = tfUsername.getText().equals("Username") ? "" : tfUsername.getText();
                tfUsername.setText(str);
        }

        protected void tfAddressFocusGained() {
                String str = tfAddress.getText().equals("localhost") ? "" : tfAddress.getText();
                tfAddress.setText(str);
        }

        protected void tfPortFocusGained() {
                String str = tfPort.getText().equals("5000") ? "" : tfPort.getText();
                tfPort.setText(str);
        }

        protected void txtMessageFocusGained() {
                if (isConnected) {
                        String str = txtMessage.getText().equals(txtMessageDescription) ? "" : txtMessage.getText();
                        txtMessage.setText(str);
                }

        }

        protected void txtMessageFocusLost() {
                String str = txtMessage.getText().isBlank() ? txtMessageDescription : txtMessage.getText();
                txtMessage.setText(str);
        }

        /**
         * Methode qui permet d'écrire sur la console du client le message reçu du
         * serveur
         */
        public static void updateDashBoard(String username, String message) {
                txtChat.append(username + ": " + message + "\n");
                txtChat.setCaretPosition(txtChat.getDocument().getLength());
        }

        /**
         * Mettre à jour les composants de la fenêtre client dans le contexte de la
         * connexion
         */
        public static void updateComponentContextConnect() {
                btnConnect.setEnabled(false);
                btnConnect.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                btnDisconnect.setEnabled(true);
                btnDisconnect.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnClear.setEnabled(true);
                btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
                tfUsername.setEnabled(false);
                tfAddress.setEnabled(false);
                tfPort.setEnabled(false);
                btnSend.setEnabled(true);
                btnSend.setCursor(new Cursor(Cursor.HAND_CURSOR));
                txtMessage.setEnabled(true);
        }

        /**
         * Mettre à jour les composants de la fenêtre client dans le contexte de la
         * déconnexion
         */
        public static void updateComponentContextDisconnect() {
                btnDisconnect.setEnabled(false);
                btnDisconnect.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                tfUsername.setEnabled(true);
                tfAddress.setEnabled(true);
                tfPort.setEnabled(true);
                btnClear.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                btnSend.setEnabled(false);
                btnSend.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                tfUsername.requestFocus();
                btnConnect.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnConnect.setEnabled(true);
                txtMessage.setEnabled(false);
        }

    public static javax.swing.JButton btnClear;
    public static javax.swing.JButton btnConnect;
    public static javax.swing.JButton btnDisconnect;
    public static javax.swing.JButton btnSend;
    public static javax.swing.JTextField tfAddress;
    public static javax.swing.JTextField tfPort;
    public static javax.swing.JTextField tfUsername;
    public static javax.swing.JTextArea txtChat;
    public static javax.swing.JTextArea txtMessage;
    // End of variables declaration//GEN-END:variables
}
