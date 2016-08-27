package com.pump.ia.adapter;

import java.util.List;

import com.pump.ia.R;
import com.pump.ia.domain.web.Person;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CusomerListAdapter extends BaseAdapter {

	private Context contextwrapper;
	private List<Person> cars;
	public int getCount() {
		return cars.size();
	}

	public Object getItem(int position) {
		return cars.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public CusomerListAdapter(Context context) {
		contextwrapper = context;
	}

	@SuppressWarnings("deprecation")
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		try {
			ViewHolder holder = new ViewHolder();
			if (convertView == null) {
				view = View.inflate(contextwrapper, R.layout.item_customer, null);
				view.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, 180));
				holder = new ViewHolder();
				holder.tv_name = (TextView) view.findViewById(R.id.tv_customer_name);
				holder.tv_gender = (TextView) view.findViewById(R.id.tv_gender);
				holder.tv_certificate= (TextView) view.findViewById(R.id.tv_certificate);
				holder.tv_mobile = (TextView) view.findViewById(R.id.tv_mobile);
				view.setTag(holder);
			} else {
				view = convertView;
				holder = (ViewHolder) view.getTag();
			}
			Person c = cars.get(position);
			if (c != null) {
				Log.e("----------",c.getName());
				holder.tv_name.setText(c.getName());
				holder.tv_gender.setText(c.getSexVal());
				holder.tv_certificate.setText(c.getCardNo());
				holder.tv_mobile.setText(c.getMobile());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return view;
	}
	static class ViewHolder {
		TextView tv_name;
		TextView tv_gender;
		TextView tv_certificate;
		TextView tv_mobile;
	}


	public void setCars(List<Person> cars) {
		this.cars = cars;
	}

}
