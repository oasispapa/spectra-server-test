package com.spectra.Spectra.chat;

import com.spectra.Spectra.SpectraApplication;
import org.springframework.boot.SpringApplication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConsoleChatServer extends Thread {
    private Socket sock;
    private static ArrayList<Socket> clients = new ArrayList<>(5);

    public ConsoleChatServer(Socket sock) {
        this.sock = sock;
    }
    public void run() {
        InputStream fromClient = null;
        OutputStream toClient = null;

        try {
            System.out.println(sock + ": 연결됨");
            fromClient = sock.getInputStream();
            byte[] buf = new byte[1024];
            String msg = "소켓이 연결되었습니다.";
            int count;
            while ((count = fromClient.read(buf)) != -1) {
                for(Socket s : ConsoleChatServer.clients) {
                    toClient = s.getOutputStream();
                    toClient.write(buf, 0, count);
                    toClient.flush();
                }
                System.out.write(buf, 0, count);
            }
        } catch (Exception e) {
            System.out.println(sock + " : 에러 (" + e + ")");
        } finally {
            try {
                if (sock != null) {
                    sock.close();
                    remove(sock);
                }
                fromClient = null;
                toClient = null;
            } catch (IOException e) {

            }
        }
    }
    public void remove(Socket socket) {
        for(Socket s : ConsoleChatServer.clients) {
            if (socket == s) {
                ConsoleChatServer.clients.remove(socket);
                break;
            }
        }
    }


    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9998);
        System.out.println("서버소켓 생성 : " + serverSocket);

        while(true) {
            Socket client = serverSocket.accept();
            clients.add(client);

            ConsoleChatServer myServer = new ConsoleChatServer(client);
            myServer.start();
        }

    }

}
