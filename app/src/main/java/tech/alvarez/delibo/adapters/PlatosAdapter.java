package tech.alvarez.delibo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tech.alvarez.delibo.R;
import tech.alvarez.delibo.model.Plato;

public class PlatosAdapter extends RecyclerView.Adapter<PlatosAdapter.DeviceViewHolder> {

    private List<Plato> dataset;

    public PlatosAdapter() {
        this.dataset = new ArrayList<>();
    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plato, parent, false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position) {
        Plato plato = dataset.get(position);
        holder.nombreTextView.setText(plato.getNombre());
        holder.descripcionTextView.setText(plato.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class DeviceViewHolder extends RecyclerView.ViewHolder {

        TextView nombreTextView;
        TextView descripcionTextView;

        public DeviceViewHolder(View itemView) {
            super(itemView);
            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
            descripcionTextView = (TextView) itemView.findViewById(R.id.descripcionTextView);
        }
    }

    public void setDataset(List<Plato> platos) {
        if (platos == null) {
            dataset = new ArrayList<>();
        } else {
            dataset = platos;
        }
        notifyDataSetChanged();
    }

    public void add(Plato plato) {
        dataset.add(plato);
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        notifyDataSetChanged();
    }

}
