package com.pb.zakharenko.hw15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ChatWindowController {
    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws Exception {
        System.out.println("Клиент стартовал");
        String serverIp = "127.0.0.1";
        int serverPort = 1234;
        System.out.println("Соединяемся с сервером " + serverIp + ":" + serverPort);

        Socket server = new Socket(serverIp, serverPort);
        BufferedReader inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);
        BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Соединение с сервером установлено");
        String dataFromUser, dataFromServer;
        dataFromUser =  textField.getText();
        outServer.println(dataFromUser);
        dataFromServer = inServer.readLine();

        // Основной цикл отправки сообщений серверу
//        while ((dataFromUser =  textField.getText()) != null) {
//            outServer.println(dataFromUser);
            //outServer.write(dataFromUser);
//            String stringFromServer = inServer.readLine();
//            dataFromServer = inServer.readLine();


            textArea.setText(textArea.getText() + "\n" + "Клієнт пише:" + "\n" + textField.getText()+ "\n" + dataFromServer);
            textField.clear();
//            while (stringFromServer != null){
//
//                dataFromServer = dataFromServer + stringFromServer;
//                stringFromServer = inServer.readLine();
//          }

//            System.out.println(dataFromServer);
            if ("exit".equalsIgnoreCase(dataFromUser)) {
                System.exit(0);
            }
//        }
        System.out.println("Закрываем все сокеты");
        outServer.close();
        inServer.close();
        inConsole.close();
        server.close();
        System.out.println("\nВсе сокеты закрыты!");


    }
}