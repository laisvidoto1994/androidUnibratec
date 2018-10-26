package unibratec.com.edu.listview;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // criando array de dados
        ArrayList<Movie> list = new ArrayList<>();
        list.add(new Movie("Vingadores: Guerra Infinita", getResources().getDrawable(R.drawable.img01)));
        list.add(new Movie("Homem-Aranha: De Volta ao Lar", getResources().getDrawable(R.drawable.img02)));
        list.add(new Movie("Thor: Ragnarok", getResources().getDrawable(R.drawable.img03)));
        list.add(new Movie("Homem-Formiga e Vespa", getResources().getDrawable(R.drawable.img04)));
        list.add(new Movie("Homem-Formiga", getResources().getDrawable(R.drawable.img05)));
        list.add(new Movie("Guardiões da Galaxia", getResources().getDrawable(R.drawable.img06)));
        list.add(new Movie("Vingadores", getResources().getDrawable(R.drawable.img07)));
        list.add(new Movie("O Incrível Hulk", getResources().getDrawable(R.drawable.img08)));
        list.add(new Movie("Capitão América: O Primeiro Vingador", getResources().getDrawable(R.drawable.img09)));
        list.add(new Movie("Pantera Negra", getResources().getDrawable(R.drawable.img10)));
        list.add(new Movie("Capitão América: Guerra Civil", getResources().getDrawable(R.drawable.img11)));

        //chamando adapter (layout customizado do jeito que eu quero) passando para ele á lista de dados que eu fiz acima
        MovieAdapter movieAdapter = new MovieAdapter(this, list);

        //fazendo á referencia do listView do xml da mainActivity
        ListView listView = findViewById(R.id.listview);

        //listView esta vazio,então  preencho com o adapter (layout personalizado) já com os dados
        listView.setAdapter(movieAdapter);

        // se eu clicar em um item da lista, consigo saber qual á posição dele e mostrar na tela
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, ((Movie)parent.getItemAtPosition(position)).getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                String teste1   = ((Movie) parent.getItemAtPosition(position)).getName();
               // Drawable teste2 = ((Movie) parent.getItemAtPosition(position)).getLogo();

                intent.putExtra("tentando1", teste1);
                //intent.putExtra("tentando2", (Parcelable) teste2);

                startActivity(intent);
            }
        });
    }
}
