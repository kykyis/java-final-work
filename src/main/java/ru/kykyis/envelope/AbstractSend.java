package ru.kykyis.envelope;

import java.util.Objects;

//вообще можно было объеденить с Enveloped в один абстрактный класс, но мне кажется так будет правильнее
abstract public class AbstractSend<T> implements Enveloped<T> {
    private final String from;
    private final String to;
    private final T content;


    public AbstractSend(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public T getContent() {
        return content;
    }

    //переопределим методы equals() и hashcode():
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        AbstractSend o = (AbstractSend) obj;

        return Objects.equals(from, o.getFrom()) &&
                Objects.equals(to, o.getTo()) &&
                Objects.equals(content, o.getContent());

    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, content) * 31;
    }
}
