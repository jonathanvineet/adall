package com.example.library;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DBHelper db;
    private ListView listView;
    private EditText etTitle, etAuthor, etDeleteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = DBHelper.getInstance(this);
        listView = findViewById(R.id.listView);
        etTitle = findViewById(R.id.etTitle);
        etAuthor = findViewById(R.id.etAuthor);
        etDeleteId = findViewById(R.id.etDeleteId);

        findViewById(R.id.btnAdd).setOnClickListener(v -> {
            String title = etTitle.getText().toString().trim();
            String author = etAuthor.getText().toString().trim();
            if (title.isEmpty() || author.isEmpty()) {
                Toast.makeText(this, "Please enter title and author", Toast.LENGTH_SHORT).show();
                return;
            }
            db.addBook(title, author);
            Toast.makeText(this, "Book added", Toast.LENGTH_SHORT).show();
            etTitle.setText("");
            etAuthor.setText("");
        });

        findViewById(R.id.btnDelete).setOnClickListener(v -> {
            String idStr = etDeleteId.getText().toString().trim();
            if (idStr.isEmpty()) {
                Toast.makeText(this, "Please enter Book ID", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                int id = Integer.parseInt(idStr);
                db.deleteBook(id);
                Toast.makeText(this, "Book deleted", Toast.LENGTH_SHORT).show();
                etDeleteId.setText("");
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid ID", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnAvailable).setOnClickListener(v -> {
            try (Cursor c = db.getAvailableBooks()) {
                ArrayList<String> list = new ArrayList<>();
                if (c != null) {
                    while (c.moveToNext()) {
                        list.add(c.getString(0) + ": " + c.getString(1) + " by " + c.getString(2));
                    }
                }
                listView.setAdapter(new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, list));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        findViewById(R.id.btnLent).setOnClickListener(v -> {
            try (Cursor c = db.getLentBooks()) {
                ArrayList<String> list = new ArrayList<>();
                if (c != null) {
                    while (c.moveToNext()) {
                        list.add(c.getString(0) + " -> " + c.getString(1) + " (" + c.getString(2) + ")");
                    }
                }
                listView.setAdapter(new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, list));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        findViewById(R.id.btnReserved).setOnClickListener(v -> {
            try (Cursor c = db.getReservations()) {
                ArrayList<String> list = new ArrayList<>();
                if (c != null) {
                    while (c.moveToNext()) {
                        list.add(c.getString(0) + " reserved by " + c.getString(1));
                    }
                }
                listView.setAdapter(new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, list));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Seed a lend and reservation for demo in a background thread to avoid blocking UI
        new Thread(() -> {
            try {
                db.lendBook(1, 1, "2024-01-15");
                db.reserveBook(2, 2, "2024-01-16");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
