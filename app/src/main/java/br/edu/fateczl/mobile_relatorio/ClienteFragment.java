package br.edu.fateczl.mobile_relatorio;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ClienteFragment extends Fragment {

    private EditText etNome, etCPF, etEndereco;
    private Button btnInserir, btnModificar, btnExcluir, btnBuscar, btnListar;

    public ClienteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cliente, container, false);

        etNome = view.findViewById(R.id.etNomeCliente);
        etCPF = view.findViewById(R.id.etCPFCliente);
        etEndereco = view.findViewById(R.id.etEnderecoCliente);
        btnInserir = view.findViewById(R.id.btnInserirCliente);
        btnModificar = view.findViewById(R.id.btnModificarCliente);
        btnExcluir = view.findViewById(R.id.btnExcluirCliente);
        btnBuscar = view.findViewById(R.id.btnBuscarCliente);
        btnListar = view.findViewById(R.id.btnListarCliente);

        btnInserir.setOnClickListener(v -> {
            // Lógica para inserir cliente
            String nome = etNome.getText().toString();
            String cpf = etCPF.getText().toString();
            String endereco = etEndereco.getText().toString();
            // Implementação da lógica de inserção
            Toast.makeText(getActivity(), "Cliente inserido: " + nome, Toast.LENGTH_SHORT).show();
        });

        btnModificar.setOnClickListener(v -> {
            // Lógica para modificar cliente
            Toast.makeText(getActivity(), "Cliente modificado", Toast.LENGTH_SHORT).show();
        });

        btnExcluir.setOnClickListener(v -> {
            // Lógica para excluir cliente
            Toast.makeText(getActivity(), "Cliente excluído", Toast.LENGTH_SHORT).show();
        });

        btnBuscar.setOnClickListener(v -> {
            // Lógica para buscar cliente
            Toast.makeText(getActivity(), "Cliente buscado", Toast.LENGTH_SHORT).show();
        });

        btnListar.setOnClickListener(v -> {
            // Lógica para listar clientes
            Toast.makeText(getActivity(), "Clientes listados", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
