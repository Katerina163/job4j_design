package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        if (str.contains("Exit")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            server.close();
                        } else if (str.contains("Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello, dear friend.\r\n\r\n".getBytes());
                        } else if (str.contains("Any")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("What?\r\n\r\n".getBytes());
                        }
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                }
            }
        } catch (IOException ioE) {
            LOG.error("Error", ioE);
        }
    }
}
