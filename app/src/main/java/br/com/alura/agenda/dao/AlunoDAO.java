package br.com.alura.agenda.dao;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds++);
        alunos.add(aluno);
    }

    public void edita(Aluno aluno) {
        Aluno alunoEncontrado = null;
        for(Aluno a : alunos) {
            if(a.getId() == aluno.getId())
                alunoEncontrado = a;
        }

        if(alunoEncontrado != null) {
            int posicaoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoAluno, aluno);
        }
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
