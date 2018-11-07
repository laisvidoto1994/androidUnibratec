package com.unibratec.laisvidoto.applicationlistaalunos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student>
{

    public StudentAdapter(Context context, List<Student> object)
    {
        super( context, 0, object );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Student student = getItem(position);
        if (convertView == null)
        {
            //carrega um novo layout
            //convertView = LayoutInflater.from( getContext() ).inflate(R.layout.lista, null );
        }

        //ImageView imgLogo = (ImageView) convertView.findViewById(R.id.imgLogo);

        return super.getView(position, convertView, parent);
    }
}
