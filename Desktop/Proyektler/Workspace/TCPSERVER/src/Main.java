import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public Main() {
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        readAsByte();
    }

    public static void readAsByte() throws Exception {
        ServerSocket serverSocket = new ServerSocket(7500);

        while (true) {
            Socket socket = serverSocket.accept();
            //soketden oxu basladi
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            int msslen = dis.readInt();
            byte[] arr = new byte[msslen];
            dis.readFully(arr);
            System.out.println(new String(arr));
            //socketden oxu bitdi

            //write begin
            OutputStream ou = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(ou);
            byte[] bytes = new Scanner(System.in).nextLine().getBytes();
            dos.writeInt(bytes.length);
            dos.write(bytes);
            //write end


        }

    }

    public static void readAsString() throws Exception {
        ServerSocket serverSocket = new ServerSocket(6789);

        while (true) {
            Socket socket = serverSocket.accept();
            InputStreamReader reader = new InputStreamReader(socket.getInputStream());
            BufferedReader breader = new BufferedReader(reader);
            String messageFromClient = breader.readLine();
            System.out.println("musteri deyir ki " + messageFromClient);
        }

    }


}
