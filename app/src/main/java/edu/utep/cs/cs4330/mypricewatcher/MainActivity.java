package edu.utep.cs.cs4330.mypricewatcher;

/**
 * @author Julio A Hernandez
 * @version 1.0
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Comparator;

import edu.utep.cs.cs4330.mypricewatcher.DTO.Item;
import edu.utep.cs.cs4330.mypricewatcher.DTO.ItemController;
import edu.utep.cs.cs4330.mypricewatcher.DTO.ItemModel;

/**
 * Activity class created to serve as the main view of the pricewatcher application
 */
public class MainActivity extends AppCompatActivity {

    private ItemController itemController;

    private ListView listView;
    private FloatingActionButton floatingActionButton;
    private CustomAdapter listViewAdapter;
    private CustomDialog dialog;

    /**
     *
     * @param savedInstanceState
     */
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemController = new ItemController(new ItemModel(), this);

        listViewAdapter = new CustomAdapter(this, android.R.layout.simple_list_item_1, new ArrayList<Item>());
        this.dialog = new CustomDialog(this, itemController);

        listView = findViewById(R.id.list);
        listView.setAdapter(listViewAdapter);

        floatingActionButton = findViewById(R.id.add);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item selectedItem = listViewAdapter.getItem(i);
                Log.d("TESTING", "Look in the logs, when item is clicked this is called: "+selectedItem.name);
            }
        });


        //itemController.addItem(new Item("PS4 Pro", "https://www.bestbuy.com/site/sony-playstation-4-pro-console-jet-black/5388900.p?skuId=5388900", 400, 0, 0));
        //itemController.updateView();
    }

    /**
     *
     * @param name
     * @param iniPrice
     * @param url
     * @param changePrice
     * @param currPrice
     */
    public void displayItem(String name, double iniPrice, String url, double changePrice, double currPrice){
        listViewAdapter.add(new Item(name, url, iniPrice, currPrice, changePrice));
        listViewAdapter.sort(new Comparator<Item>() {
            @Override
            public int compare(Item item, Item t1) {
                return item.name.compareTo(t1.name);
            }
        });
        listViewAdapter.notifyDataSetChanged();
    }

    public void clearItems(){
        listViewAdapter.clear();
    }
}
