package edu.utep.cs.cs4330.mypricewatcher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import edu.utep.cs.cs4330.mypricewatcher.DTO.Item;

public class CustomAdapter extends ArrayAdapter<Item> {

    private Context context;
    private ArrayList<Item> items = new ArrayList<>();

    CustomAdapter(@NonNull Context context, int resource,  ArrayList<Item> objects) {
        super(context, resource, objects);
        this.context = context;
        this.items = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Item item = (Item) getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, parent, false);
        }

        TextView title = convertView.findViewById(R.id.title);
        TextView subTitle = convertView.findViewById(R.id.subTitle);

        title.setText(item.name);
        subTitle.setText(String.valueOf(item.currentPrice));

        return convertView;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


}
