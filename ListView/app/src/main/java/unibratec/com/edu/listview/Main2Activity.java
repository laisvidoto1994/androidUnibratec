package unibratec.com.edu.listview;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private String numero1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView name = (TextView) findViewById(R.id.textView_name);

        Intent intent = getIntent();
        numero1 = intent.getStringExtra("tentando1");
        name.setText(String.valueOf(numero1));

    }
}
