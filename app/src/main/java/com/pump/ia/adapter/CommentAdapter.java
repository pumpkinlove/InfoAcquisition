package com.pump.ia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.domain.serve.Comment;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by xu.nan on 2016/8/24.
 */
public class CommentAdapter  extends  RecyclerView.Adapter<CommentAdapter.CommentViewHolder>{

    private List<Comment> commentList;
    private Context context;
    private CommentListener commentListener;

    public CommentAdapter(List<Comment> commentList, Context context, CommentListener commentListener) {
        this.commentList = commentList;
        this.context = context;
        this.commentListener = commentListener;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_comment, parent, false), commentListener);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        Comment c = commentList.get(position);
        if(c == null){
            return;
        }
        Log.e("====",c.toString());
        holder.comment_id.setText(c.getId()+"");
        holder.comment_name.setText(c.getName());
        holder.comment_content.setText(c.getContent());
        holder.comment_time.setText(c.getTime());

        if( null !=c.getAnswerName() && !"".equals(c.getAnswerName()) && c.getAnswerId() != 0 ){
            holder.comment_answer_name.setText(c.getAnswerId() + "_" + c.getAnswerName());
            holder.comment_answer_name.setVisibility(View.VISIBLE);
            holder.tv_huifu.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    static class CommentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CommentListener listener;
        @ViewInject(R.id.comment_name)
        private TextView comment_name;
        @ViewInject(R.id.comment_id)
        private TextView comment_id;
        @ViewInject(R.id.comment_answer_name)
        private TextView comment_answer_name;
        @ViewInject(R.id.comment_content)
        private TextView comment_content;
        @ViewInject(R.id.comment_time)
        private TextView comment_time;
        @ViewInject(R.id.tv_answer)
        private TextView comment_answer;
        @ViewInject(R.id.tv_huifu)
        private TextView tv_huifu;

        public CommentViewHolder(View itemView, CommentListener listener) {
            super(itemView);
            x.view().inject(this, itemView);
            this.listener = listener;
            comment_answer.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getPosition());
        }
    }

    public interface CommentListener{
        void onItemClick(View view,int position);
    }

    public void setCommentListener(CommentListener commentListener){
        this.commentListener = commentListener;
    }
}
