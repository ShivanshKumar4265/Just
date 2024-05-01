package com.inventics.dailymoments.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.inventics.dailymoments.R;
import com.inventics.dailymoments.modal.DailyCoordinatesModal;

import java.util.ArrayList;

public class DailyCoordinatesAdapter  extends RecyclerView.Adapter<DailyCoordinatesAdapter.ViewHolder>{
    Context context;
    ArrayList<DailyCoordinatesModal> data;

    public DailyCoordinatesAdapter(Context context, ArrayList<DailyCoordinatesModal> data) {
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public DailyCoordinatesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DailyCoordinatesAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.coordinate_item_layout, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull DailyCoordinatesAdapter.ViewHolder holder, int position) {
        holder.tv_momentName.setText(data.get(position).getMomentName());


    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_momentName,tv_historyDate,tv_historyDistanceDigit,tv_fromData,tv_toData;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_historyDate = itemView.findViewById(R.id.tv_historyDate);
            tv_momentName = itemView.findViewById(R.id.tv_momentName);
            tv_historyDistanceDigit = itemView.findViewById(R.id.tv_historyDistanceDigit);
            tv_fromData = itemView.findViewById(R.id.tv_fromData);
            tv_toData = itemView.findViewById(R.id.tv_toData);

        }
    }

}
