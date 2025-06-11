package com.igor.AppListaCurso0033.View;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.igor.AppListaCurso0033.CRUD.BancoDeDados;
import com.igor.AppListaCurso0033.Controller.Controller;
import com.igor.AppListaCurso0033.Model.Pessoa;
import com.igor.AppListaCurso0033.R;

public class MainActivity extends AppCompatActivity {
    private EditText Nome, Sobrenome, Curso, Telefone;
    private Button Salvar,Limpar,Finalizar;
    String primeiroNome,sobrenome,curso,telefone;
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Pessoa pessoa = new Pessoa();
        controller = new Controller(this);

        BancoDeDados bd = new BancoDeDados(this);
        SQLiteDatabase banco = bd.getWritableDatabase();

        controller.Buscar(pessoa);
        controller.toStrign();

        Nome = findViewById(R.id.PrimeiroNome);
        Sobrenome = findViewById(R.id.Sobrenome);
        Curso = findViewById(R.id.Curso);
        Telefone = findViewById(R.id.Telefone);
        Salvar = findViewById(R.id.btnSalvar);
        Limpar = findViewById(R.id.btnLimpar);
        Finalizar = findViewById(R.id.btnFinalizar);

        Nome.setText(pessoa.getNome());
        Sobrenome.setText(pessoa.getSobrenome());
        Curso.setText(pessoa.getCurso());
        Telefone.setText(pessoa.getTelefone());

        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues valores = new ContentValues();
                valores.put("NAME", pessoa.getNome());
                valores.put("LASTNAME", pessoa.getSobrenome());
                valores.put("CURSO", pessoa.getCurso());
                valores.put("FONE", pessoa.getTelefone());
                banco.insert("PESSOAS", null, valores);
                banco.close();
                pessoa.setNome(primeiroNome = Nome.getText().toString());
                pessoa.setSobrenome(sobrenome = Sobrenome.getText().toString());
                pessoa.setCurso(curso = Curso.getText().toString());
                pessoa.setTelefone(telefone = Telefone.getText().toString());
                controller.Salvar(pessoa);
            }
        });
        Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nome.setText("");
                Sobrenome.setText("");
                Curso.setText("");
                Telefone.setText("");
                controller.Limpar();
            }
        });
        Finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}