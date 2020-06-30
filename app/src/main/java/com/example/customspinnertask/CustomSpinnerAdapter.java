package com.example.customspinnertask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomSpinnerAdapter extends BaseAdapter {
    private Context context;
    private List<IDisplay> list;

    CustomSpinnerAdapter(Context c, List<IDisplay> l) {
        this.context = c;
        this.list = l;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public IDisplay getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_spinner, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.text_view_spinner);

            convertView.setTag(viewHolder);
        } else viewHolder = (ViewHolder) convertView.getTag();
        final IDisplay iDisplay = getItem(position);
        if (iDisplay != null) {
            viewHolder.textView.setText(iDisplay.getName());
        }
        return convertView;
    }

    public void changeData(List<IDisplay> data) {
        this.list = data;
        notifyDataSetChanged();
    }

    class ViewHolder {
        TextView textView;
    }

}
