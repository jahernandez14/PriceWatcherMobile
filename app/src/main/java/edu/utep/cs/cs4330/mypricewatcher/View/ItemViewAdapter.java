package edu.utep.cs.cs4330.mypricewatcher.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.text.DecimalFormat;

import edu.utep.cs.cs4330.mypricewatcher.Model.Item;
import edu.utep.cs.cs4330.mypricewatcher.R;

public class ItemViewAdapter extends ArrayAdapter<Item> {

    private Context context;
    private ArrayList<Item> items = new ArrayList<>();

    ItemViewAdapter(@NonNull Context context, int resource, ArrayList<Item> objects) {
        super(context, resource, objects);
        this.context = context;
        this.items = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        NumberFormat format = new DecimalFormat("#0.00");
        Item item = (Item) getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, parent, false);
        }

        TextView name = convertView.findViewById(R.id.name);
        TextView url = convertView.findViewById(R.id.url);
        TextView initialPrice = convertView.findViewById(R.id.initialPrice);
        TextView currentPrice = convertView.findViewById(R.id.currentPrice);
        TextView priceChange = convertView.findViewById(R.id.priceChange);

        name.setText(item.name);
        url.setText(item.url);
        initialPrice.setText("$" + format.format(item.initialPrice));
        currentPrice.setText("$" + format.format(item.currentPrice));
        priceChange.setText(format.format(item.priceChange)+"%");

        return convertView;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


}
