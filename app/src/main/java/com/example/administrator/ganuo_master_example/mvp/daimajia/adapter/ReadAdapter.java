package com.example.administrator.ganuo_master_example.mvp.daimajia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ganuo_master_example.R;
import com.example.administrator.ganuo_master_example.mvp.entity.Results;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/10.
 */

public class ReadAdapter extends RecyclerView.Adapter<ReadAdapter.PartViewHolder>{
    private  List<Results> mlist = new ArrayList<>();
    private Context context;

    public ReadAdapter(List<Results> mlist, Context context) {
        if (mlist != null) {
            this.mlist = mlist;
        }

        this.context = context;
    }

        public  List<Results> getResults(){
            return mlist;
        }
    @Override
    public PartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PartViewHolder holder1 = new PartViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_read, parent));
        return holder1;
    }

    @Override
    public void onBindViewHolder(PartViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class PartViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView textView;
        TextView tv_author, tv_time;
        ImageView iv_img;

        public PartViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textView = (TextView) itemView.findViewById(R.id.read_tv);
            tv_author = (TextView) itemView.findViewById(R.id.read_tv_author);
            tv_time = (TextView) itemView.findViewById(R.id.read_tv_time);
            iv_img = (ImageView) itemView.findViewById(R.id.read_iv_img);
        }
    }
}
