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
                    int i = 0;
                    while (!str.isEmpty()) {
                        if (str.contains("Exit")) {
                            i = 1;
                        } else if (str.contains("Hello")) {
                            i = 2;
                        } else if (str.contains("Any")) {
                            i = 3;
                        }
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    switch (i) {
                        case 1 -> server.close();
                        case 2 -> out.write("Hello, dear friend.\r\n\r\n".getBytes());
                        case 3 -> out.write("What?\r\n\r\n".getBytes());
                    }
                }
            }
        } catch (IOException ioE) {
            LOG.error("Error", ioE);
        }
    }
}
