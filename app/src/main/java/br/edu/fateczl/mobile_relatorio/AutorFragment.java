package br.edu.fateczl.mobile_relatorio;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AutorFragment extends Fragment {

    private EditText etNome, etApelido;
    private CheckBox cbAnonimo;
    private Button btnInserir, btnModificar, btnExcluir, btnBuscar, btnListar;

    public AutorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_autor, container, false);

        etNome = view.findViewById(R.id.etNomeAutor);
        etApelido = view.findViewById(R.id.etApelidoAutor);
        cbAnonimo = view.findViewById(R.id.cbAnonimoAutor);
        btnInserir = view.findViewById(R.id.btnInserirAutor);
        btnModificar = view.findViewById(R.id.btnModificarAutor);
        btnExcluir = view.findViewById(R.id.btnExcluirAutor);
        btnBuscar = view.findViewById(R.id.btnBuscarAutor);
        btnListar = view.findViewById(R.id.btnListarAutor);

        btnInserir.setOnClickListener(v -> {
            // Lógica para inserir autor
            String nome = etNome.getText().toString();
            String apelido = etApelido.getText().toString();
            boolean anonimo = cbAnonimo.isChecked();
            // Implementação da lógica de inserção
            Toast.makeText(getActivity(), "Autor inserido: " + nome, Toast.LENGTH_SHORT).show();
        });

        btnModificar.setOnClickListener(v -> {
            // Lógica para modificar autor
            Toast.makeText(getActivity(), "Autor modificado", Toast.LENGTH_SHORT).show();
        });

        btnExcluir.setOnClickListener(v -> {
            // Lógica para excluir autor
            Toast.makeText(getActivity(), "Autor excluído", Toast.LENGTH_SHORT).show();
        });

        btnBuscar.setOnClickListener(v -> {
            // Lógica para buscar autor
            Toast.makeText(getActivity(), "Autor buscado", Toast.LENGTH_SHORT).show();
        });

        btnListar.setOnClickListener(v -> {
            // Lógica para listar autores
            Toast.makeText(getActivity(), "Autores listados", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
