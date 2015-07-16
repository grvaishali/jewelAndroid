package com.example.jewell;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class SingleRow {
	String title;
	String description;
	int image;

	public SingleRow(String title, String description, int image) {
		this.title = title;
		this.description = description;
		this.image = image;
	}
}

public class CatalogueAdapter extends BaseAdapter {

	ArrayList<SingleRow> list;
	Context context;

	public CatalogueAdapter(Context c) {
		context = c;
		list = new ArrayList<SingleRow>();
		Resources res = c.getResources();
		// String[] titles = res.getStringArray(R.array.titles);
		// String[] descriptions = res.getStringArray(R.array.descriptions);
		// int[] images = { R.drawable.images, R.drawable.uu };
		for (int i = 0; i < 10; i++) {
			// list.add(new SingleRow(titles[i], descriptions[i], images[0]));
		}
	}

	@Override
	public int getCount() {

		return list.size();
	}

	@Override
	public Object getItem(int position) {

		return list.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public View getView(int position, View convertView, ViewGroup viewGroup)
	// {
	// View row = convertView;
	// //ViewHolder holder = null;
	// LayoutInflater inflator;
	// if (row == null) {
	// inflator = (LayoutInflater) context
	// .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	// row = inflator.inflate(R.layout.single_row, viewGroup, false);
	// holder = new ViewHolder(row);
	// row.setTag(holder);
	// Log.d("VIVZ", "Creating a new row");
	//
	// } else {
	// holder = (ViewHolder) row.getTag();
	// Log.d("VIVZ", "Recycling");
	// }
	// SingleRow temp = list.get(position);
	// holder.title.setText(temp.title);
	// holder.description.setText(temp.description);
	// holder.image.setImageResource(temp.image);
	// return row;
	// }

}
