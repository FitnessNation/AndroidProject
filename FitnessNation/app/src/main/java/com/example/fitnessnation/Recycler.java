package com.example.fitnessnation;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Recycler extends RecyclerView.Adapter<Recycler.MyViewHolder> {

    private List<Meal> mealList;

    public Recycler(List<Meal> mealList)
    {
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(textView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.items.setText((CharSequence) mealList.get(position));
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder {

        TextView items;
        public MyViewHolder(@NonNull TextView itemView) {
            super(itemView);
            items = itemView;
        }
    }
}
