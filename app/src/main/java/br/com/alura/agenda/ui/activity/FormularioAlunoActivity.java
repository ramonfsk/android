package br.com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo aluno";
    private EditText txtNome;
    private EditText txtTelefone;
    private EditText txtEmail;
    final AlunoDAO dao = new AlunoDAO();
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APPBAR);

        inicializacaoDosCampos();
        configuraBotaoSalvar();

        Intent dados = getIntent();
        if(dados.hasExtra("aluno")) {
            aluno = dados.getParcelableExtra("aluno");
            txtNome.setText(aluno.getNome());
            txtTelefone.setText(aluno.getTelefone());
            txtEmail.setText(aluno.getEmail());
        } else aluno = new Aluno();
    }

    private void configuraBotaoSalvar() {
        Button btnSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preencheAluno();
                if(aluno.temIdValido())
                    dao.edita(aluno);
                else
                    dao.salva(aluno);

                finish();
            }
        });
    }

    private void inicializacaoDosCampos() {
        txtNome = findViewById(R.id.activity_formulario_aluno_nome);
        txtTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        txtEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void preencheAluno() {
        String nome = txtNome.getText().toString();
        String telefone = txtTelefone.getText().toString();
        String email = txtEmail.getText().toString();

        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
    }
}
