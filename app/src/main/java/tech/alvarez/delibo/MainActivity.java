package tech.alvarez.delibo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import tech.alvarez.delibo.adapters.DepartamentosAdapter;
import tech.alvarez.delibo.model.Departamento;
import tech.alvarez.delibo.model.Pais;
import tech.alvarez.delibo.util.Util;

public class MainActivity extends AppCompatActivity implements DepartamentosAdapter.OnDepartamentoSelectedListener {

    private static final Gson gson = new Gson();

    private RecyclerView departamentosRecyclerView;
    private DepartamentosAdapter departamentosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        departamentosRecyclerView = (RecyclerView) findViewById(R.id.departamentosRecyclerView);
        departamentosRecyclerView.setHasFixedSize(true);
        departamentosRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        departamentosAdapter = new DepartamentosAdapter(this, this);

        departamentosRecyclerView.setAdapter(departamentosAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();

        cargarDatos();
    }

    private void cargarDatos() {
        String json = Util.leerJSON(this);

        Pais departamentos = gson.fromJson(json, Pais.class);

        departamentosAdapter.setDataset(departamentos.getDepartamentos());
    }

    @Override
    public void onDepartamentoSelected(Departamento departamento) {
        Intent intent = new Intent(this, DepartamentoActivity.class);
        intent.putExtra("depto", gson.toJson(departamento));
        startActivity(intent);
    }
}
