package edu.itstep.a07roomdb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {
    private List<Contact> items;
    private Context context;

    public CustomAdapter(Context context, List<Contact> items,List<String > names) {
        super(context,0,names);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact item = items.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.text_view);
        textView.setText(item.getFullName());


        int color = position % 2 == 0 ? Color.BLUE : Color.YELLOW;
        convertView.setBackgroundColor(color);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullName = items.get(position).getFullName();
                String phone = items.get(position).getPhone();
                Intent intent = new Intent(context, EditContactActivity.class);
                intent.putExtra("fullName", fullName);
                intent.putExtra("phone", phone);
                intent.putExtra("contact",  items.get(position));
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
