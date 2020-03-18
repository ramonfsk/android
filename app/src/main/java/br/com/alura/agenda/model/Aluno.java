package br.com.alura.agenda.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Aluno implements Parcelable {

    private int id = 0;
    private String nome;
    private String telefone;
    private String email;

    public Aluno() {};

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    private Aluno(Parcel from) {
        id = from.readInt();
        nome = from.readString();
        telefone = from.readString();
        email = from.readString();
    }

    public static final Creator<Aluno> CREATOR = new Creator<Aluno>() {
        public Aluno createFromParcel(Parcel source) {
            return new Aluno(source);
        }
        public Aluno[] newArray(int size) {
            return new Aluno[size];
        }
    };

    @NonNull
    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nome);
        dest.writeString(telefone);
        dest.writeString(email);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean temIdValido() {
        return this.id > 1 ? true : false;
    }
}
