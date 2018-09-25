package com.laisvidoto.calculadoraexercicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button buttonC;
    private Button buttonMaisMenos;
    private Button buttonPorcentagem;
    private Button buttonDivisao;
    private Button buttonMultiplicacao;
    private Button buttonMenos;
    private Button buttonMais;
    private Button buttonIgual;
    private Button buttonVirgula;

    private Button button9;
    private Button button8;
    private Button button7;
    private Button button6;
    private Button button5;
    private Button button4;
    private Button button3;
    private Button button2;
    private Button button1;
    private Button button0;
    
      public void inicial()
    {
        editText = (EditText) findViewById(R.id.editText);
        buttonC  = (Button) findViewById(R.id.buttonC);
        buttonMaisMenos  = (Button) findViewById(R.id.buttonMaisMenos);
        buttonPorcentagem  = (Button) findViewById(R.id.buttonPorcentagem);
        buttonDivisao  = (Button) findViewById(R.id.buttonDivisao);
        buttonMultiplicacao  = (Button) findViewById(R.id.buttonMultiplicacao);
        buttonMenos  = (Button) findViewById(R.id.buttonMenos);
        buttonMais  = (Button) findViewById(R.id.buttonMais);
        buttonIgual  = (Button) findViewById(R.id.buttonIgual);
        buttonVirgula  = (Button) findViewById(R.id.buttonVirgula);

        button9  = (Button) findViewById(R.id.button9);
        button8  = (Button) findViewById(R.id.button8);
        button7  = (Button) findViewById(R.id.button7);
        button6  = (Button) findViewById(R.id.button6);
        button5  = (Button) findViewById(R.id.button5);
        button4  = (Button) findViewById(R.id.button4);
        button3  = (Button) findViewById(R.id.button3);
        button2  = (Button) findViewById(R.id.button2);
        button1  = (Button) findViewById(R.id.button1);
        button0  = (Button) findViewById(R.id.button0);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
         inicial();

        /*
            Botão C
        */
        buttonC.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               //realiza á operação
            }
        });
    }
}
