package ru.kykyis.envelope;


public interface Enveloped<T> {
    String getTo();
    String getFrom();
    T getContent();
}
