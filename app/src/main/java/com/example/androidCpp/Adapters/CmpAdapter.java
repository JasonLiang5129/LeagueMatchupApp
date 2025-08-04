package com.example.androidCpp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidCpp.Classes.Cmp;
import com.example.androidCpp.MainActivity;
import com.example.androidCpp.Screens.OpponentCmpScreen;
import com.example.androidCpp.Screens.PlayerCmpScreen;
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
        holder.champName.setTextColor(ContextCompat.getColor(context, R.color.black));

        holder.champItemLayout.setOnClickListener(v -> {
            if (context instanceof PlayerCmpScreen) { // making sure we don't open opponentCmpScreen if the context is already opponentCmpScreen
                MainActivity.setPlayerCmp(championsList.get(holder.getAdapterPosition())); // sets the player champ in MainActivity to the one that the user clicked on
                Toast toast = Toast.makeText(context, "set player cmp", Toast.LENGTH_SHORT);
                toast.show();
                openOpponentCmpScreen(v);
            }
            else {
                MainActivity.setOpponentCmp(championsList.get(holder.getAdapterPosition())); // sets the opponent champ "
                Toast toast = Toast.makeText(context, "set opponent cmp", Toast.LENGTH_SHORT);
                toast.show();
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

    public void openOpponentCmpScreen(View v) {
        Context context = v.getContext();
        Intent intent = new Intent(context, OpponentCmpScreen.class);
        context.startActivity(intent);
    }
}
