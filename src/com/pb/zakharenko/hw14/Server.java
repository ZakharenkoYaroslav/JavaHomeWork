package com.pb.zakharenko.hw14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ": Получен запрос от клиента");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


                // печатаем время
                String clientText = in.readLine();
                System.out.println("\nПолучен текст: " + clientText );



                // имитация долгой обработки запроса
                int sec = 10;
                System.out.println("Ждем " + sec + " секунд имитируя долгую обработку");
                Thread.sleep(sec * 1000);

                // пишем ответ
                //out.write(LocalDateTime.now().toString());
                //out.write(clientText);
                out.write("Сервер: " + LocalDateTime.now().toString() + "  \n" + clientText);

                System.out.println("Закрываем соединение с клиентом");
                out.close();
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception ex) {
                    // ignore
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен на порту : " + port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        // В цикле ждем запроса клиента
        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }
}
