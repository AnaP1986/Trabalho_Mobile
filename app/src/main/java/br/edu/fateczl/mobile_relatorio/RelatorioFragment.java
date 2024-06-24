package br.edu.fateczl.mobile_relatorio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

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
import br.edu.fateczl.mobile_relatorio.controller.RelatorioController;
import br.edu.fateczl.mobile_relatorio.model.Relatorio;

public class RelatorioFragment extends Fragment {

    private EditText etTituloRelatorio, etResumoRelatorio;
    private Button btnInserir, btnModificar, btnExcluir, btnBuscar, btnListar;
    private RelatorioController controller;
    private RecyclerView rvRelatorios;
    private RelatorioAdapter adapter;

    public RelatorioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_relatorio, container, false);

        etTituloRelatorio = view.findViewById(R.id.etTituloRelatorio);
        etResumoRelatorio = view.findViewById(R.id.etResumoRelatorio);
        btnInserir = view.findViewById(R.id.btnInserirRelatorio);
        btnModificar = view.findViewById(R.id.btnModificarRelatorio);
        btnExcluir = view.findViewById(R.id.btnExcluirRelatorio);
        btnBuscar = view.findViewById(R.id.btnBuscarRelatorio);
        btnListar = view.findViewById(R.id.btnListarRelatorio);
        rvRelatorios = view.findViewById(R.id.rvRelatorios);

        controller = new RelatorioController(getActivity());

        rvRelatorios.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RelatorioAdapter();
        rvRelatorios.setAdapter(adapter);

        btnInserir.setOnClickListener(v -> {
            if (validateInputs()) {
                String titulo = etTituloRelatorio.getText().toString();
                String resumo = etResumoRelatorio.getText().toString();
                Relatorio relatorio = new Relatorio();
                relatorio.setTitulo(titulo);
                relatorio.setResumo(resumo);
                controller.insert(relatorio);
                clearFields();
            }
        });

        btnModificar.setOnClickListener(v -> {
            if (validateInputs()) {
                String titulo = etTituloRelatorio.getText().toString();
                String resumo = etResumoRelatorio.getText().toString();
                Relatorio relatorio = controller.findByTitulo(titulo);
                if (relatorio != null) {
                    relatorio.setTitulo(titulo);
                    relatorio.setResumo(resumo);
                    controller.update(relatorio);
                    clearFields();
                }
            }
        });

        btnExcluir.setOnClickListener(v -> {
            String titulo = etTituloRelatorio.getText().toString();
            Relatorio relatorio = controller.findByTitulo(titulo);
            if (relatorio != null) {
                controller.delete(relatorio.getId());
                clearFields();
            }
        });

        btnBuscar.setOnClickListener(v -> {
            String titulo = etTituloRelatorio.getText().toString();
            Relatorio relatorio = controller.findByTitulo(titulo);
            if (relatorio != null) {
                etTituloRelatorio.setText(relatorio.getTitulo());
                etResumoRelatorio.setText(relatorio.getResumo());
            } else {
                clearFields();
            }
        });

        btnListar.setOnClickListener(v -> {
            List<Relatorio> relatorios = controller.findAll();
            adapter.setRelatorios(relatorios);
            adapter.notifyDataSetChanged();
        });

        return view;
    }

    private boolean validateInputs() {
        return !etTituloRelatorio.getText().toString().isEmpty() && !etResumoRelatorio.getText().toString().isEmpty();
    }

    private void clearFields() {
        etTituloRelatorio.setText("");
        etResumoRelatorio.setText("");
    }

    private class RelatorioAdapter extends RecyclerView.Adapter<RelatorioAdapter.ViewHolder> {

        private List<Relatorio> relatorios;

        public RelatorioAdapter() {
            this.relatorios = new ArrayList<>();
        }

        public void setRelatorios(List<Relatorio> relatorios) {
            this.relatorios = relatorios;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_acesso_relatorio, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Relatorio relatorio = relatorios.get(position);
            holder.tvTituloRelatorio.setText(relatorio.getTitulo());
            holder.tvResumoRelatorio.setText(relatorio.getResumo());
        }

        @Override
        public int getItemCount() {
            return relatorios.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView tvTituloRelatorio;
            public TextView tvResumoRelatorio;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvTituloRelatorio = itemView.findViewById(R.id.tvDataAcesso);  // Atualize com o ID correto
                tvResumoRelatorio = itemView.findViewById(R.id.tvNumeroAcesso);  // Atualize com o ID correto
            }
        }
    }
}
