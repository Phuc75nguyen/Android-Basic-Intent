package com.example.basicintentaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnWeb, btnMessage, btnPhone, btnviewContact, btnEdContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       btnWeb = findViewById(R.id.btnWeb);
       btnMessage = findViewById(R.id.btnMessage);
       btnPhone = findViewById(R.id.btnPhone);
       btnviewContact = findViewById(R.id.viewContact);
       btnEdContact = findViewById(R.id.btnEdContact);
    }

    public void Webpage(View view) {
        // Use Intent.ACTION_VIEW to open a webpage
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://vi.wikipedia.org/wiki/Trang_Ch%C3%ADnh"));
        startActivity(intent);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:")); // This ensures only SMS apps respond
        intent.putExtra("sms_body", "Hello there. Remember me huh? I am the most handsome boy in this class!");
        startActivity(intent);
    }

    public void callPhone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0799684789"));
        startActivity(intent);
    }

    public void viewContact(View view) {
       Intent intent = new Intent(Intent.ACTION_VIEW);
       Uri contact = Uri.parse("content://contacts/people/1");
       intent.setData(contact);
       startActivity(intent);
    }

    public void editContact(View view) {
        Intent intent = new Intent(Intent.ACTION_EDIT);
        Uri contact = Uri.parse("content://contacts/people/1");
        intent.setData(contact);
        startActivity(intent);
    }
}