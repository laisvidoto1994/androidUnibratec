package layout.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unibratec.laisvidoto.applicationtablayoutviewpagerfragment.R;
import com.unibratec.laisvidoto.applicationtablayoutviewpagerfragment.Student;

public class Fragment_DetalheStudante extends Fragment
{

    private static final String EXTRA_STUDANTE = "param1";

    private Student mStudante;

    public static Fragment_DetalheStudante newInstance(Student student)
    {
        Fragment_DetalheStudante fragment = new Fragment_DetalheStudante();
        Bundle args = new Bundle();
        args.putParcelable(EXTRA_STUDANTE, student);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mStudante = getArguments().getParcelable(EXTRA_STUDANTE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_fragment__detalhe_studante, container, false);

        TextView txt = (TextView) view.findViewById(R.id.text_studante);

        txt.setText( mStudante.toString() );

        return view;
    }
}
