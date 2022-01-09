package com.pb.zakharenko.hw14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
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

        // Основной цикл отправки сообщений серверу
        while ((dataFromUser = inConsole.readLine()) != null) {
            outServer.println(dataFromUser);
            //outServer.write(dataFromUser);
            String stringFromServer = inServer.readLine();
            dataFromServer = "";
            while (stringFromServer != null){

                dataFromServer = dataFromServer + stringFromServer;
                stringFromServer = inServer.readLine();
            }

            System.out.println(dataFromServer);
            if ("exit".equalsIgnoreCase(dataFromUser)) {
                break;
            }
        }
        System.out.println("Закрываем все сокеты");
        outServer.close();
        inServer.close();
        inConsole.close();
        server.close();
        System.out.println("\nВсе сокеты закрыты!");
    }
}