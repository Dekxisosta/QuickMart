package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptArchiveService {
	public void archiveReceipt(String id, String content) {
        try {
            String projectPath = System.getProperty("user.dir");
            File logDir = new File(projectPath, "receipts");
            
            if (!logDir.exists()) {
                boolean created = logDir.mkdirs();
                System.out.println("Receipts folder created: " + created);
            }
            File logFile = new File(logDir, "rec_" + id + ".html");
            
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
