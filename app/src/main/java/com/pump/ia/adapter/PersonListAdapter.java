package com.pump.ia.adapter;

import java.util.List;

import com.pump.ia.R;
import com.pump.ia.domain.web.Person;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PersonListAdapter extends BaseAdapter {

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

	public PersonListAdapter(Context context) {
		contextwrapper = context;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		try {
			ViewHolder holder = new ViewHolder();
			if (convertView == null) {
				view = View.inflate(contextwrapper, R.layout.item_customer, null);
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
			Person c = personList.get(position);
			if (c != null) {
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


	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

}
