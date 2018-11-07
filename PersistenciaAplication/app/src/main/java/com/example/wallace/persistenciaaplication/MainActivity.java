package com.example.wallace.persistenciaaplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView nameOutput;
    private TextView matOutput;
    private Button buttonSalvar;
    private EditText name;
    private EditText matricula;
    private MySharedPreference preference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//       Shared Preferences
        preference = MySharedPreference.getInstance(this);

        name = findViewById(R.id.edtNameInput);
        matricula = findViewById(R.id.edtMatInput);
        nameOutput = findViewById(R.id.txtNameOutput);
        matOutput = findViewById(R.id.txtMatOutput);

        buttonSalvar = findViewById(R.id.btnSalvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preference.setUserName(name.getText().toString());
                preference.setUserMatricula(Integer.parseInt(matricula.getText().toString()));
                updateInformation();
            }
        });

        updateInformation();

        // ---------------   FINISH UPDATE INFORMATION -------------------------

        // ---------------   SQLITE database -------------------------
        Usuario usuario1 = new Usuario("João", "123456", "João Silva");
        Usuario usuario2 = new Usuario("Maria", "123456", "Maria Silva");

        UsuariosDAO dao = new UsuariosDAO(getApplicationContext());

        //Insere dois usuários na base de Dados
        dao.inserirUsuario(usuario1);
        dao.inserirUsuario(usuario2);

        //Chama o método para carregar os usuário da base
        dao.getUsuarios();

        //Deleta o usuário que possui o valor na coluna usuario igual ao passado por parametro.
        dao.deleteUsuario("Maria");
//        dao.deleteUsuario("João");
        dao.getUsuarios();

        // ---------------   FINISH SQLITE database -------------------------

    }

    private void updateInformation() {
        nameOutput.setText(preference.getUserName());
        matOutput.setText(String.valueOf(preference.getUserMatricula()));
    }
}
