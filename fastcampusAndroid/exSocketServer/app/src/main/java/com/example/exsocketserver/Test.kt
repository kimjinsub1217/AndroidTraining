package com.example.exsocketserver

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {
    Thread {
        val port = 8080
        val server = ServerSocket(port)


//        socket.getInputStream() //클라이언트로부터 들어오는 스트림 == 클라이언트의 socket.outputStream
//        socket.getOutputStream() // 클라이언트에게 데이터를 주는 스트림 == socket.inputStream
        while (true) {

            val socket = server.accept()
            val reader = BufferedReader(InputStreamReader(socket.getInputStream()))
            val printer = PrintWriter(socket.getOutputStream())

            var input: String? = "-1"

//       계속 읽다가 빈값 혹은 null이 오면 읽기 종료
            while (input != null && input != "") {
                input = reader.readLine()
            }

            println("READ DATA $input")

            printer.println("HTTP/1.1 200 OK")
            printer.println("Content-Type : text/html\r\n")

            printer.println("{\"message\": \"날씨:맑음\"}")
            printer.println("\r\n")

//      남아있는 버퍼 내용 배출
            printer.flush()
            printer.close()

            reader.close()
            socket.close()
        }

    }.start()

}