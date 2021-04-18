package ru.kykyis.service;

import ru.kykyis.envelope.Enveloped;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Enveloped<T>> {
    Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        /*
        т.к. один из assert'ов требует того,
        чтобы при попытке просмотреть сообщения от того,
        с кем их не было,
        возвращался пустой список,
        переопределим функцию get mailbox'a
        (хотя логичнее просто было поменять в main get на getOrDefault)
        */
        @Override
        public List<T> get(Object key) {
            return getOrDefault(key, new ArrayList<T>());
        }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    //для использования функционального интерфейса пропишем логику добавления писем по получателю
    @Override
    public void accept(Enveloped<T> envelope) {
        List<T> list;
        if (mailBox.containsKey(envelope.getTo())) {
            list = mailBox.get(envelope.getTo());
        } else {
            list = new ArrayList<>();
        }
        list.add(envelope.getContent());
        mailBox.put(envelope.getTo(), list);
    }

    @Override
    public Consumer andThen(Consumer after) {
        return Consumer.super.andThen(after);
    }
}
