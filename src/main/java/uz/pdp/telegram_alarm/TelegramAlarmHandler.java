package uz.pdp.telegram_alarm;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class TelegramAlarmHandler extends StreamHandler {
    private final String TOKEN = "6855851211:AAFT4w4WNhw1sZWTiD4lFmbu6qNZjBUjAtQ";
    private final String CHAT_ID = "5174610361";

    public TelegramAlarmHandler() {
        super.setFormatter(new TelegramAlarmFormatter());
        super.setFilter(new TelegramAlarmFilter());
    }

    @Override
    public synchronized void publish(LogRecord record) {
        if (isLoggable(record)) {
            try {
                TelegramBot bot = new TelegramBot(TOKEN);
                String message = record.getMessage();
                SendMessage sendMessage = new SendMessage(CHAT_ID, message);
                bot.execute(sendMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return getFilter().isLoggable(record);
    }
}
