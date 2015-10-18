package com.kanitkorn.android.kuhiw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lukyth on 10/19/2015 AD.
 */
public class MenusAdapter extends ArrayAdapter<Menu> {

    private static class ViewHolder {
        TextView menuName;
        TextView menuMinPrice;
        TextView menuMaxPrice;
    }

    public MenusAdapter(Context context, ArrayList<Menu> menus) {
        super(context, R.layout.item_menu, menus);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Menu menu = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_menu, parent, false);
            viewHolder.menuName = (TextView) convertView.findViewById(R.id.menuName);
            viewHolder.menuMinPrice = (TextView) convertView.findViewById(R.id.menuMinPrice);
            viewHolder.menuMaxPrice = (TextView) convertView.findViewById(R.id.menuMaxPrice);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.menuName.setText(menu.name);
        viewHolder.menuMinPrice.setText(Integer.toString(menu.minPrice));
        viewHolder.menuMaxPrice.setText(Integer.toString(menu.maxPrice));
        // Return the completed view to render on screen
        return convertView;
    }
}