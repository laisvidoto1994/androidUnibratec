package unibratec.com.edu.listview;

import android.graphics.drawable.Drawable;

/*
    arquivo de entidades que compoem Movie
*/
public class Movie {

    private String name;
    private Drawable logo;

    /*controller*/
    public Movie(String name, Drawable logo) {
        this.name = name;
        this.logo = logo;
    }

    /*get e sets*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getLogo() {
        return logo;
    }

    public void setLogo(Drawable logo) {
        this.logo = logo;
    }
}
