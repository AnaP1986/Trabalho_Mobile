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

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.edu.fateczl.mobile_relatorio.controller.AcessoRelatorioController;
import br.edu.fateczl.mobile_relatorio.model.AcessoRelatorio;
import java.util.ArrayList;

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
import br.edu.fateczl.mobile_relatorio.controller.AcessoRelatorioController;
import br.edu.fateczl.mobile_relatorio.model.AcessoRelatorio;

public class AcessoRelatorioFragment extends Fragment {

    private EditText etDataAcesso, etNumeroAcesso;
    private Button btnInserir, btnModificar, btnExcluir, btnBuscar, btnListar;
    private AcessoRelatorioController controller;
    private RecyclerView rvAcessosRelatorio;
    private AcessoRelatorioAdapter adapter;

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
        rvAcessosRelatorio = view.findViewById(R.id.rvAcessosRelatorio);

        controller = new AcessoRelatorioController(getActivity());

        rvAcessosRelatorio.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AcessoRelatorioAdapter();
        rvAcessosRelatorio.setAdapter(adapter);

        btnInserir.setOnClickListener(v -> {
            if (validateInputs()) {
                String dataAcesso = etDataAcesso.getText().toString();
                int numeroAcesso = Integer.parseInt(etNumeroAcesso.getText().toString());
                AcessoRelatorio acessoRelatorio = new AcessoRelatorio();
                acessoRelatorio.setDataAcesso(dataAcesso);
                acessoRelatorio.setNumeroAcesso(numeroAcesso);
                // Adicionar clienteId e relatorioId conforme necessário
                controller.insert(acessoRelatorio);
                clearFields();
            }
        });

        btnModificar.setOnClickListener(v -> {
            if (validateInputs()) {
                int id = Integer.parseInt(etNumeroAcesso.getText().toString());
                AcessoRelatorio acessoRelatorio = new AcessoRelatorio();
                // Atualizar outras informações conforme necessário
                controller.update(acessoRelatorio);
                clearFields();
            }
        });

        btnExcluir.setOnClickListener(v -> {
            int id = Integer.parseInt(etNumeroAcesso.getText().toString());
            controller.delete(id);
            clearFields();
        });

        btnBuscar.setOnClickListener(v -> {
            int id = Integer.parseInt(etNumeroAcesso.getText().toString());
            AcessoRelatorio acessoRelatorio = controller.findById(id);
            if (acessoRelatorio != null) {
                etDataAcesso.setText(acessoRelatorio.getDataAcesso());
                etNumeroAcesso.setText(String.valueOf(acessoRelatorio.getNumeroAcesso()));
                // Exibir outras informações conforme necessário
            } else {
                clearFields();
            }
        });

        btnListar.setOnClickListener(v -> {
            List<AcessoRelatorio> acessosRelatorio = controller.findAll();
            adapter.setAcessosRelatorio(acessosRelatorio);
            adapter.notifyDataSetChanged();
        });

        return view;
    }

    private boolean validateInputs() {
        if (etDataAcesso.getText().toString().isEmpty() || etNumeroAcesso.getText().toString().isEmpty()) {
            // Todos os campos são obrigatórios
            return false;
        }
        return true;
    }

    private void clearFields() {
        etDataAcesso.setText("");
        etNumeroAcesso.setText("");
    }

    private class AcessoRelatorioAdapter extends RecyclerView.Adapter<AcessoRelatorioAdapter.ViewHolder> {

        private List<AcessoRelatorio> acessosRelatorio;

        public AcessoRelatorioAdapter() {
            this.acessosRelatorio = new ArrayList<>();
        }

        public void setAcessosRelatorio(List<AcessoRelatorio> acessosRelatorio) {
            this.acessosRelatorio = acessosRelatorio;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_acesso_relatorio, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            AcessoRelatorio acessoRelatorio = acessosRelatorio.get(position);
            holder.tvDataAcesso.setText(acessoRelatorio.getDataAcesso());
            holder.tvNumeroAcesso.setText(String.valueOf(acessoRelatorio.getNumeroAcesso()));
        }

        @Override
        public int getItemCount() {
            return acessosRelatorio.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView tvDataAcesso;
            public TextView tvNumeroAcesso;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvDataAcesso = itemView.findViewById(R.id.tvDataAcesso);
                tvNumeroAcesso = itemView.findViewById(R.id.tvNumeroAcesso);
            }
        }
    }
}
