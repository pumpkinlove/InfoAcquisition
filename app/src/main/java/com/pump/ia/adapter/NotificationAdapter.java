package com.pump.ia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.domain.Notification;
import com.pump.ia.domain.web.Notice;
import com.pump.ia.utils.DateUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private NotificationListener listener;

    private List<Notice> notificationList;
    private Context context;

    public NotificationAdapter(List<Notice> notificationList, Context context) {
        this.notificationList = notificationList;
        this.context = context;
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NotificationViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notification, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {
        holder.tv_notification_content.setText(notificationList.get(position).getTitle());
        holder.tv_notification_time.setText(DateUtil.toAll(notificationList.get(position).getUpdateDate()));
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public void setListener(NotificationListener listener) {
        this.listener = listener;
    }


    static class NotificationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private NotificationListener listener;
        @ViewInject(R.id.tv_notification_content)
        private TextView tv_notification_content;
        @ViewInject(R.id.tv_notification_time)
        private TextView tv_notification_time;


        public NotificationViewHolder(View itemView, NotificationListener listener) {
            super(itemView);
            x.view().inject(this, itemView);
            this.listener = listener;
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getPosition());
        }
    }

    interface NotificationListener{
        void onItemClick(View view, int position);
    }

    public void setNotificationList(List<Notice> notificationList){
        this.notificationList = notificationList;
    }

}
