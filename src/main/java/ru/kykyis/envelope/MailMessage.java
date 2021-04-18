package ru.kykyis.envelope;

public class MailMessage extends AbstractSend<String>{
    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}
