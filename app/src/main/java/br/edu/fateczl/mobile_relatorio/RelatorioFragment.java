package br.edu.fateczl.mobile_relatorio;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import android.widget.Toast;


public class RelatorioFragment extends Fragment {

    private EditText etTitulo, etResumo, etTexto;
    private Button btnInserir, btnModificar, btnExcluir, btnBuscar, btnListar;

    public RelatorioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_relatorio, container, false);

        etTitulo = view.findViewById(R.id.etTituloRelatorio);
        etResumo = view.findViewById(R.id.etResumoRelatorio);
        etTexto = view.findViewById(R.id.etTextoRelatorio);
        btnInserir = view.findViewById(R.id.btnInserirRelatorio);
        btnModificar = view.findViewById(R.id.btnModificarRelatorio);
        btnExcluir = view.findViewById(R.id.btnExcluirRelatorio);
        btnBuscar = view.findViewById(R.id.btnBuscarRelatorio);
        btnListar = view.findViewById(R.id.btnListarRelatorio);

        btnInserir.setOnClickListener(v -> {
            // Lógica para inserir relatório
            String titulo = etTitulo.getText().toString();
            String resumo = etResumo.getText().toString();
            String texto = etTexto.getText().toString();
            // Implementação da lógica de inserção
            Toast.makeText(getActivity(), "Relatório inserido: " + titulo, Toast.LENGTH_SHORT).show();
        });

        btnModificar.setOnClickListener(v -> {
            // Lógica para modificar relatório
            Toast.makeText(getActivity(), "Relatório modificado", Toast.LENGTH_SHORT).show();
        });

        btnExcluir.setOnClickListener(v -> {
            // Lógica para excluir relatório
            Toast.makeText(getActivity(), "Relatório excluído", Toast.LENGTH_SHORT).show();
        });

        btnBuscar.setOnClickListener(v -> {
            // Lógica para buscar relatório
            Toast.makeText(getActivity(), "Relatório buscado", Toast.LENGTH_SHORT).show();
        });

        btnListar.setOnClickListener(v -> {
            // Lógica para listar relatórios
            Toast.makeText(getActivity(), "Relatórios listados", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
