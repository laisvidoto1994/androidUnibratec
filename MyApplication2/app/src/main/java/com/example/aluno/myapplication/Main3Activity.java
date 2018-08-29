package com.example.aluno.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener
{
    private EditText mEditText1;
    private EditText mEditText2;
    private Button   mButton1;

    public void inicial()
    {
        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
        mButton1 = (Button) findViewById(R.id.button1);
    }

    private void setLister()
    {
        mButton1.setOnClickListener(Main3Activity.this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        inicial();
        setLister();

        Intent intent = getIntent();
        if (intent != null)
        {
            Double param1 = intent.getDoubleExtra("numero1", 999);
            String param2 = intent.getStringExtra("numero2");

            mEditText1.setText(Double.toString(param1));
            mEditText2.setText(param2);
        }

    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.button1)
        {
            showResult();
        }
    }

    private void showResult()
    {
        String phone = "+55988240540";

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.fromParts("tel", phone, null));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }
}
