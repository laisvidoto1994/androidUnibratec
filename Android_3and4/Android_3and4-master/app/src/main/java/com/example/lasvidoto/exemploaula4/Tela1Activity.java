package com.example.lasvidoto.exemploaula4;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tela1Activity extends AppCompatActivity
{
    EditText mTextNome;
    TextView mTextResultado;
    Button mButTela1;
    Button mButTela2;
    String mTextoDigitado;

/**
*  Metodo
*/

    private View.OnClickListener tratadorDoBotao = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            if ( view.getId() == R.id.button )
            {
                mTextoDigitado = mTextNome.getText().toString();
                atualizarTextoNaTela();
                mTextNome.getText().clear();
            } else if (  view.getId() == R.id.button2 )
            {
                Intent it = new Intent( Tela1Activity.this, Tela2Activity.class );
                startActivity(it);
            }
        }
    };

/**
 *  Metodo de Atualização de texto quando for girado á tela
 */
    private void atualizarTextoNaTela()
    {
        mTextResultado.setText( mTextoDigitado );
    }

/**
*  Metodo de criação da activity(tela)
*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        mTextResultado = (TextView) mTextResultado.findViewById(R.id.textView3);
        mTextNome      = (EditText) mTextNome.findViewById(R.id.editText);
        mButTela1      = (Button) mButTela1.findViewById(R.id.button);
        mButTela1.setOnClickListener(tratadorDoBotao);
        mButTela2      = (Button) mButTela2.findViewById(R.id.button2);
        mButTela2.setOnClickListener(tratadorDoBotao);

        if (savedInstanceState != null)
        {
            mTextoDigitado = savedInstanceState.getString("pTexto");
            atualizarTextoNaTela();
        }
    }

/**
*  Metodo salva á instancia
*/
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("pTexto",mTextoDigitado);
    }
}
