package com.example.diego.desafioandroid;

public class Shot {

    public int id;
    public String title;
    public String description;
    public int views_count;

    public Images images;
    public User user;

    public class Images{
        public  String hidpi;
        public String normal;
    }

    public class User {
        public int id;
        public String name;
        public String avatar_url;
    }
}
