package br.edu.unibratec.conceitosbasicos.listener;

public class Client implements EventClickListener {

    public void test() {
        Provider p = new Provider();

        p.setEventListener(new EventClickListener() {
            @Override
            public void onClick() {

            }
        });
    }


    @Override
    public void onClick() {

    }
}
