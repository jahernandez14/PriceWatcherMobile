package edu.utep.cs.cs4330.mypricewatcher.View;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import edu.utep.cs.cs4330.mypricewatcher.Controller.ItemController;
import edu.utep.cs.cs4330.mypricewatcher.Controller.PriceFinder;
import edu.utep.cs.cs4330.mypricewatcher.Model.Item;
import edu.utep.cs.cs4330.mypricewatcher.R;

/**
 * @author Julio Hernandez
 * Class was created to provide a edit dialog when editing items
 */
public class ItemEditDialog extends Dialog implements View.OnClickListener {

    private TextView name, url;
    private Button cancel, edit;
    private ItemController itemController;
    private Item item;

    public ItemEditDialog(Activity activity, ItemController itemController) {
        super(activity);
        this.itemController = itemController;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.edit_dialog_layout);
        name = findViewById(R.id.name);
        url = findViewById(R.id.url);
        cancel = findViewById(R.id.cancel);
        edit = findViewById(R.id.edit);
        cancel.setOnClickListener(this);
        edit.setOnClickListener(this);
    }
    public void itemSelected(Item item){
        this.item = item;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit:
                if(name.getText().toString().length() > 1) {
                    item.setName(name.getText().toString());
                }
                if(url.getText().toString().length() > 1) {
                    item.setUrl(url.getText().toString());
                }
                itemController.editItem(item);
            case R.id.cancel:
                dismiss();
        }
    }
}
