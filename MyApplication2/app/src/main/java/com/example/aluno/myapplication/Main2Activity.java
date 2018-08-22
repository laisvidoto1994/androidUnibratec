package com.example.aluno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity
{
    private EditText mEditText;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;

    public void inicial()
    {
        mEditText = (EditText) findViewById(R.id.editText);
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

    }

}
