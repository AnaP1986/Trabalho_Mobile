package br.edu.fateczl.mobile_relatorio.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GenericDao extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mobile_relatorio.db";
    private static final int DATABASE_VERSION = 1;

    public GenericDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_CLIENTE = "CREATE TABLE cliente (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " +
                "cpf TEXT, " +
                "endereco TEXT)";

        String CREATE_TABLE_CONTRATO = "CREATE TABLE contrato (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "dataInicio TEXT, " +
                "dataFim TEXT)";

        String CREATE_TABLE_RELATORIO = "CREATE TABLE relatorio (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "titulo TEXT, " +
                "resumo TEXT)";

        String CREATE_TABLE_ACESSO_RELATORIO = "CREATE TABLE acesso_relatorio (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "dataAcesso TEXT, " +
                "numeroAcesso INTEGER, " +
                "clienteId INTEGER, " +
                "relatorioId INTEGER, " +
                "FOREIGN KEY (clienteId) REFERENCES cliente(id), " +
                "FOREIGN KEY (relatorioId) REFERENCES relatorio(id))";

        String CREATE_TABLE_AUTOR = "CREATE TABLE autor (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " +
                "sobrenome TEXT)";

        db.execSQL(CREATE_TABLE_CLIENTE);
        db.execSQL(CREATE_TABLE_CONTRATO);
        db.execSQL(CREATE_TABLE_RELATORIO);
        db.execSQL(CREATE_TABLE_ACESSO_RELATORIO);
        db.execSQL(CREATE_TABLE_AUTOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS cliente");
        db.execSQL("DROP TABLE IF EXISTS contrato");
        db.execSQL("DROP TABLE IF EXISTS relatorio");
        db.execSQL("DROP TABLE IF EXISTS acesso_relatorio");
        db.execSQL("DROP TABLE IF EXISTS autor");
        onCreate(db);
    }
}
