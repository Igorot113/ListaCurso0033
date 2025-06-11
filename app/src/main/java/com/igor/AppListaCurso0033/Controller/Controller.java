package com.igor.AppListaCurso0033.Controller;
import android.content.SharedPreferences;
import android.util.Log;
import com.igor.AppListaCurso0033.Model.Pessoa;
import com.igor.AppListaCurso0033.View.MainActivity;
public class Controller {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    Pessoa pessoa;
    MainActivity mainActivity;
    public static final String NOME_PREFERENCES = "Lista_Curso_0033";
    public  Controller(MainActivity mainActivity){
        sp = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        editor = sp.edit();
    }
    public void Salvar(Pessoa pessoa){
        editor.putString("PrimeiroNome", pessoa.getNome());
        editor.putString("Sobrenome", pessoa.getSobrenome());
        editor.putString("Curso",pessoa.getCurso());
        editor.putString("Telefone", pessoa.getTelefone());
        editor.commit();

        Log.d("MVC_Controller", "Dados salvos: " +pessoa.toString());
    }
    public void Limpar(){
        editor.clear();
        editor.commit();
    }

    public Pessoa Buscar(Pessoa pessoa){
        pessoa.setNome(sp.getString("PrimeiroNome", "NA"));
        pessoa.setSobrenome(sp.getString("Sobrenome", "NA"));
        pessoa.setCurso(sp.getString("Curso", "NA"));
        pessoa.setTelefone(sp.getString("Telefone","NA"));
        return pessoa;
    }

    public void toStrign(){
        Log.d("MVC_Controller", "Controller Iniciado");
    }
}
