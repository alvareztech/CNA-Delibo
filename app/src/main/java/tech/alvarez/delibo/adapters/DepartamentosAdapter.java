package tech.alvarez.delibo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tech.alvarez.delibo.R;
import tech.alvarez.delibo.model.Departamento;

public class DepartamentosAdapter extends RecyclerView.Adapter<DepartamentosAdapter.DeviceViewHolder> {

    private Context context;
    private List<Departamento> dataset;
    private OnDepartamentoSelectedListener onDepartamentoSelectedListener;

    public interface OnDepartamentoSelectedListener {
        void onDepartamentoSelected(Departamento departamento);
    }

    public DepartamentosAdapter(Context context, OnDepartamentoSelectedListener listener) {
        this.dataset = new ArrayList<>();
        this.context = context;
        this.onDepartamentoSelectedListener = listener;
    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_departamento, parent, false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position) {
        Departamento departamento = dataset.get(position);
        holder.nombreTextView.setText(departamento.getNombre());
        holder.provinciasTextView.setText(context.getString(R.string.nro_provincias, departamento.getNroProvincias()));

        holder.setDeviceSelectedListener(departamento, onDepartamentoSelectedListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class DeviceViewHolder extends RecyclerView.ViewHolder {

        View cardView;

        TextView nombreTextView;
        TextView provinciasTextView;

        public DeviceViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);

            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
            provinciasTextView = (TextView) itemView.findViewById(R.id.provinciasTextView);
        }

        public void setDeviceSelectedListener(final Departamento departamento, final OnDepartamentoSelectedListener onDepartamentoSelectedListener) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDepartamentoSelectedListener.onDepartamentoSelected(departamento);
                }
            });
        }
    }

    public void add(Departamento departamento) {
        dataset.add(departamento);
        notifyDataSetChanged();
    }

    public void setDataset(List<Departamento> departamentos) {
        if (departamentos == null) {
            dataset = new ArrayList<>();
        } else {
            dataset = departamentos;
        }
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        notifyDataSetChanged();
    }

}
