package com.laisvidoto.calculadoraexercicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.aluno.calculadora.Calculadora;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private double operador1;// realiza operação
    private double operador2;// realiza operação

    private String operadores;// guarda operador

    private EditText editText;
    private Button buttonC;
    private Button buttonMaisMenos;
    private Button buttonPorcentagem;
    private Button buttonDivisao;
    private Button buttonMultiplicacao;
    private Button buttonMenos;
    private Button buttonMais;
    private Button buttonIgual;
    private Button buttonPonto;

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
        buttonPonto  = (Button) findViewById(R.id.buttonPonto);

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


    private void setLister()
    {
        buttonC.setOnClickListener(MainActivity.this);
        buttonMaisMenos.setOnClickListener(MainActivity.this);
        buttonPorcentagem.setOnClickListener(MainActivity.this);
        buttonDivisao.setOnClickListener(MainActivity.this);
        buttonMultiplicacao.setOnClickListener(MainActivity.this);
        buttonMenos.setOnClickListener(MainActivity.this);
        buttonMais.setOnClickListener(MainActivity.this);
        buttonIgual.setOnClickListener(MainActivity.this);
        buttonPonto.setOnClickListener(MainActivity.this);

        button9.setOnClickListener(MainActivity.this);
        button8.setOnClickListener(MainActivity.this);
        button7.setOnClickListener(MainActivity.this);
        button6.setOnClickListener(MainActivity.this);
        button5.setOnClickListener(MainActivity.this);
        button4.setOnClickListener(MainActivity.this);
        button3.setOnClickListener(MainActivity.this);
        button2.setOnClickListener(MainActivity.this);
        button1.setOnClickListener(MainActivity.this);
        button0.setOnClickListener(MainActivity.this);
    }


    @Override
    public void onClick(View v)
    {
        switch ( v.getId() )
        {

            /* Numeros */
            case R.id.button0:
                tecladoNumerico(0);
                break;
            case R.id.button1:
                tecladoNumerico(1);
                break;
            case R.id.button2:
                tecladoNumerico(2);
                break;
            case R.id.button3:
                tecladoNumerico(3);
                break;
            case R.id.button4:
                tecladoNumerico(4);
                break;
            case R.id.button5:
                tecladoNumerico(5);
                break;
            case R.id.button6:
                tecladoNumerico(6);
                break;
            case R.id.button7:
                tecladoNumerico(7);
                break;
            case R.id.button8:
                tecladoNumerico(8);
                break;
            case R.id.button9:
                tecladoNumerico(9);
                break;

            /* Operadores */
            case R.id.buttonC:
                limpar();
                break;
            case R.id.buttonMaisMenos:
                mudarOperadorMaisOuMenos();
                break;

            case R.id.buttonPonto:
                ponto(".");
                break;

            case R.id.buttonPorcentagem:
                operacao("%");
                break;
            case R.id.buttonDivisao:
                operacao("/");
                break;
            case R.id.buttonMultiplicacao:
                operacao("*");
                break;
            case R.id.buttonMenos:
                operacao("-");
                break;
            case R.id.buttonMais:
                operacao("+");
                break;
            case R.id.buttonIgual:
                igual();
                break;
        }
    }

    /*
     *   Função para saber qual operador foi clicado
     */
    private void operacao( String operacao)
    {
        this.operadores = operacao;

        if(operacao == "+"){
            operador1 = Double.parseDouble( editText.getText().toString().trim() );
            editText.setText(editText.getText().toString() + operacao);
        }
        else if(operacao == "-"){
            operador1 = Double.parseDouble( editText.getText().toString().trim() );
            editText.setText(editText.getText().toString() + operacao);
        }
        else if(operacao == "*"){
            operador1 = Double.parseDouble( editText.getText().toString().trim() );
            editText.setText(editText.getText().toString() + operacao);
        }
        else if(operacao == "/"){
            operador1 = Double.parseDouble( editText.getText().toString().trim() );
            editText.setText(editText.getText().toString() + operacao);
        }
        else if(operacao == "%"){
            operador1 = Double.parseDouble( editText.getText().toString().trim() );
            editText.setText(editText.getText().toString() + operacao);
        }
    }


    /* Função que recebe qual o numero digitado */
    private void tecladoNumerico(int numeroClicado)
    {
        if(editText.getText().toString().trim().equals("0"))
        {
            editText.setText( String.valueOf(numeroClicado) );
        }
        else
        {
            editText.setText( editText.getText().toString() + String.valueOf(numeroClicado) );
        }
    }

    private void ponto(String ponto)
    {
        editText.setText(editText.getText().toString() + ponto);
    }

    private void mudarOperadorMaisOuMenos()
    {

    }

    private void limpar()
    {
        editText.setText("");
    }

    private void igual( )
    {
        Double resultado = 0.0;
        if( !editText.getText().toString().trim().equals("") )
        {
            if(operadores  == "+")
            {
                operador2 = operador1 + Double.parseDouble( editText.getText().toString().trim() );
                resultado = Calculadora.adicao(operador1,operador2 );
                limpar();
                editText.setText( String.valueOf(resultado) );
            }
            else if(operadores  == "*")
            {
                operador2 = operador1 + Double.parseDouble( editText.getText().toString().trim() );
                resultado = Calculadora.multiplicacao(operador1,operador2 );
                limpar();
                editText.setText( String.valueOf(resultado) );
            }
            else if(operadores  == "-")
            {
                operador2 = operador1 + Double.parseDouble( editText.getText().toString().trim() );
                resultado = Calculadora.subtracao(operador1,operador2 );
                limpar();
                editText.setText( String.valueOf(resultado) );
            }
            else if(operadores  == "%")
            {
                operador2 = operador1 + Double.parseDouble( editText.getText().toString().trim() );
                resultado = Calculadora.percentual(operador1 );
                limpar();
                editText.setText( String.valueOf(resultado) );
            }
            else if(operadores  == "/")
            {
                if( operador1 == 0 )
                {
                    operador2 = 0;
                }
                else
                {
                    operador2 = operador1 + Double.parseDouble( editText.getText().toString().trim() );
                }
                resultado = Calculadora.divisao(operador1,operador2 );
                limpar();
                editText.setText( String.valueOf(resultado) );
            }
            else
            {
                operador2 = 0;
            }
            editText.setText( String.valueOf(resultado) );
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicial();
        setLister();
    }
}