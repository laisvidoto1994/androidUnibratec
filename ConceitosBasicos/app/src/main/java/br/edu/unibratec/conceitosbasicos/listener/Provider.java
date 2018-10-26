package br.edu.unibratec.conceitosbasicos.listener;

import java.util.List;

public class Provider {

    private List<EventClickListener> listener;

    public void setEventListener(EventClickListener listener) {
        this.listener.add(listener);
    }

    public void doSomething() {



        notifyListener();
    }

    public void notifyListener() {

        for (EventClickListener l : listener) {
            l.onClick();
        }
    }
}
