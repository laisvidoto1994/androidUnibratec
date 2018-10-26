package br.edu.unibratec.melhorcombustivel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtAlcool;
    private EditText mEdtGasolina;
    private Button mBtnCalcular;
    private static final double FATOR_DE_CALCULO = 0.7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListener();
    }

    private void init() {
        mEdtAlcool = findViewById(R.id.edt_alcool);
        mEdtGasolina = findViewById(R.id.edt_gasolina);
        mBtnCalcular = findViewById(R.id.btn_calcular);
    }

    private void setListener() {
        mBtnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double valorAlcool = Double.parseDouble(mEdtAlcool.getText().toString());
                    double valorGasolina = Double.parseDouble(mEdtGasolina.getText().toString());

                    String result = (isAlcool(valorAlcool, valorGasolina)) ? getString(R.string.choice_alcool) : getString(R.string.choice_gasolina);

                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();

                } catch (NumberFormatException ex) {
                    Toast.makeText(MainActivity.this, getString(R.string.incorrect_values), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isAlcool(double valorAlcool, double valorGasolina) {
        return (valorAlcool <= valorGasolina * FATOR_DE_CALCULO);
    }
}
