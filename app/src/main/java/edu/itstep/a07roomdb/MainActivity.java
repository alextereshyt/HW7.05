package edu.itstep.a07roomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ContactDAO contactDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        contactDAO = App.getInstance().getPhoneBookDB().contactDAO();


      contactDAO.add(new Contact("Ivan Ivanov", "066-666-66-66"));
      contactDAO.add(new Contact("Petr Petrov", "073-777-77-77"));
       contactDAO.add(new Contact("Stepan Stepanov", "073-888-88-88"));

        listView = findViewById(R.id.list_view);

        List<Contact> items = new ArrayList<>();
        List<Contact> contacts = contactDAO.getAll();

      for (Contact contact : contacts) {
          items.add(contact);
       }
        List<String> temp = new ArrayList<>();
        for (Contact contact : items)
            temp.add(contact.getFullName());
        CustomAdapter adapter = new CustomAdapter(this, items,temp);
        listView.setAdapter(adapter);


    }
}