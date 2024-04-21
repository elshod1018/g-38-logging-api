package uz.pdp;

import java.io.IOException;
import java.util.logging.*;

public class LoggingApiExample {
    static {
        String file = LoggingApiExample.class.getClassLoader().getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", file);
    }

    static Logger logger = Logger.getLogger(LoggingApiExample.class.getSimpleName());

    public static void main(String[] args) throws IOException {
//        logger.setUseParentHandlers(false);
//        ConsoleHandler consoleHandler = new ConsoleHandler();
//        logger.addHandler(consoleHandler);

//        FileHandler fileHandler = new FileHandler("logs.log", true);
//        SimpleFormatter simpleFormatter = new SimpleFormatter();
//        fileHandler.setFormatter(simpleFormatter);
//        logger.addHandler(fileHandler);


//        logger.setLevel(Level.ALL);

        logger.log(Level.INFO, "Log lesson");

        LogRecord logRecord = new LogRecord(Level.INFO, "Log from log record");
        logger.log(logRecord);

    }
    //ALL FINEST FINE INFO WARNING SEVERE OFF
}
