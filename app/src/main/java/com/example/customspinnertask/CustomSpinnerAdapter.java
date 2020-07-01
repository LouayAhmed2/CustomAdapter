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
    OnSpinnerItemClickListener onSpinnerItemClickListener;


    CustomSpinnerAdapter(Context c, List<IDisplay> l,
                         OnSpinnerItemClickListener onSpinnerItemClickListener) {
        this.context = c;
        this.list = l;
        this.onSpinnerItemClickListener = onSpinnerItemClickListener;
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of list.size.
     */
    @Override
    public int getCount() {
        return list.size();
    }

    /**
     * Get the data item associated with the specified position in the IDisplay set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */

    @Override
    public IDisplay getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link android.view.LayoutInflater#inflate(int, android.view.ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position The position of the item within the adapter's data set of the item whose view
     *        we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *        is non-null and of an appropriate type before using. If it is not possible to convert
     *        this view to display the correct data, this method can create a new view.
     *        Heterogeneous lists can specify their number of view types, so that this View is
     *        always of the right type (see {@link #getViewTypeCount()} and
     *        {@link #getItemViewType(int)}).
     * @param parent The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
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

    @Override
    public View getDropDownView(final int position, View convertView, ViewGroup parent) {
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
        if (onSpinnerItemClickListener != null)
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSpinnerItemClickListener.onItemSelected(iDisplay, position);
                }
            });
        return convertView;
    }

    public void changeData(List<IDisplay> data) {
        this.list = data;
        notifyDataSetChanged();
    }

    class ViewHolder {
        TextView textView;
    }

    public void setOnSpinnerItemClickListener(OnSpinnerItemClickListener onSpinnerItemClickListener) {
        this.onSpinnerItemClickListener = onSpinnerItemClickListener;
    }

}
