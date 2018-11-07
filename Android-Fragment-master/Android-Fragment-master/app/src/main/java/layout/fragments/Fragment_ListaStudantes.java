package layout.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.unibratec.laisvidoto.applicationtablayoutviewpagerfragment.R;
import com.unibratec.laisvidoto.applicationtablayoutviewpagerfragment.Student;

import java.util.ArrayList;
import java.util.List;


public class Fragment_ListaStudantes extends Fragment
{

    List<Student> mStudantes;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mStudantes = new ArrayList<>();
        mStudantes.add( new Student("Laís") );
        mStudantes.add( new Student("Edna") );
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View layout = inflater.inflate(R.layout.fragment_fragment__lista_studantes, container, false);
        ListView listView = (ListView)layout.findViewById(R.id.fragmentLista);
        listView.setAdapter( new ArrayAdapter<Student>( getActivity(), android.R.layout.simple_list_item_1, mStudantes) );

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Student student = mStudantes.get(position);
                if(getActivity() instanceof CliqueNoStudanteLister)
                {
                    CliqueNoStudanteLister cliqueNoStudanteLister = (CliqueNoStudanteLister)getActivity();
                    cliqueNoStudanteLister.studanteFoiClicado(student);
                }
            }
        });
        return layout;
    }

    public interface CliqueNoStudanteLister
    {
        void studanteFoiClicado(Student student);
    }

}
