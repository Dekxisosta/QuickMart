package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptArchiveService {
	public void logTransaction(String id, String content) {
        try {
            String projectPath = System.getProperty("user.dir");
            File logDir = new File(projectPath, "logs");
            
            if (!logDir.exists()) {
                boolean created = logDir.mkdirs();
                System.out.println("Logs folder created: " + created);
            }
            File logFile = new File(logDir, "trans_" + id + ".html");
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile))) {
                writer.write(content);
                System.out.println("SUCCESS: Receipt saved at -> " + logFile.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("IPC LOGGING ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
