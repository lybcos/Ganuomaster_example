package com.example.administrator.ganuo_master_example.mvp.daimajia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.ganuo_master_example.R;
import com.example.administrator.ganuo_master_example.mvp.entity.HuaResults;
import com.example.administrator.ganuo_master_example.mvp.entity.Results;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/27.
 */

public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.GrilViewHolder>{
    private Context context;
    List<Results> mlist = new ArrayList<>();
    List<HuaResults.PinsBean> huaResults = new ArrayList<>();
    protected final String mUrlSmallFormat;//小图地址
    protected final String mUrlGeneralFormat;//普通地址
    protected final String mUrlBigFormat;//大图地址
    int type;
    String url_image;
    String desc;

    public List<Results>getResults(){
        return mlist;
    }
    public List<HuaResults.PinsBean>getHuaResults(){
        return huaResults;
    }

    public GirlAdapter(Context context,int type) {
        this.context = context;
        this.type = type;
        this.mUrlSmallFormat = context.getString(R.string.url_image_small);
        this.mUrlGeneralFormat = context.getString(R.string.url_image_general);
        this.mUrlBigFormat = context.getString(R.string.url_image_big);

    }

    @Override
    public GrilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_girly,parent,false);
        GrilViewHolder holder=new GrilViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(GrilViewHolder holder, int position) {
        if (type == 1) {
            url_image=mlist.get(position).getUrl();
            desc=mlist.get(position).getDesc();
        }else {
            String key = huaResults.get(position).getFile().getKey();
            url_image=String.format(mUrlGeneralFormat,key);
            desc=huaResults.get(position).getRaw_text();
        }
        Glide.with(context)
                .load(url_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        if (type==1){
            return mlist.size();
        }
        return huaResults.size();
    }

    class  GrilViewHolder extends RecyclerView.ViewHolder{
    private ImageView imageView;
    public GrilViewHolder(View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.iv_girly);
    }
}
}