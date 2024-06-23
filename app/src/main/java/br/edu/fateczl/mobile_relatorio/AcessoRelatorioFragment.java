package br.edu.fateczl.mobile_relatorio;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AcessoRelatorioFragment extends Fragment {

    private EditText etDataAcesso, etNumeroAcesso;
    private Button btnInserir, btnModificar, btnExcluir, btnBuscar, btnListar;

    public AcessoRelatorioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_acesso_relatorio, container, false);

        etDataAcesso = view.findViewById(R.id.etDataAcessoRelatorio);
        etNumeroAcesso = view.findViewById(R.id.etNumeroAcessoRelatorio);
        btnInserir = view.findViewById(R.id.btnInserirAcessoRelatorio);
        btnModificar = view.findViewById(R.id.btnModificarAcessoRelatorio);
        btnExcluir = view.findViewById(R.id.btnExcluirAcessoRelatorio);
        btnBuscar = view.findViewById(R.id.btnBuscarAcessoRelatorio);
        btnListar = view.findViewById(R.id.btnListarAcessoRelatorio);

        btnInserir.setOnClickListener(v -> {
            // Lógica para inserir acesso ao relatório
            String dataAcesso = etDataAcesso.getText().toString();
            String numeroAcesso = etNumeroAcesso.getText().toString();
            // Implementação da lógica de inserção
            Toast.makeText(getActivity(), "Acesso ao relatório inserido", Toast.LENGTH_SHORT).show();
        });

        btnModificar.setOnClickListener(v -> {
            // Lógica para modificar acesso ao relatório
            Toast.makeText(getActivity(), "Acesso ao relatório modificado", Toast.LENGTH_SHORT).show();
        });

        btnExcluir.setOnClickListener(v -> {
            // Lógica para excluir acesso ao relatório
            Toast.makeText(getActivity(), "Acesso ao relatório excluído", Toast.LENGTH_SHORT).show();
        });

        btnBuscar.setOnClickListener(v -> {
            // Lógica para buscar acesso ao relatório
            Toast.makeText(getActivity(), "Acesso ao relatório buscado", Toast.LENGTH_SHORT).show();
        });

        btnListar.setOnClickListener(v -> {
            // Lógica para listar acessos aos relatórios
            Toast.makeText(getActivity(), "Acessos aos relatórios listados", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
