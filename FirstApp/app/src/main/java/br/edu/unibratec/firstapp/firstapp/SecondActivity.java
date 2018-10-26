package br.edu.unibratec.firstapp.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if (intent != null) {
            String param = intent.getStringExtra(Constants.EXTRA_01);
            Toast.makeText(this, "O parametro foi = " + param, Toast.LENGTH_LONG).show();
        }

        Intent intentResponse = new Intent();
        intentResponse.putExtra(Constants.EXTRA_02, getString(R.string.first_activity));
        setResult(MainActivity.REQUEST_CODE, intentResponse);
    }

}
