package com.example.jsoup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


class RankAdapter extends RecyclerView.Adapter<RankAdapter.ItemViewHolder> {

    Context context;
    ArrayList<Team> teams= new ArrayList<>();

    RankAdapter(Context context, ArrayList<Team> teams){
    this.teams=teams;
    this.context=context;
    }
    RankAdapter(){

    }

    @NonNull
    @Override
    public RankAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_rank,viewGroup,false);
        return new ItemViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull RankAdapter.ItemViewHolder itemViewHolder, int i) {

        Team team= teams.get(i);

        itemViewHolder.name.setText(team.getTeam_name());
        itemViewHolder.rank.setText(team.getRank());
        itemViewHolder.a.setText(team.getA());
        itemViewHolder.d.setText(team.getD());
        itemViewHolder.f.setText(team.getF());
        itemViewHolder.gd.setText(team.getGd());
        itemViewHolder.gp.setText(team.getGp());
        itemViewHolder.l.setText(team.getL());
        itemViewHolder.p.setText(team.getP());
        itemViewHolder.w.setText(team.getW());
        Glide.with(context).load(team.getImgurl()).into(itemViewHolder.img);


    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView rank,name,gp,w,d,l,f,a,gd,p;
        ImageView img;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            rank=itemView.findViewById(R.id.item_rank);
            name=itemView.findViewById(R.id.item_name);
            gp=itemView.findViewById(R.id.item_gp);
            w=itemView.findViewById(R.id.item_w);
            d=itemView.findViewById(R.id.item_d);
            l=itemView.findViewById(R.id.item_l);
            f=itemView.findViewById(R.id.item_f);
            a=itemView.findViewById(R.id.item_a);
            gd=itemView.findViewById(R.id.item_gd);
            p=itemView.findViewById(R.id.item_p);
            img=itemView.findViewById(R.id.item_image);

        }
    }
}
