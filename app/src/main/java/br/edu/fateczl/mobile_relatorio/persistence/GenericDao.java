package br.edu.fateczl.mobile_relatorio.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GenericDao extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "relatorios.db";
    private static final int DATABASE_VERSION = 1;

    public GenericDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Autor (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, apelido TEXT, isAnonimo INTEGER)");
        db.execSQL("CREATE TABLE Cliente (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, cpf TEXT, endereco TEXT)");
        db.execSQL("CREATE TABLE Contrato (id INTEGER PRIMARY KEY AUTOINCREMENT, dataInicio TEXT, dataFim TEXT, clienteId INTEGER)");
        db.execSQL("CREATE TABLE Relatorio (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, resumo TEXT, texto TEXT, isPublico INTEGER, autorId INTEGER)");
        db.execSQL("CREATE TABLE AcessoRelatorio (id INTEGER PRIMARY KEY AUTOINCREMENT, dataAcesso TEXT, numeroAcesso INTEGER, clienteId INTEGER, relatorioId INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Autor");
        db.execSQL("DROP TABLE IF EXISTS Cliente");
        db.execSQL("DROP TABLE IF EXISTS Contrato");
        db.execSQL("DROP TABLE IF EXISTS Relatorio");
        db.execSQL("DROP TABLE IF EXISTS AcessoRelatorio");
        onCreate(db);
    }
}
