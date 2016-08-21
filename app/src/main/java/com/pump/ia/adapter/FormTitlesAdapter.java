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
        this.titles = titles;
        this.context = context;
    }

    @Override
    public TitleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TitleViewHolder(LayoutInflater.from(context).inflate(R.layout.item_form_title, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(TitleViewHolder holder, int position) {
        holder.tv_title.setText(titles[position]);
        if(position == 0){
            holder.tv_title.setBackgroundColor(context.getResources().getColor(R.color.blue_band_light));
            holder.tv_title.setTextColor(context.getResources().getColor(R.color.black));
        }
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
        private TextView tv_title;

        @ViewInject(R.id.direction_line_bottom)
        private View direction_line_bottom;

        @ViewInject(R.id.direction_line_right)
        private View direction_line_right;

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
