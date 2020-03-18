package br.com.alura.agenda.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Aluno implements Parcelable {

    private final String nome;
    private final String telefone;
    private final String email;

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    private Aluno(Parcel from) {
        nome = from.readString();
        telefone = from.readString();
        email = from.readString();
    }

    public static final Parcelable.Creator<Aluno> CREATOR = new Parcelable.Creator<Aluno>() {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(telefone);
        dest.writeString(email);
    }
}
