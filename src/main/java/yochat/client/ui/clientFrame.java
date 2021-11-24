/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yochat.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

import yochat.client.handlers.ClientThread;
import yochat.client.models.Command;
import yochat.client.models.Paquet;
import yochat.client.models.User;

/**
 *
 * @author coulibai
 */
public class clientFrame extends javax.swing.JFrame {

        public static Boolean isConnected = false;
        private Socket socketClient;
        private PrintWriter printWriterClient;
        public static BufferedReader bufferedReader;

        /**
         * Creates new form clientFrame
         */
        public clientFrame() {
                initComponents();
        }

        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jDesktopPane = new javax.swing.JDesktopPane();
                tfUsername = new javax.swing.JTextField();
                LblClient = new javax.swing.JLabel();
                btnConnect = new javax.swing.JButton();
                tfAddress = new javax.swing.JTextField();
                btnDisconnect = new javax.swing.JButton();
                tfPort = new javax.swing.JTextField();
                btnClear = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                txtMessage = new javax.swing.JTextArea();
                btnSend = new javax.swing.JButton();
                jScrollPane1 = new javax.swing.JScrollPane();
                txtChat = new javax.swing.JTextArea();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jDesktopPane.setBackground(new java.awt.Color(101, 132, 148));

                tfUsername.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                tfUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);
                tfUsername.setText("Username");
                tfUsername.setToolTipText("Enter your username");
                tfUsername.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                tfUsername7FocusGained(evt);
                        }
                });
                // perte de focus
                tfUsername.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusLost(java.awt.event.FocusEvent evt) {
                                tfUsernameFocusLost(evt);
                        }
                });

                LblClient.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
                LblClient.setForeground(new java.awt.Color(255, 255, 255));
                LblClient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                LblClient.setText("CLIENT");
                LblClient.setToolTipText("");
                LblClient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                LblClient.setInheritsPopupMenu(false);

                btnConnect.setBackground(new java.awt.Color(0, 102, 51));
                btnConnect.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                btnConnect.setText("Connect");
                btnConnect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                btnConnect.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnConnectActionPerformed(evt);
                        }
                });

                tfAddress.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                tfAddress.setText("localhost");
                tfAddress.setToolTipText("Entrer localhost ou IP Addresse");
                tfAddress.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                tfAddress7FocusGained(evt);
                        }
                });
                // perte de focus
                tfAddress.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusLost(java.awt.event.FocusEvent evt) {
                                tfAddressFocusLost(evt);
                        }
                });

                btnDisconnect.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                btnDisconnect.setText("Disconnect");
                btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnDisconnectActionPerformed(evt);
                        }
                });

                tfPort.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                tfPort.setText("5000");
                tfPort.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                tfPortFocusGained(evt);
                        }
                });

                // perte de focus
                tfPort.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusLost(java.awt.event.FocusEvent evt) {
                                tfPortFocusLost(evt);
                        }
                });

                btnClear.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                btnClear.setText("Clear");
                btnClear.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnClearActionPerformed(evt);
                        }
                });

                jDesktopPane.setLayer(tfUsername, javax.swing.JLayeredPane.DEFAULT_LAYER);
                jDesktopPane.setLayer(LblClient, javax.swing.JLayeredPane.DEFAULT_LAYER);
                jDesktopPane.setLayer(btnConnect, javax.swing.JLayeredPane.DEFAULT_LAYER);
                jDesktopPane.setLayer(tfAddress, javax.swing.JLayeredPane.DEFAULT_LAYER);
                jDesktopPane.setLayer(btnDisconnect, javax.swing.JLayeredPane.DEFAULT_LAYER);
                jDesktopPane.setLayer(tfPort, javax.swing.JLayeredPane.DEFAULT_LAYER);
                jDesktopPane.setLayer(btnClear, javax.swing.JLayeredPane.DEFAULT_LAYER);

                javax.swing.GroupLayout jDesktopPane8Layout = new javax.swing.GroupLayout(jDesktopPane);
                jDesktopPane.setLayout(jDesktopPane8Layout);
                jDesktopPane8Layout.setHorizontalGroup(jDesktopPane8Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jDesktopPane8Layout.createSequentialGroup().addContainerGap()
                                                .addGroup(jDesktopPane8Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(jDesktopPane8Layout.createSequentialGroup()
                                                                                .addGroup(jDesktopPane8Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(tfUsername)
                                                                                                .addComponent(tfAddress,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                152,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(tfPort,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                70,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                77, Short.MAX_VALUE)
                                                                                .addComponent(btnClear,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                77,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btnDisconnect,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                112,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jDesktopPane8Layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(btnConnect,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                112,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane8Layout
                                                .createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(LblClient, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(206, 206, 206)));
                jDesktopPane8Layout.setVerticalGroup(jDesktopPane8Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jDesktopPane8Layout.createSequentialGroup()
                                                .addComponent(LblClient, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jDesktopPane8Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(jDesktopPane8Layout.createSequentialGroup()
                                                                                .addComponent(btnConnect,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                33,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(40, 40, 40))
                                                                .addGroup(jDesktopPane8Layout.createSequentialGroup()
                                                                                .addComponent(tfUsername,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                32,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(jDesktopPane8Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(btnDisconnect,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                29,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(tfAddress)
                                                                                                .addComponent(btnClear,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                31,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(tfPort))))
                                                .addContainerGap()));

                txtMessage.setColumns(20);
                txtMessage.setRows(5);
                jScrollPane2.setViewportView(txtMessage);

                btnSend.setBackground(new java.awt.Color(0, 102, 51));
                btnSend.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                btnSend.setText("Send");
                btnSend.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSendActionPerformed(evt);
                        }
                });

                txtChat.setEditable(false);
                txtChat.setBackground(new java.awt.Color(102, 102, 102));
                txtChat.setColumns(20);
                txtChat.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                txtChat.setForeground(new java.awt.Color(255, 255, 255));
                txtChat.setRows(5);
                txtChat.setMargin(new java.awt.Insets(5, 5, 5, 5));
                jScrollPane1.setViewportView(txtChat);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDesktopPane)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jScrollPane1)
                                                                .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jScrollPane2)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(btnSend,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                65,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap()));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(btnSend,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                48,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap()));
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
                        if (message.length() > 0) {
                                String username = tfUsername.getText();
                                if (username.length() > 0) {
                                        String msg = username + ":" + message + ":" + Command.CHAT;
                                        printWriterClient.println(msg);
                                        printWriterClient.flush();
                                        txtMessage.setText("");
                                        txtMessage.requestFocus();
                                } else {
                                        JOptionPane.showMessageDialog(null, "Please enter username, address and port");
                                }
                        }
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }

        protected void btnDisconnectActionPerformed(ActionEvent evt) {

                // fermer le socket du client
                try {
                        // Envoyer message au serveur pour le signaler la deconnexion
                        String msg = tfUsername.getText() + ":deconnecte-moi:" + Command.DISCONNECT;
                        printWriterClient.println(msg);
                        printWriterClient.flush();

                        // Fermer le socket
                        socketClient.close();
                        // Informer à l'utilisateur qu'il vient d'être déconnecté
                        txtChat.append("You are disconnected from the server.\n");
                        isConnected = false;

                } catch (IOException ex) {
                        txtChat.append("Error while disconnecting from the server.\n");
                }

        }

        protected void btnConnectActionPerformed(ActionEvent evt) {
                try {
                        // Vérifier si l'utilisateur est déjà connecté
                        if (isConnected) {
                                JOptionPane.showMessageDialog(null, "You are already connected to the server.");
                                return;
                        }

                        String username = tfUsername.getText();
                        String address = tfAddress.getText().toString();
                        int port = Integer.parseInt(tfPort.getText());
                        User client = new User(username);

                        InetAddress inet = InetAddress.getByName(address);

                        socketClient = new Socket(inet, port);
                        InputStreamReader isr = new InputStreamReader(socketClient.getInputStream());
                        printWriterClient = new PrintWriter(socketClient.getOutputStream());
                        bufferedReader = new BufferedReader(isr);

                        Paquet paquet = new Paquet(client, "connecte-moi", Command.CONNECT);
                        printWriterClient.println(paquet.toString());
                        printWriterClient.flush();
                        isConnected = true;

                        // Rester en écoute
                        Thread thread = new Thread(new ClientThread(bufferedReader));
                        thread.start();

                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
        }

        protected void tfUsernameFocusLost(FocusEvent evt) {
                String str = tfUsername.getText().length() <= 0 ? "Username" : tfUsername.getText();
                tfUsername.setText(str);
        }

        protected void tfPortFocusLost(FocusEvent evt) {
                String str = tfPort.getText().length() <= 0 ? "5000" : tfPort.getText();
                tfPort.setText(str);
        }

        protected void tfAddressFocusLost(FocusEvent evt) {
                String str = tfAddress.getText().length() <= 0 ? "localhost" : tfAddress.getText();
                tfAddress.setText(str);
        }

        private void tfUsername7FocusGained(FocusEvent evt) {// GEN-FIRST:event_tfUsername7FocusGained
                String str = tfUsername.getText().equals("Username") ? "" : tfUsername.getText();
                tfUsername.setText(str);
        }// GEN-LAST:event_tfUsername7FocusGained

        private void tfAddress7FocusGained(FocusEvent evt) {// GEN-FIRST:event_tfAddress7FocusGained
                String str = tfAddress.getText().equals("localhost") ? "" : tfAddress.getText();
                tfAddress.setText(str);
        }// GEN-LAST:event_tfAddress7FocusGained

        private void tfPortFocusGained(FocusEvent evt) {
                String str = tfPort.getText().equals("5000") ? "" : tfPort.getText();
                tfPort.setText(str);
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        public static javax.swing.JButton btnSend;
        private javax.swing.JLabel LblClient;
        public static javax.swing.JTextArea txtChat;
        public static javax.swing.JTextArea txtMessage;
        public static javax.swing.JButton btnClear;
        public static javax.swing.JButton btnConnect;
        public static javax.swing.JButton btnDisconnect;
        private javax.swing.JDesktopPane jDesktopPane;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        public static javax.swing.JTextField tfAddress;
        public static javax.swing.JTextField tfPort;
        public static javax.swing.JTextField tfUsername;
        // End of variables declaration//GEN-END:variables
}
