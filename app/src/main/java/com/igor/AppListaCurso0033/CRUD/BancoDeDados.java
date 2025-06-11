package com.igor.AppListaCurso0033.CRUD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.PreparedStatement;

public class BancoDeDados extends SQLiteOpenHelper {
    private static final String NOME_BANCO_DADOS = "ListaCurso.db";
    private static final int VERSAO_BANCO_DADOS = 1;
    public BancoDeDados(Context context){
        super(context, NOME_BANCO_DADOS, null, VERSAO_BANCO_DADOS);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String Criar_Tabela = "CREATE TABLE PESSOAS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "NAME TEXT," +
                 "LASTNAME TEXT," +
                 "CURSO TEXT," +
                 "FONE TEXT" + ");";
        db.execSQL(Criar_Tabela);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            String UPDATE_TABLE_QUERY = "ALTER TABLE MyTable ADD COLUMN new_column TEXT;";
            db.execSQL(UPDATE_TABLE_QUERY);
        }
    }
}
