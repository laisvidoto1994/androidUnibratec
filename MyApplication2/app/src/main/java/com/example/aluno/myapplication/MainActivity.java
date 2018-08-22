package com.example.aluno.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button   mButton;
    private Button   mButton2;
    private EditText mEditText1;
    private EditText mEditText2;

    public void inicial()
    {
        mButton    = (Button)   findViewById(R.id.button);
        mButton2   = (Button)   findViewById(R.id.button2);
        mEditText1 = (EditText) findViewById(R.id.editText);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicial();

        mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                double t1 = Double.parseDouble( mEditText1.getText().toString() );
                double t2 = Double.parseDouble( mEditText2.getText().toString() );
                double result = t1 * 0.7;

                if( t2 <= result )
                {
                    Toast.makeText(MainActivity.this, "abasteça com álcool",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "abasteça com Gasolina",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("chave1","nova Activity" );
                //startActivity(intent);
                startActivityForResult(intent, 01);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 01)
        {
            String param = data.getStringExtra("chave2");
        }
    }
}