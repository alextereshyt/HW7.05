package edu.itstep.a07roomdb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditContactActivity extends AppCompatActivity {
    private EditText fullNameEditText;
    private EditText phoneEditText;
    private Button saveButton;

    private  ContactDAO contactDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);


        fullNameEditText = findViewById(R.id.edit_full_name);
        phoneEditText = findViewById(R.id.edit_phone);
        saveButton = findViewById(R.id.btn_save);
        contactDAO = App.getInstance().getPhoneBookDB().contactDAO();

        String fullName = getIntent().getStringExtra("fullName");
        String phone = getIntent().getStringExtra("phone");
        Contact temp = (Contact) getIntent().getSerializableExtra("contact");

        fullNameEditText.setText(fullName);

        phoneEditText.setText(phone);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedFullName = fullNameEditText.getText().toString();
                String updatedPhone = phoneEditText.getText().toString();


                Contact contact = temp;
                contact.setPhone(updatedPhone);
                contact.setFullName(updatedFullName);
                contactDAO.update(contact);
                v.getContext().startActivity(new Intent(v.getContext(), MainActivity.class));

            }
        });
    }
}
