package com.example.myrecycleview_a179830.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecycleview_a179830.Fruit;
import com.example.myrecycleview_a179830.FruitDetailActivity;
import com.example.myrecycleview_a179830.R;

import java.util.List;

public class FruitRecyclerViewAdapter extends RecyclerView.Adapter<FruitRecyclerViewAdapter.FruitViewHolder>{

    public List<Fruit> fruitList;
    private Context context;

    public FruitRecyclerViewAdapter(Context context,List<Fruit> fruitList) {
        this.context = context;
        this.fruitList = fruitList;

    }

    @NonNull

    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View fruit_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_row,null);

        FruitViewHolder fruitVH = new FruitViewHolder(fruit_row);
        return fruitVH;
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {

        holder.tvFruitName.setText(fruitList.get(position).getName());
        holder.imgViewFruitImage.setImageResource(fruitList.get(position).getImage());

    }

    @Override
    public int getItemCount() {

        return fruitList.size();
    }

    public class FruitViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tvFruitName;
        public ImageView imgViewFruitImage;

        public FruitViewHolder(@NonNull View itemView) {

            super(itemView);
            tvFruitName = itemView.findViewById(R.id.tv_fruit_name);
            imgViewFruitImage = itemView.findViewById(R.id.img_fruit);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Fruit Name: " + fruitList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(view.getContext(), FruitDetailActivity.class);
            intent.putExtra("fruitName",fruitList.get(getAdapterPosition()).getName());
            view.getContext().startActivity(intent);
        }
    }
}
