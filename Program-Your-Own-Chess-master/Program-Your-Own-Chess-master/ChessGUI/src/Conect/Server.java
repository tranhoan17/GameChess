/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conect;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Hoan Tran
 */
public class Server {
    public static void main(String args[]) {
 
       ServerSocket listener = null;
       String line;
       BufferedReader is;
       BufferedWriter os;
       Socket socketOfServer = null;
 
    
 
       // Mở một ServerSocket tại cổng 9999.
  
       try {
           listener = new ServerSocket(9999);
       } catch (IOException e) {
           System.out.println(e);
           System.exit(1);
       }
 
       try {
           System.out.println("Server is waiting to accept user...");
 
 
           // Chấp nhận một yêu cầu kết nối từ phía Client.
           // Đồng thời nhận được một đối tượng Socket tại server.
 
           socketOfServer = listener.accept();
           System.out.println("Accept a client!");
 
      
           // Mở luồng vào ra trên Socket tại Server.
           is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
           os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
 
    
           // Nhận được dữ liệu từ người dùng và gửi lại trả lời.
           while (true) {
               // Đọc dữ liệu tới server (Do client gửi tới).
               line = is.readLine();
               System.out.println(line);
               // Ghi vào luồng đầu ra của Socket tại Server.
               // (Nghĩa là gửi tới Client).
               os.write(">> " + line);
               // Kết thúc dòng

               os.flush();  
 
           }
 
       } catch (IOException e) {
           System.out.println(e);
           e.printStackTrace();
       }
       System.out.println("Sever stopped!");
   }
}
