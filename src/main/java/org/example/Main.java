package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String city = "???";
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    out.println(city);
                    String nextCity = in.readLine();
                    if (Objects.equals(nextCity, "end")) {
                        out.println("Game over");
                        break;
                    }
                    if (Objects.equals(city, "???")) {
                        city = nextCity;
                        out.println("OK");
                    }
                    if (city.charAt(nextCity.length() - 1) == nextCity.charAt(0)) {
                        city = nextCity;
                        out.println("OK");
                    } else out.println("NOT OK");
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}