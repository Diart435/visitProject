package com.prod.visitBack.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;

@Component
public class TelegramService extends TelegramLongPollingBot{
    private RequestService requestService;
    private static final Logger LOG = LoggerFactory.getLogger(TelegramService.class);
    private static final String START = "/start";
    private static final String DEL = "удалить";
    private static final Long[] ADMIN = {2021205361L, 5743914463L};
    public TelegramService(@Value("${bot.token}") String botToken, RequestService requestService) {
        super(botToken);
        this.requestService = requestService;
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }
        String message = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        switch (message) {
                case START -> startCommand(chatId);
                case DEL -> {
                    requestService.deleteAll();
                    sendMessage(chatId, "Заявки удалены.");
                }
        }
    }

    @Override
    public String getBotUsername() {
        return "Elecktik_tlt_bot";
    }
    private void startCommand(Long chatId) {
        StringBuilder sb;
        if(chatId.equals(ADMIN[0]) || chatId.equals(ADMIN[1])) {
            int count = requestService.getAmount();
            sb = new StringBuilder();
            sb.append("Полученных заявок: ").append(count).append(" \n");
            if (count > 0) {
                requestService.findAll().forEach(x -> sb.append(x.getUserName()).append(" ").append(x.getPhoneNumber()).append("\n"));
            }
            sendMessage(chatId, sb.toString());
        }
        else {
            sb = new StringBuilder();
            sb.append("Вас приветствует бот Электрика Тольятти, Автозаводский район\n").append("Если хотите связаться с электриком:\n").append("Телефон:+79297136283\n").append("Телеграм:@electrik_tlt");
            sendMessage(chatId, sb.toString());
        }
    }
    public void sendMessage(Long chatId, String text) {
        var chatIdStr = String.valueOf(chatId);
        var sendMessage = new SendMessage(chatIdStr, text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            LOG.error("Ошибка отправки сообщения", e);
        }
    }
}
