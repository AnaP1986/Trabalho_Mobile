package br.edu.fateczl.mobile_relatorio;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContratoFragment extends Fragment {

    private EditText etDataInicio, etDataFim;
    private Button btnInserir, btnModificar, btnExcluir, btnBuscar, btnListar;

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

        btnInserir.setOnClickListener(v -> {
            // Lógica para inserir contrato
            String dataInicio = etDataInicio.getText().toString();
            String dataFim = etDataFim.getText().toString();
            // Implementação da lógica de inserção
            Toast.makeText(getActivity(), "Contrato inserido", Toast.LENGTH_SHORT).show();
        });

        btnModificar.setOnClickListener(v -> {
            // Lógica para modificar contrato
            Toast.makeText(getActivity(), "Contrato modificado", Toast.LENGTH_SHORT).show();
        });

        btnExcluir.setOnClickListener(v -> {
            // Lógica para excluir contrato
            Toast.makeText(getActivity(), "Contrato excluído", Toast.LENGTH_SHORT).show();
        });

        btnBuscar.setOnClickListener(v -> {
            // Lógica para buscar contrato
            Toast.makeText(getActivity(), "Contrato buscado", Toast.LENGTH_SHORT).show();
        });

        btnListar.setOnClickListener(v -> {
            // Lógica para listar contratos
            Toast.makeText(getActivity(), "Contratos listados", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
