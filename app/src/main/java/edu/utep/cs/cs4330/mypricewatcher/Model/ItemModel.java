package edu.utep.cs.cs4330.mypricewatcher.Model;

/**
 * @author Julio A Hernandez
 * @version 3.0
 */

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class created to retrieve all item information to implement MVC
 */
public class ItemModel {
    private Database db;

    public ItemModel(Context context){
        this.db = new Database(context);
    }

    public void addItem(Item item){
        this.db.insertData(item);
    }

    public Cursor getItems(){
        return db.getAll();
    }

    public void updatePrice(Item item){
        this.db.updateData(item);
    }

    public void removeItem(Item item) {
        this.db.deleteData(item.id);
        }

    public void editItem(Item item) {
        this.db.editData(item);
    }

}
