package com.example.aluno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity
{
    private EditText mEditText;
    private EditText mEditText2;
    private EditText mEditText3;

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;

    public void inicial()
    {
        mEditText = (EditText) findViewById(R.id.editText);
        mEditText2 = (EditText) findViewById(R.id.editText2);
        mEditText3 = (EditText) findViewById(R.id.editText3);

        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton4 = (Button) findViewById(R.id.button4);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        inicial();

         /*
        Intent intent = getIntent();
        if(intent != null)
        {
            String param = intent.getStringExtra("chave1");
        }
        */

        Intent intentResult = new Intent();
        intentResult.putExtra("chave2","Activity anterior" );

        //startActivity(intent);
        setResult(01, intentResult);

        /*
            Calculo do botão de Adicionar
        */
        mButton1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Integer t1 = Integer.parseInt( mEditText2.getText().toString() );
                Integer t2 = Integer.parseInt( mEditText3.getText().toString() );
                Integer result = t1 + t2;

                Intent intentResult = new Intent();
                intentResult.putExtra("chaves2","Activity" );

                //startActivity(intent);
                setResult(01, intentResult);
            }
        });

        /*
            Calculo do botão de Subtrair
        */
        mButton2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Integer t1 = Integer.parseInt( mEditText2.getText().toString() );
                Integer t2 = Integer.parseInt( mEditText3.getText().toString() );
                Integer result = t1 - t2;

                Intent intentResult = new Intent();
                intentResult.putExtra("chaves2","Activity" );

                //startActivity(intent);
                setResult(01, intentResult);
            }
        });

        /*
            Calculo do botão de Dividir
        */
        mButton3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Integer t1 = Integer.parseInt( mEditText2.getText().toString() );
                Integer t2 = Integer.parseInt( mEditText3.getText().toString() );
                Integer result = t1 / t2;

                Intent intentResult = new Intent();
                intentResult.putExtra("chaves2","Activity" );

                //startActivity(intent);
                setResult(01, intentResult);
            }
        });

         /*
            Calculo do botão de Multiplicar
        */
        mButton4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Integer t1 = Integer.parseInt( mEditText2.getText().toString() );
                Integer t2 = Integer.parseInt( mEditText3.getText().toString() );
                Integer result = t1 * t2;

                Intent intentResult = new Intent();
                intentResult.putExtra("chaves2","Activity" );

                //startActivity(intent);
                setResult(01, intentResult);
            }
        });


    }
}
