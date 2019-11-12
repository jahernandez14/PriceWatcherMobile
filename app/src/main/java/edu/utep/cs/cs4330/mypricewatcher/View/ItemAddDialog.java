package edu.utep.cs.cs4330.mypricewatcher.View;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import edu.utep.cs.cs4330.mypricewatcher.Controller.PriceFinder;
import edu.utep.cs.cs4330.mypricewatcher.Model.Item;
import edu.utep.cs.cs4330.mypricewatcher.Controller.ItemController;
import edu.utep.cs.cs4330.mypricewatcher.R;

public class ItemAddDialog extends Dialog implements View.OnClickListener {

    private TextView name, url;
    private Button cancel, add;
    private ItemController itemController;

    public ItemAddDialog(Activity activity, ItemController itemController) {
        super(activity);
        this.itemController = itemController;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_dialog_layout);
        name = findViewById(R.id.name);
        url = findViewById(R.id.url);
        cancel = findViewById(R.id.cancel);
        add = findViewById(R.id.add);
        cancel.setOnClickListener(this);
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                double price = new PriceFinder().urlPrice(url.getText().toString());
                Item item = new Item("", name.getText().toString(),
                        url.getText().toString(),
                        price,
                        price, 0.0);
                itemController.addItem(item);
            case R.id.cancel:
                dismiss();
        }
    }
}
