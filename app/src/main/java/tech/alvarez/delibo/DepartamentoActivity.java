package tech.alvarez.delibo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import tech.alvarez.delibo.adapters.PlatosAdapter;
import tech.alvarez.delibo.model.Departamento;

public class DepartamentoActivity extends AppCompatActivity {

    private static final Gson gson = new Gson();

    private RecyclerView platosRecyclerView;
    private PlatosAdapter platosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento);

        platosRecyclerView = (RecyclerView) findViewById(R.id.platosRecyclerView);
        platosRecyclerView.setHasFixedSize(true);
        platosRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        platosAdapter = new PlatosAdapter();
        platosRecyclerView.setAdapter(platosAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        cargarDatos();
    }

    private void cargarDatos() {
        if (getIntent().getExtras() != null) {
            String depto = getIntent().getStringExtra("depto");
            Departamento departamento = gson.fromJson(depto, Departamento.class);
            platosAdapter.setDataset(departamento.getPlatos());
        }
    }
}
