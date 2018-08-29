package com.example.aluno.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener
{
    private EditText mEditText;
    private EditText mEditText2;
    private EditText mEditText3;

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        inicial();
        setLister();

         /*
        Intent intent = getIntent();
        if(intent != null)
        {
            String param = intent.getStringExtra("chave1");
        }
        */
/*
        Intent intentResult = new Intent();
        intentResult.putExtra("chave2","Activity anterior" );

        //startActivity(intent);
        setResult(01, intentResult);
*/


    }

    public void inicial()
    {
        mEditText = (EditText) findViewById(R.id.editText);
        mEditText2 = (EditText) findViewById(R.id.editText2);
        mEditText3 = (EditText) findViewById(R.id.editText3);

        mButton1 = (Button) findViewById(R.id.button1); // +
        mButton2 = (Button) findViewById(R.id.button2); // -
        mButton3 = (Button) findViewById(R.id.button3); // /
        mButton4 = (Button) findViewById(R.id.button4); // *
    }

    private void setLister()
    {
        mButton1.setOnClickListener(Main2Activity.this);
        mButton2.setOnClickListener(Main2Activity.this);
        mButton3.setOnClickListener(Main2Activity.this);
        mButton4.setOnClickListener(Main2Activity.this);
    }

    @Override
    public void onClick(View view)
    {
        double valor1 = Double.parseDouble( mEditText2.getText().toString() );
        double valor2 = Double.parseDouble( mEditText3.getText().toString() );

        double result = 0;
        String operador = "";

        switch ( view.getId() )
        {
            case R.id.button1:
                result = Calculador.adicao(valor1, valor2);
                operador = "adicao";
            case R.id.button2:
                result = Calculador.subtracao(valor1, valor2);
                operador = "subtracao";
            case R.id.button3:
                result = Calculador.divisao(valor1, valor2);
                operador = "divisao";
            case R.id.button4:
                result = Calculador.multiplicacao(valor1, valor2);
                operador = "multiplicacao";
        }

        //chamada para á proxima tela
        showResult(result,operador);
    }

    private void showResult(double result, String operador)
    {
        // instancia a intenty definindo TelaResultado como "destino"
        Intent it = new Intent(Main2Activity.this, Main3Activity.class);

        // passa os valores das TextEdits para o intent
        it.putExtra("numero1", result);
        it.putExtra("numero2", operador);

        // lança a Activity com o intent por parametro
        startActivity(it);
    }
}
