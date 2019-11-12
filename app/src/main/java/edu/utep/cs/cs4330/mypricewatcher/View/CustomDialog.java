package edu.utep.cs.cs4330.mypricewatcher.View;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import edu.utep.cs.cs4330.mypricewatcher.Model.Item;
import edu.utep.cs.cs4330.mypricewatcher.Controller.ItemController;
import edu.utep.cs.cs4330.mypricewatcher.R;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView name, initialPrice, url;
    private Button cancel, add;
    private ItemController itemController;

    public CustomDialog(Activity activity, ItemController itemController) {
        super(activity);
        this.itemController = itemController;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_layout);
        name = findViewById(R.id.name);
        initialPrice = findViewById(R.id.initialPrice);
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
                //we are going to add the element to the listview
                double price = Double.valueOf(String.valueOf(initialPrice.getText()));
                Item item = new Item("", name.getText().toString(), "https://" +
                        url.getText().toString(),
                        price,
                        price, 0.0);
                itemController.addItem(item);
            case R.id.cancel:
                dismiss();
        }
    }
}
