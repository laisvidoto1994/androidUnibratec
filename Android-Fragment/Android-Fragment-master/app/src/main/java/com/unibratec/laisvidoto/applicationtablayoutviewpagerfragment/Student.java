package com.unibratec.laisvidoto.applicationtablayoutviewpagerfragment;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable
{
    private String nome;
    private Number telefone;
    private String enderreco;
    private String foto;
    private String sitePessoal;
    private Double nota;

    protected Student(Parcel in) {
        nome = in.readString();
        enderreco = in.readString();
        foto = in.readString();
        sitePessoal = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public String toString()
    {
        return nome;
    }

    public Student(String nome)
    {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Number getTelefone() {
        return telefone;
    }

    public void setTelefone(Number telefone) {
        this.telefone = telefone;
    }

    public String getEnderreco() {
        return enderreco;
    }

    public void setEnderreco(String enderreco) {
        this.enderreco = enderreco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSitePessoal() {
        return sitePessoal;
    }

    public void setSitePessoal(String sitePessoal) {
        this.sitePessoal = sitePessoal;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(enderreco);
        parcel.writeString(foto);
        parcel.writeString(sitePessoal);
    }
}
