package uz.pdp.telegram_alarm;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class TelegramAlarmExample {
    static {
        String file = TelegramAlarmExample.class.getClassLoader().getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", file);
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(TelegramAlarmExample.class.getSimpleName());
//        TelegramAlarmHandler handler = new TelegramAlarmHandler();
//        handler.setFormatter(new TelegramAlarmFormatter());
//        logger.addHandler(handler);

        LogRecord logRecord = new LogRecord(Level.SEVERE, "Severe for notify");
        logger.log(logRecord);
    }
}
