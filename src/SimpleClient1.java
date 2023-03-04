import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient1 {
    final static Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) {

        try(Socket socket = new Socket(InetAddress.getLocalHost(), 7777);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream())
        ) {

            out.println(scaner.nextLine());
            out.flush();
            String str = in.readLine();
            System.out.println(str);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
