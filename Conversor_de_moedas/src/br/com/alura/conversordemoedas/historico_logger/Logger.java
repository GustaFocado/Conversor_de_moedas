package br.com.alura.conversordemoedas.historico_logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
        private static final String LOG_FILE = "conversoes.log";

        public static void registrar(String mensagem) {
            try (FileWriter fw = new FileWriter(LOG_FILE, true);
                 PrintWriter pw = new PrintWriter(fw)) {
                LocalDateTime agora = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String dataHora = agora.format(formatter);
                pw.println(dataHora + " - " + mensagem);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

