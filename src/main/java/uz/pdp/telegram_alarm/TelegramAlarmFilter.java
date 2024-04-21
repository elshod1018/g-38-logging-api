package uz.pdp.telegram_alarm;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class TelegramAlarmFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord logRecord) {
        return Level.SEVERE.intValue() == logRecord.getLevel().intValue();
    }
}
