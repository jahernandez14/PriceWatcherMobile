package edu.utep.cs.cs4330.mypricewatcher.View;

/**
 * @author Julio A Hernandez
 * @version 3.0
 */

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import edu.utep.cs.cs4330.mypricewatcher.Model.Item;
import edu.utep.cs.cs4330.mypricewatcher.Model.ItemModel;
import edu.utep.cs.cs4330.mypricewatcher.Controller.ItemController;
import edu.utep.cs.cs4330.mypricewatcher.R;

/**
 * Activity class created to serve as the main view of the pricewatcher application
 */
public class MainActivity extends AppCompatActivity {

    private ItemController itemController;
    private ListView listView;
    private FloatingActionButton floatingActionButton;
    private ItemViewAdapter listViewAdapter;
    private ItemAddDialog addDialog;
    private ItemEditDialog editDialog;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemController = new ItemController(new ItemModel(this), this);
        listViewAdapter = new ItemViewAdapter(this, android.R.layout.simple_list_item_1, new ArrayList<Item>());
        this.addDialog = new ItemAddDialog(this, itemController);
        this.editDialog = new ItemEditDialog(this, itemController);
        listView = findViewById(R.id.list);
        listView.setAdapter(listViewAdapter);
        floatingActionButton = findViewById(R.id.add);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDialog.show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Item selectedItem = listViewAdapter.getItem(i);
                    PopupMenu pop = new PopupMenu(MainActivity.this, view);
                    pop.inflate(R.menu.menu);
                    pop.show();

                    pop.setOnMenuItemClickListener(item -> {
                                switch (item.getItemId()) {
                                    case R.id.popDelete:
                                        itemController.removeItem(selectedItem);
                                        return true;
                                    case R.id.popURL:
                                        Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                                        intent.putExtra("url", selectedItem.getUrl());
                                        Log.d("URL!!! ID: ", selectedItem.getUrl());
                                        startActivity(intent);
                                        return true;
                                    case R.id.popEdit:
                                        editDialog.itemSelected(selectedItem);
                                        editDialog.show();
                                        return true;
                                    case R.id.popupdate:
                                        //itemController.updatePrice( i);
                                    default:
                                        return false;
                                }
                    });

            }

        });
        itemController.updateView();
    }

    public void displayItem(String id, String name, double iniPrice, String url, double changePrice, double currPrice){
        listViewAdapter.add(new Item(id, name, url, iniPrice, currPrice, changePrice));
        listViewAdapter.notifyDataSetChanged();
    }

    public void clearItems(){
        listViewAdapter.clear();
    }
}
