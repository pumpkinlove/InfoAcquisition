package com.pump.ia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pump.ia.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public class FormTitlesAdapter extends RecyclerView.Adapter<FormTitlesAdapter.TitleViewHolder> {

    private String[] titles;
    private Context context;
    private List<TextView> tvList = new ArrayList<>();
    private TitleClickListener listener;

    public FormTitlesAdapter(String[] titles, Context context){
        Log.e("------------","FormTitlesAdapter");
        this.titles = titles;
        this.context = context;
    }

    @Override
    public TitleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("------------","onCreateViewHolder");
        return new TitleViewHolder(LayoutInflater.from(context).inflate(R.layout.item_form_title, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(TitleViewHolder holder, int position) {
        Log.e("------------","onBindViewHolder");
        holder.tv_title.setText(titles[position]);
        Log.e("------------","position:"+titles[position]);
        if(tvList.size() < titles.length){
            tvList.add(holder.tv_title);
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }


    static class TitleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @ViewInject(R.id.item_form_title)
        public TextView tv_title;
        private TitleClickListener listener;

        public TitleViewHolder(View itemView, TitleClickListener listener) {
            super(itemView);
            x.view().inject(this, itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                listener.onItemClick(view,getPosition());
            }
        }
    }

    public List<TextView> getTvList(){
        return tvList;
    }

    public interface TitleClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(TitleClickListener listener){
        this.listener = listener;
    }
}
