package com.mlee138.mykitchen_cs441;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class KitchenFragment extends Fragment {

    ListView listView;
    ArrayAdapter<String> listViewAdapter;
    ArrayList<String> itemNames;
    ArrayList<FoodItem> items;
    EditText etName, etQuantity, etCalories, etCarbs, etFat, etProtein, etSodium, etSugar;

    NutritionalFacts nfTest = new NutritionalFacts("1", "2", "3", "4" ,"5", "6");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kitchen_content, container,false);
        //kitchen items to display
        String[] kitchenItems = {"Chicken","String Beans", "Spaghetti"};
        itemNames = new ArrayList<>(Arrays.asList(kitchenItems));
        listView = (ListView) view.findViewById(R.id.kitchen_list);

        //turns kitchen items to displayable items
        listViewAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                itemNames
        );


        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showInputBox(itemNames.get(position),position);
            }
        });


        Button button = (Button)view.findViewById(R.id.add_item);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showAddInputBox();
            }
        });

        return view;
    }

    public void showInputBox(String oldItemName, final int index){
        final Dialog dialog = new Dialog(getActivity());
        dialog.setTitle("Input Box");
        dialog.setContentView(R.layout.input_box);

        TextView txtMessage = (TextView) dialog.findViewById(R.id.txtmessage);
        txtMessage.setText("Update Item");
        txtMessage.setTextSize(20);
        txtMessage.setTextColor(Color.parseColor("#000000"));

        etName=(EditText)dialog.findViewById(R.id.txtName);
        etName.setText(oldItemName);
//        etQuantity=(EditText)dialog.findViewById(R.id.txtQuantity);
//        etQuantity.setText(oldItem.getQuantity());
//        etCalories=(EditText)dialog.findViewById(R.id.txtCalories);
//        etCalories.setText(oldItem.getNf().getCalories());
//        etCarbs=(EditText)dialog.findViewById(R.id.txtCarbs);
//        etCarbs.setText(oldItem.getNf().getCarbs());
//        etFat=(EditText)dialog.findViewById(R.id.txtFat);
//        etFat.setText(oldItem.getNf().getFat());
//        etSodium=(EditText)dialog.findViewById(R.id.txtSodium);
//        etSodium.setText(oldItem.getNf().getSodium());
//        etSugar=(EditText)dialog.findViewById(R.id.txtSugar);
//        etSugar.setText(oldItem.getNf().getSugar());

        Button bt = (Button)dialog.findViewById(R.id.btdone);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                items.set(index, updatedFoodItem(etName.getText().toString(),etQuantity.getText().toString(),etCalories.getText().toString(),etCarbs.getText().toString(),etFat.getText().toString(),etProtein.getText().toString(),etSodium.getText().toString(),etSugar.getText().toString()));
//                items.set(index, updatedFoodItem(etName.getText().toString(), etQuantity.getText().toString(), "1","1", "1", "1", "1","1"));
                itemNames.set(index,etName.getText().toString());
                listViewAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void showAddInputBox(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.setTitle("Input Box");
        dialog.setContentView(R.layout.input_box);

        TextView txtMessage = (TextView) dialog.findViewById(R.id.txtmessage);
        txtMessage.setText("Add Item");
        txtMessage.setTextSize(20);
        txtMessage.setTextColor(Color.parseColor("#000000"));

        etName=(EditText)dialog.findViewById(R.id.txtName);
//        etQuantity=(EditText)dialog.findViewById(R.id.txtQuantity);
//        etCalories=(EditText)dialog.findViewById(R.id.txtCalories);
//        etCalories.setText("0");
//        etCarbs=(EditText)dialog.findViewById(R.id.txtCarbs);
//        etCarbs.setText("0");
//        etFat=(EditText)dialog.findViewById(R.id.txtFat);
//        etFat.setText("0");
//        etSodium=(EditText)dialog.findViewById(R.id.txtSodium);
//        etSodium.setText("0");
//        etSugar=(EditText)dialog.findViewById(R.id.txtSugar);
//        etSugar.setText("0");


        Button bt = (Button)dialog.findViewById(R.id.btdone);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                items.add(updatedFoodItem(etName.getText().toString(),etQuantity.getText().toString(),etCalories.getText().toString(),etCarbs.getText().toString(),etFat.getText().toString(),etProtein.getText().toString(),etSodium.getText().toString(),etSugar.getText().toString()));
                //items.add(updatedFoodItem(etName.getText().toString(), etQuantity.getText().toString(), "1","1", "1", "1", "1","1"));
                itemNames.add(etName.getText().toString());
                listViewAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public FoodItem updatedFoodItem(String name, String quantity, String calories, String carbs, String fats, String proteins, String sodium, String sugar){

        NutritionalFacts nfTemp = new NutritionalFacts( calories, carbs,fats,proteins,sodium,sugar);

        return new FoodItem(name, quantity, nfTemp);
    }
}
