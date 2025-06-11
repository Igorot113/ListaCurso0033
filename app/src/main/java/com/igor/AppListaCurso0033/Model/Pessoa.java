package com.igor.AppListaCurso0033.Model;

public class Pessoa {
    private String Nome;
    private String Sobrenome;
    private String Curso;
    private String Telefone;

    public Pessoa(){}
    public Pessoa(String nome, String sobrenome, String curso, String telefone) {
        Nome = nome;
        Sobrenome = sobrenome;
        Curso = curso;
        Telefone = telefone;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "Nome='" + Nome + '\'' +
                ", Sobrenome='" + Sobrenome + '\'' +
                ", Curso='" + Curso + '\'' +
                ", Telefone='" + Telefone + '\'' +
                '}';
    }
}
