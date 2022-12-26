package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket("127.0.0.1", 8080);
             Scanner scanner = new Scanner(System.in);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String city = in.readLine();
            System.out.println("Название города: " + city);
            System.out.println("Введите следующий город:");
            out.println(scanner.nextLine());
            String input = in.readLine();
            System.out.println(input);
        }
    }
}
