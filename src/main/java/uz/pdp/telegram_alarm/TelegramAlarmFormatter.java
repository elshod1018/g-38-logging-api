package uz.pdp.telegram_alarm;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class TelegramAlarmFormatter extends Formatter {

    @Override
    public String format(LogRecord logRecord) {
        Throwable thrown = logRecord.getThrown();
        String stackTrace = "\n";
        if (thrown != null) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            thrown.printStackTrace(printWriter);
            stackTrace += stringWriter;
        }
        return "%s :: [%s] :: [%s] :: [%s] :: %s %s"
                .formatted(logRecord.getLevel(),
                        logRecord.getInstant(),
                        logRecord.getLongThreadID(),
                        logRecord.getLoggerName(),
                        logRecord.getMessage(),
                        stackTrace);
    }
}
