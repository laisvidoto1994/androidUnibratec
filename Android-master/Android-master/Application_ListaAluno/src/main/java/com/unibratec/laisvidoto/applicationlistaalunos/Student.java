package com.unibratec.laisvidoto.applicationlistaalunos;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable
{
    private String nome;
    private int telefone;
    private String endereco;
    private String foto;
    private String site_Pessoal;
    private double nota;

    public Student(String nome, int telefone, String endereco, String foto, String site_Pessoal, double nota)
    {
        this.nome         = nome;
        this.telefone     = telefone;
        this.endereco     = endereco;
        this.foto         = foto;
        this.site_Pessoal = site_Pessoal;
        this.nota         = nota;
    }

    public Student(){};

    protected Student(Parcel in)
    {
        nome         = in.readString();
        telefone     = in.readInt();
        endereco     = in.readString();
        foto         = in.readString();
        site_Pessoal = in.readString();
        nota         = in.readDouble();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>()
    {
        @Override
        public Student createFromParcel(Parcel in)
        {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size)
        {
            return new Student[size];
        }
    };

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(nome);
        parcel.writeInt(telefone);
        parcel.writeString(endereco);
        parcel.writeString(foto);
        parcel.writeString(site_Pessoal);
        parcel.writeDouble(nota);
    }

   @Override
    public String toString()
    {
        return nome +" "+ telefone +" "+ endereco +" "+ foto +" "+ site_Pessoal +" "+ nota;
    }

    public String getNome() {        return nome;    }
    public void setNome(String nome) {         this.nome = nome;     }

    public int getTelefone() {         return telefone;     }
    public void setTelefone(int telefone) {         this.telefone = telefone;     }

    public String getEndereco() {        return endereco;    }
    public void setEndereco(String endereco) {         this.endereco = endereco;    }

    public String getFoto() {         return foto;    }

    public void setFoto(String foto) {        this.foto = foto;    }

    public String getSite_Pessoal() {        return site_Pessoal;    }
    public void setSite_Pessoal(String site_Pessoal) {        site_Pessoal = site_Pessoal;    }

    public double getNota() {         return nota;     }
    public void setNota(double nota) {         this.nota = nota;     }


}
