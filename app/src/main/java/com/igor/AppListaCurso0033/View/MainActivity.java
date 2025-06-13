package com.igor.AppListaCurso0033.View;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.igor.AppListaCurso0033.Controller.Controller;
import com.igor.AppListaCurso0033.Model.Pessoa;
import com.igor.AppListaCurso0033.R;

public class MainActivity extends AppCompatActivity {
    private EditText Nome, Sobrenome, Telefone;
    private Button Salvar,Limpar,Finalizar;
    String primeiroNome,sobrenome,telefone,selectedItem;
    Controller controller;
    Spinner spinner;

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


        controller.Buscar(pessoa);
        controller.toStrign();

        Nome = findViewById(R.id.PrimeiroNome);
        Sobrenome = findViewById(R.id.Sobrenome);
        Telefone = findViewById(R.id.Telefone);
        Salvar = findViewById(R.id.btnSalvar);
        Limpar = findViewById(R.id.btnLimpar);
        Finalizar = findViewById(R.id.btnFinalizar);
        spinner = findViewById(R.id.spinner_cursos);

        Nome.setText(pessoa.getNome());
        Sobrenome.setText(pessoa.getSobrenome());
        Telefone.setText(pessoa.getTelefone());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spinner_cursos,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        if (pessoa.getCurso() != null && !pessoa.getCurso().isEmpty()) {
            int spinnerPosition = adapter.getPosition(pessoa.getCurso());
            spinner.setSelection(spinnerPosition);
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = (String) parent.getItemAtPosition(position);

                Toast.makeText(getBaseContext(), "Selecionado: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setNome(primeiroNome = Nome.getText().toString());
                pessoa.setSobrenome(sobrenome = Sobrenome.getText().toString());
                pessoa.setCurso(selectedItem);
                pessoa.setTelefone(telefone = Telefone.getText().toString());
                controller.Salvar(pessoa);
            }
        });
        Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.setSelection(0);
                Nome.setText("");
                Sobrenome.setText("");
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