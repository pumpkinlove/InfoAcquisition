package com.pump.ia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.domain.serve.Serve;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class ServeAdapter extends  RecyclerView.Adapter<ServeAdapter.ServeViewHolder> {

    private List<Serve> serveList;
    private Context context;
    private ServeListener listener;

    public ServeAdapter(List<Serve> serveList, Context context) {
        this.serveList = serveList;
        this.context = context;
    }

    @Override
    public ServeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ServeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_customer_serve, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(ServeViewHolder holder, int position) {
//        Collections.reverse(serveList);
        holder.tv_serve_name.setText(serveList.get(position).getName());
        holder.tv_serve_content.setText(serveList.get(position).getContent());
        holder.tv_serve_commentNum.setText(serveList.get(position).getCommentNum());
        holder.tv_serve_type.setText(serveList.get(position).getType());
        holder.tv_serve_time.setText(serveList.get(position).getTime());
        holder.tv_serve_address.setText(serveList.get(position).getAddress());
//        Collections.reverse(serveList);
    }

    @Override
    public int getItemCount() {
        return serveList.size();
    }

    static class ServeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ServeListener listener;
        @ViewInject(R.id.tv_serve_name)
        private TextView tv_serve_name;
        @ViewInject(R.id.tv_serve_content)
        private TextView tv_serve_content;
        @ViewInject(R.id.tv_serve_commentNum)
        private TextView tv_serve_commentNum;
        @ViewInject(R.id.tv_serve_type)
        private TextView tv_serve_type;
        @ViewInject(R.id.tv_serve_time)
        private TextView tv_serve_time;
        @ViewInject(R.id.tv_serve_address)
        private TextView tv_serve_address;


        public ServeViewHolder(View itemView, ServeListener listener) {
            super(itemView);
            x.view().inject(this, itemView);
            this.listener = listener;
            tv_serve_commentNum.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                listener.onItemClick(view,getPosition());
            }
        }
    }

    public interface ServeListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(ServeListener listener){
        this.listener = listener;
    }

}
