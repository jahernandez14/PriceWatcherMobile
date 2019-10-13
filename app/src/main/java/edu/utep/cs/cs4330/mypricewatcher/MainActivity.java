package edu.utep.cs.cs4330.mypricewatcher;

/**
 * @author Julio A Hernandez
 * @version 1.0
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Comparator;

import edu.utep.cs.cs4330.mypricewatcher.DTO.Item;
import edu.utep.cs.cs4330.mypricewatcher.DTO.ItemController;
import edu.utep.cs.cs4330.mypricewatcher.DTO.ItemModel;

/**
 * Activity class created to serve as the main view of the pricewatcher application
 */
public class MainActivity extends FragmentActivity {

    private ItemController itemController;
//    private TextView name, currPrice, url, initPrice, changePrice;
//    private Button btnUpdatePrice, btnOpenURL;

    private ListView listView;
    private FloatingActionButton floatingActionButton;
    private ArrayAdapter<Item> listViewAdapter;

    View.OnClickListener openURL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);

            intent.putExtra("url", itemController.getURL());
            startActivity(intent);

        }
    };

    View.OnClickListener updatePrice = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(itemController == null)return;
            itemController.updatePrice();
            itemController.updateChange();
            itemController.updateView();
        }
    };

    View.OnClickListener addNewItem = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //first we are going to open the Dialog and ask the user for the information of the item
            FragmentManager fragmentManager = getSupportFragmentManager();
            CustomDialog dialog = new CustomDialog();



            //Once we have the information we are going to display it by adding it to the adapter
        }
    };

    /**
     *
     * @param savedInstanceState
     */
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listViewAdapter = new ArrayAdapter<Item>(this, R.id.list);

        listView = findViewById(R.id.list);
        listView.setAdapter(listViewAdapter);

        floatingActionButton = findViewById(R.id.add);
        floatingActionButton.setOnClickListener(addNewItem);


//        name = findViewById(R.id.NameTextView);
//        currPrice = findViewById(R.id.currentPriceTextView);
//        url = findViewById(R.id.URLTextView);
//        initPrice = findViewById(R.id.InitialTextView);
//        changePrice = findViewById(R.id.PriceChangeTextView);
//
//
//        btnUpdatePrice = findViewById(R.id.UpdateButton);
//        btnOpenURL = findViewById(R.id.URLButton);
//        btnUpdatePrice.setOnClickListener(updatePrice);
//        btnOpenURL.setOnClickListener(openURL);

        ItemModel itemModel = new ItemModel(new Item("PS4 Pro", "https://www.bestbuy.com/site/sony-playstation-4-pro-console-jet-black/5388900.p?skuId=5388900", 400, 0, 0));

//        itemController = new ItemController(itemModel, this);
//        itemController.updateView();
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
//        NumberFormat formatter = new DecimalFormat("#0.00");
//        this.name.setText(name);
//        this.currPrice.setText("$"+String.valueOf(currPrice));
//        this.initPrice.setText("$"+String.valueOf(iniPrice));
//        this.changePrice.setText(String.valueOf(formatter.format(changePrice))+"%");
//        this.url.setText(url.substring(0,40));

        listViewAdapter.add(new Item(name, url, iniPrice, currPrice, changePrice));
        listViewAdapter.sort(new Comparator<Item>() {
            @Override
            public int compare(Item item, Item t1) {
                return item.name.compareTo(t1.name);
            }
        });
        listViewAdapter.notifyDataSetChanged();
    }
}
