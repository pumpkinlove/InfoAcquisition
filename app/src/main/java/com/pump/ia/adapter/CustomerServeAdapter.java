package com.pump.ia.adapter;

import java.util.List;

import com.pump.ia.R;
import com.pump.ia.domain.web.Person;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomerServeAdapter extends BaseAdapter {

    private Context contextwrapper;
    private List<Person> personList;
    public int getCount() {
        return personList.size();
    }

    public Object getItem(int position) {
        return personList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public CustomerServeAdapter(Context context) {
        contextwrapper = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        try {
            ViewHolder holder = new ViewHolder();
            if (convertView == null) {
                view = View.inflate(contextwrapper, R.layout.item_person_serve, null);
                holder = new ViewHolder();
                holder.ps_name = (TextView) view.findViewById(R.id.ps_name);
                holder.ps_mobile = (TextView) view.findViewById(R.id.ps_mobile);
                holder.ps_times= (TextView) view.findViewById(R.id.ps_times);
                holder.ps_last_serve = (TextView) view.findViewById(R.id.ps_last_serve);
                holder.ps_follow = (TextView) view.findViewById(R.id.ps_follow);
                view.setTag(holder);
            } else {
                view = convertView;
                holder = (ViewHolder) view.getTag();
            }
            Person c = personList.get(position);
            if (c != null) {
                Log.e("-----null---",c.getServiceCount()+"");
                holder.ps_name.setText(c.getName());
                Log.e("---ps_name-----","------------");
                holder.ps_mobile.setText(c.getMobile());
                Log.e("---ps_mobile-----","------------");
                holder.ps_times.setText(c.getServiceCount());
                Log.e("---ps_times-----","------------");
                holder.ps_last_serve.setText(c.getUpdateUser()+"_"+c.getUpdateDate());
                Log.e("--ps_last_serve------","------------");
                if(TextUtils.isEmpty(c.getRemark())){
                    holder.ps_follow.setText("已关注");
                    holder.ps_follow.setTextColor(contextwrapper.getResources().getColor(R.color.gray_dark));
                }else{
                    holder.ps_follow.setText("关注");
                    holder.ps_follow.setTextColor(contextwrapper.getResources().getColor(R.color.green_dark));
                }
            }
        } catch (Exception ex) {
            Log.e("ex",ex.toString());
            ex.printStackTrace();
        }
        return view;
    }
    static class ViewHolder {
        TextView ps_name;
        TextView ps_mobile;
        TextView ps_times;
        TextView ps_last_serve;
        TextView ps_follow;

    }


    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

}
