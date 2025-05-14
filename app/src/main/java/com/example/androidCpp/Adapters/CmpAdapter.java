package com.example.androidCpp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidCpp.Classes.Cmp;
import com.example.androidcpp.R;

import java.util.ArrayList;

public class CmpAdapter extends RecyclerView.Adapter<CmpAdapter.cmpViewHolder> {
    Context context;
    ArrayList<Cmp> championsList;

    public CmpAdapter(Context context, ArrayList<Cmp> championsList) {
        this.context = context;
        this.championsList = championsList;
    }

    @NonNull
    @Override
    public cmpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflating (creating) the item layout
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_cmp, parent, false);
        return new CmpAdapter.cmpViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull cmpViewHolder holder, int position) {
        // Assigning values to the items in the recyclerView as they are being inflated
        holder.champIcon.setImageResource(championsList.get(position).getCmpIcon());
        holder.champName.setText(championsList.get(position).getCmpName());
        holder.champName.setTextColor(R.color.black);

        holder.champItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.champName.getCurrentTextColor() == R.color.black) {
                    holder.champName.setTextColor(R.color.teal_200); // TODO currently a placeholder for something that indicates the champ was clicked/selected
                }
                else {
                    holder.champName.setTextColor(R.color.black);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        // Get the number of items to be displayed
        return championsList.size();
    }

    public static class cmpViewHolder extends RecyclerView.ViewHolder {
        // Taking the views from the item layout and assigning them to variables
        ConstraintLayout champItemLayout;
        ImageView champIcon;
        TextView champName;

        public cmpViewHolder(@NonNull View itemView) {
            super(itemView);

            champItemLayout = itemView.findViewById(R.id.champ_item_layout);
            champIcon = itemView.findViewById(R.id.champ_icon);
            champName = itemView.findViewById(R.id.champ_name);
        }
    }
}
