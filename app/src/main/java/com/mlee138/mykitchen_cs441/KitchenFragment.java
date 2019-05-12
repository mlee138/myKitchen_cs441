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
    ArrayList<String> arrayList;
    EditText editText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.kitchen_content, container,false);
        //kitchen items to display
        String[] kitchenItems = {"A","B","C"};
        listView = (ListView) view.findViewById(R.id.kitchen_list);
        arrayList = new ArrayList<>(Arrays.asList(kitchenItems));
        //turns kitchen items to displayable items
        listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                arrayList
        );


        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showInputBox(arrayList.get(position),position);
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

    public void showInputBox(String oldItem, final int index){
        final Dialog dialog = new Dialog(getActivity());
            dialog.setTitle("Input Box");
            dialog.setContentView(R.layout.input_box);
            TextView txtMessage = (TextView) dialog.findViewById(R.id.txtmessage);
            txtMessage.setText("Update Item");
            txtMessage.setTextSize(20);
            txtMessage.setTextColor(Color.parseColor("#000000"));
            editText=(EditText)dialog.findViewById(R.id.txtinput);
            editText.setText(oldItem);
            Button bt = (Button)dialog.findViewById(R.id.btdone);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    arrayList.set(index,editText.getText().toString());
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
        editText=(EditText)dialog.findViewById(R.id.txtinput);
        Button bt = (Button)dialog.findViewById(R.id.btdone);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(editText.getText().toString());
                listViewAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
