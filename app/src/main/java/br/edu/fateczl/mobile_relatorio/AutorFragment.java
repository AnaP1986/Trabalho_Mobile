package br.edu.fateczl.mobile_relatorio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
import br.edu.fateczl.mobile_relatorio.controller.AutorController;
import br.edu.fateczl.mobile_relatorio.model.Autor;

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
import br.edu.fateczl.mobile_relatorio.controller.AutorController;
import br.edu.fateczl.mobile_relatorio.model.Autor;

public class AutorFragment extends Fragment {

    private EditText etNomeAutor, etSobrenomeAutor;
    private Button btnInserir, btnModificar, btnExcluir, btnBuscar, btnListar;
    private AutorController controller;
    private RecyclerView rvAutores;
    private AutorAdapter adapter;

    public AutorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_autor, container, false);

        etNomeAutor = view.findViewById(R.id.etNomeAutor);
        etSobrenomeAutor = view.findViewById(R.id.etSobrenomeAutor);
        btnInserir = view.findViewById(R.id.btnInserirAutor);
        btnModificar = view.findViewById(R.id.btnModificarAutor);
        btnExcluir = view.findViewById(R.id.btnExcluirAutor);
        btnBuscar = view.findViewById(R.id.btnBuscarAutor);
        btnListar = view.findViewById(R.id.btnListarAutor);
        rvAutores = view.findViewById(R.id.rvAutores);

        controller = new AutorController(getActivity());

        rvAutores.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AutorAdapter();
        rvAutores.setAdapter(adapter);

        btnInserir.setOnClickListener(v -> {
            if (validateInputs()) {
                String nome = etNomeAutor.getText().toString();
                String sobrenome = etSobrenomeAutor.getText().toString();
                Autor autor = new Autor();
                autor.setNome(nome);
                autor.setSobrenome(sobrenome);
                controller.insert(autor);
                clearFields();
            }
        });

        btnModificar.setOnClickListener(v -> {
            if (validateInputs()) {
                String nome = etNomeAutor.getText().toString();
                String sobrenome = etSobrenomeAutor.getText().toString();
                Autor autor = controller.findByNomeSobrenome(nome, sobrenome);
                if (autor != null) {
                    autor.setNome(nome);
                    autor.setSobrenome(sobrenome);
                    controller.update(autor);
                    clearFields();
                }
            }
        });

        btnExcluir.setOnClickListener(v -> {
            String nome = etNomeAutor.getText().toString();
            String sobrenome = etSobrenomeAutor.getText().toString();
            Autor autor = controller.findByNomeSobrenome(nome, sobrenome);
            if (autor != null) {
                controller.delete(autor.getId());
                clearFields();
            }
        });

        btnBuscar.setOnClickListener(v -> {
            String nome = etNomeAutor.getText().toString();
            String sobrenome = etSobrenomeAutor.getText().toString();
            Autor autor = controller.findByNomeSobrenome(nome, sobrenome);
            if (autor != null) {
                etNomeAutor.setText(autor.getNome());
                etSobrenomeAutor.setText(autor.getSobrenome());
            } else {
                clearFields();
            }
        });

        btnListar.setOnClickListener(v -> {
            List<Autor> autores = controller.findAll();
            adapter.setAutores(autores);
            adapter.notifyDataSetChanged();
        });

        return view;
    }

    private boolean validateInputs() {
        return !etNomeAutor.getText().toString().isEmpty() && !etSobrenomeAutor.getText().toString().isEmpty();
    }

    private void clearFields() {
        etNomeAutor.setText("");
        etSobrenomeAutor.setText("");
    }

    private class AutorAdapter extends RecyclerView.Adapter<AutorAdapter.ViewHolder> {

        private List<Autor> autores;

        public AutorAdapter() {
            this.autores = new ArrayList<>();
        }

        public void setAutores(List<Autor> autores) {
            this.autores = autores;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_acesso_relatorio, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Autor autor = autores.get(position);
            holder.tvNomeAutor.setText(autor.getNome());
            holder.tvSobrenomeAutor.setText(autor.getSobrenome());
        }

        @Override
        public int getItemCount() {
            return autores.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView tvNomeAutor;
            public TextView tvSobrenomeAutor;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvNomeAutor = itemView.findViewById(R.id.tvDataAcesso);  // Atualize com o ID correto
                tvSobrenomeAutor = itemView.findViewById(R.id.tvNumeroAcesso);  // Atualize com o ID correto
            }
        }
    }
}
