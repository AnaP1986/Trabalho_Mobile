package br.edu.fateczl.mobile_relatorio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.controller.ClienteController;
import br.edu.fateczl.mobile_relatorio.model.Cliente;

public class ClienteFragment extends Fragment {

    private EditText etNomeCliente, etCpfCliente, etEnderecoCliente;
    private Button btnInserir, btnModificar, btnExcluir, btnBuscar, btnListar;
    private ClienteController controller;
    private RecyclerView rvClientes;
    private ClienteAdapter adapter;

    public ClienteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cliente, container, false);

        etNomeCliente = view.findViewById(R.id.etNomeCliente);
        etCpfCliente = view.findViewById(R.id.etCpfCliente);
        etEnderecoCliente = view.findViewById(R.id.etEnderecoCliente);
        btnInserir = view.findViewById(R.id.btnInserirCliente);
        btnModificar = view.findViewById(R.id.btnModificarCliente);
        btnExcluir = view.findViewById(R.id.btnExcluirCliente);
        btnBuscar = view.findViewById(R.id.btnBuscarCliente);
        btnListar = view.findViewById(R.id.btnListarCliente);
        rvClientes = view.findViewById(R.id.rvClientes);

        controller = new ClienteController(getActivity());

        rvClientes.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ClienteAdapter();
        rvClientes.setAdapter(adapter);

        btnInserir.setOnClickListener(v -> {
            if (validateInputs()) {
                String nome = etNomeCliente.getText().toString();
                String cpf = etCpfCliente.getText().toString();
                String endereco = etEnderecoCliente.getText().toString();
                Cliente cliente = new Cliente();
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setEndereco(endereco);
                controller.insert(cliente);
                clearFields();
            }
        });

        btnModificar.setOnClickListener(v -> {
            if (validateInputs()) {
                String nome = etNomeCliente.getText().toString();
                String cpf = etCpfCliente.getText().toString();
                String endereco = etEnderecoCliente.getText().toString();
                Cliente cliente = controller.findByCpf(cpf);
                if (cliente != null) {
                    cliente.setNome(nome);
                    cliente.setEndereco(endereco);
                    controller.update(cliente);
                    clearFields();
                }
            }
        });

        btnExcluir.setOnClickListener(v -> {
            String cpf = etCpfCliente.getText().toString();
            Cliente cliente = controller.findByCpf(cpf);
            if (cliente != null) {
                controller.delete(cliente.getId());
                clearFields();
            }
        });

        btnBuscar.setOnClickListener(v -> {
            String cpf = etCpfCliente.getText().toString();
            Cliente cliente = controller.findByCpf(cpf);
            if (cliente != null) {
                etNomeCliente.setText(cliente.getNome());
                etEnderecoCliente.setText(cliente.getEndereco());
            } else {
                clearFields();
            }
        });

        btnListar.setOnClickListener(v -> {
            List<Cliente> clientes = controller.findAll();
            adapter.setClientes(clientes);
            adapter.notifyDataSetChanged();
        });

        return view;
    }

    private boolean validateInputs() {
        return !etNomeCliente.getText().toString().isEmpty() &&
                !etCpfCliente.getText().toString().isEmpty() &&
                !etEnderecoCliente.getText().toString().isEmpty();
    }

    private void clearFields() {
        etNomeCliente.setText("");
        etCpfCliente.setText("");
        etEnderecoCliente.setText("");
    }

    private class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolder> {

        private List<Cliente> clientes;

        public ClienteAdapter() {
            this.clientes = new ArrayList<>();
        }

        public void setClientes(List<Cliente> clientes) {
            this.clientes = clientes;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_acesso_relatorio, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Cliente cliente = clientes.get(position);
            holder.tvNomeCliente.setText(cliente.getNome());
            holder.tvCpfCliente.setText(cliente.getCpf());
            holder.tvEnderecoCliente.setText(cliente.getEndereco());
        }

        @Override
        public int getItemCount() {
            return clientes.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView tvNomeCliente;
            public TextView tvCpfCliente;
            public TextView tvEnderecoCliente;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvNomeCliente = itemView.findViewById(R.id.tvDataAcesso);  // Atualize com o ID correto
                tvCpfCliente = itemView.findViewById(R.id.tvNumeroAcesso);  // Atualize com o ID correto
                tvEnderecoCliente = itemView.findViewById(R.id.tvEnderecoCliente);  // Adicione um TextView no layout para Endereço
            }
        }
    }
}
