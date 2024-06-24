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
import br.edu.fateczl.mobile_relatorio.controller.ContratoController;
import br.edu.fateczl.mobile_relatorio.model.Contrato;

public class ContratoFragment extends Fragment {

    private EditText etDataInicio, etDataFim;
    private Button btnInserir, btnModificar, btnExcluir, btnBuscar, btnListar;
    private ContratoController controller;
    private RecyclerView rvContratos;
    private ContratoAdapter adapter;

    public ContratoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contrato, container, false);

        etDataInicio = view.findViewById(R.id.etDataInicioContrato);
        etDataFim = view.findViewById(R.id.etDataFimContrato);
        btnInserir = view.findViewById(R.id.btnInserirContrato);
        btnModificar = view.findViewById(R.id.btnModificarContrato);
        btnExcluir = view.findViewById(R.id.btnExcluirContrato);
        btnBuscar = view.findViewById(R.id.btnBuscarContrato);
        btnListar = view.findViewById(R.id.btnListarContrato);
        rvContratos = view.findViewById(R.id.rvContratos);

        controller = new ContratoController(getActivity());

        rvContratos.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ContratoAdapter();
        rvContratos.setAdapter(adapter);

        btnInserir.setOnClickListener(v -> {
            if (validateInputs()) {
                String dataInicio = etDataInicio.getText().toString();
                String dataFim = etDataFim.getText().toString();
                Contrato contrato = new Contrato();
                contrato.setDataInicio(dataInicio);
                contrato.setDataFim(dataFim);
                controller.insert(contrato);
                clearFields();
            }
        });

        btnModificar.setOnClickListener(v -> {
            if (validateInputs()) {
                String dataInicio = etDataInicio.getText().toString();
                String dataFim = etDataFim.getText().toString();
                Contrato contrato = controller.findByDatas(dataInicio, dataFim);
                if (contrato != null) {
                    contrato.setDataInicio(dataInicio);
                    contrato.setDataFim(dataFim);
                    controller.update(contrato);
                    clearFields();
                }
            }
        });

        btnExcluir.setOnClickListener(v -> {
            String dataInicio = etDataInicio.getText().toString();
            String dataFim = etDataFim.getText().toString();
            Contrato contrato = controller.findByDatas(dataInicio, dataFim);
            if (contrato != null) {
                controller.delete(contrato.getId());
                clearFields();
            }
        });

        btnBuscar.setOnClickListener(v -> {
            String dataInicio = etDataInicio.getText().toString();
            String dataFim = etDataFim.getText().toString();
            Contrato contrato = controller.findByDatas(dataInicio, dataFim);
            if (contrato != null) {
                etDataInicio.setText(contrato.getDataInicio());
                etDataFim.setText(contrato.getDataFim());
            } else {
                clearFields();
            }
        });

        btnListar.setOnClickListener(v -> {
            List<Contrato> contratos = controller.findAll();
            adapter.setContratos(contratos);
            adapter.notifyDataSetChanged();
        });

        return view;
    }

    private boolean validateInputs() {
        return !etDataInicio.getText().toString().isEmpty() && !etDataFim.getText().toString().isEmpty();
    }

    private void clearFields() {
        etDataInicio.setText("");
        etDataFim.setText("");
    }

    private class ContratoAdapter extends RecyclerView.Adapter<ContratoAdapter.ViewHolder> {

        private List<Contrato> contratos;

        public ContratoAdapter() {
            this.contratos = new ArrayList<>();
        }

        public void setContratos(List<Contrato> contratos) {
            this.contratos = contratos;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_acesso_relatorio, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Contrato contrato = contratos.get(position);
            holder.tvDataInicio.setText(contrato.getDataInicio());
            holder.tvDataFim.setText(contrato.getDataFim());
        }

        @Override
        public int getItemCount() {
            return contratos.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView tvDataInicio;
            public TextView tvDataFim;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvDataInicio = itemView.findViewById(R.id.tvDataAcesso);  // Atualize com o ID correto
                tvDataFim = itemView.findViewById(R.id.tvNumeroAcesso);  // Atualize com o ID correto
            }
        }
    }
}
