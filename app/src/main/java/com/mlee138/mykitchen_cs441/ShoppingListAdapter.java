package com.mlee138.mykitchen_cs441;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ShoppingListAdapter extends ArrayAdapter<sListItem> {
    private Activity activity;
    private ArrayList<sListItem> sList;
    private static LayoutInflater inflater = null;

    public ShoppingListAdapter (Activity activity, int textViewResourceId,ArrayList<sListItem> _sList) {
        super(activity, textViewResourceId, _sList);
        try {
            this.activity = activity;
            this.sList = _sList;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {

        }
    }

    public int getCount() {
        return sList.size();
    }

    public sListItem getItem(sListItem position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView display_name;
        public TextView display_number;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.shoppinglist_content, null);
                holder = new ViewHolder();

                //holder.display_name = (TextView) vi.findViewById(R.id.slItem_name);
                //holder.display_number = (TextView) vi.findViewById(R.id.slItem_quantity);


                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }



            holder.display_name.setText(sList.get(position).getName());
            holder.display_number.setText(sList.get(position).getQuantity());


        } catch (Exception e) {


        }
        return vi;
    }
}