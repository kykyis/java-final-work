package ru.kykyis.envelope;

public class Salary extends AbstractSend<Integer>{
    public Salary(String from, String to, Integer content) {
        super(from, to, content);
    }
}
