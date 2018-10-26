package unibratec.com.edu.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> list;// criando

    public MovieAdapter(Context context, ArrayList<Movie> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Movie currentMovie = list.get(position);
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);

            // chamando arquivo de layout que tem o como eu quero que cada item da lista seja mostrado
            convertView = inflater.inflate(R.layout.listview_line, null);

            holder = new ViewHolder();
            holder.logo = convertView.findViewById(R.id.img_logo);
            holder.name = convertView.findViewById(R.id.text_name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.logo.setImageDrawable(currentMovie.getLogo());
        holder.name.setText(currentMovie.getName());

        return convertView;
    }

    private static class ViewHolder {
        ImageView logo;
        TextView name;
    }
}
