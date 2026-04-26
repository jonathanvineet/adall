# Android Studio Programs

## 1. BOOKSTORE STUDENT REGISTRATION

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:padding="16dp"
android:background="#F5F5F5">

<LinearLayout
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:orientation="vertical">

<TextView android:text="Bookstore Registration"
android:textSize="22sp" android:textStyle="bold"
android:textColor="#1565C0"
android:layout_marginBottom="16dp"
android:layout_width="wrap_content"
android:layout_height="wrap_content"/>

<EditText android:id="@+id/etName" android:hint="Full Name"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:inputType="textPersonName" android:layout_marginBottom="10dp"/>

<EditText android:id="@+id/etStudentId" android:hint="Student ID"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<EditText android:id="@+id/etEmail" android:hint="Email"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:inputType="textEmailAddress" android:layout_marginBottom="10dp"/>

<EditText android:id="@+id/etPhone" android:hint="Phone Number"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:inputType="phone" android:layout_marginBottom="16dp"/>

<TextView android:text="Book Details" android:textSize="16sp"
android:textStyle="bold" android:textColor="#1565C0"
android:layout_width="wrap_content" android:layout_height="wrap_content"
android:layout_marginBottom="8dp"/>

<EditText android:id="@+id/etBookTitle" android:hint="Book Title"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<EditText android:id="@+id/etAuthor" android:hint="Author"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<Spinner android:id="@+id/spinnerDept"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<EditText android:id="@+id/etQty" android:hint="Quantity"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:inputType="number" android:layout_marginBottom="16dp"/>

<Button android:id="@+id/btnRegister" android:text="Register Book"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#1565C0"/>

<Button android:id="@+id/btnReset" android:text="Reset"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginTop="8dp" android:backgroundTint="#757575"/>

</LinearLayout>
</ScrollView>
```

### `MainActivity.java`

```java
package com.example.bookstore;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

EditText etName, etStudentId, etEmail, etPhone, etBookTitle, etAuthor, etQty;
Spinner spinnerDept;
Button btnRegister, btnReset;
String[] departments = {"Computer Science","Electronics","Mechanical","Civil","IT"};

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

etName = findViewById(R.id.etName);
etStudentId = findViewById(R.id.etStudentId);
etEmail = findViewById(R.id.etEmail);
etPhone = findViewById(R.id.etPhone);
etBookTitle = findViewById(R.id.etBookTitle);
etAuthor = findViewById(R.id.etAuthor);
etQty = findViewById(R.id.etQty);
spinnerDept = findViewById(R.id.spinnerDept);
btnRegister = findViewById(R.id.btnRegister);
btnReset = findViewById(R.id.btnReset);

ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
android.R.layout.simple_spinner_item, departments);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinnerDept.setAdapter(adapter);

btnRegister.setOnClickListener(v -> {
String name = etName.getText().toString().trim();
String id = etStudentId.getText().toString().trim();
String email = etEmail.getText().toString().trim();
String book = etBookTitle.getText().toString().trim();
if (name.isEmpty() || id.isEmpty() || email.isEmpty() || book.isEmpty()) {
Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
} else {
Toast.makeText(this, "Book registered successfully for " + name, Toast.LENGTH_LONG).show();
}
});

btnReset.setOnClickListener(v -> {
etName.setText(""); etStudentId.setText(""); etEmail.setText("");
etPhone.setText(""); etBookTitle.setText(""); etAuthor.setText("");
etQty.setText(""); spinnerDept.setSelection(0);
});
}
}
```

## 2. STUDENT COURSE REGISTRATION

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent" android:layout_height="match_parent"
android:padding="16dp">

<LinearLayout android:layout_width="match_parent"
android:layout_height="wrap_content" android:orientation="vertical">

<TextView android:text="Course Registration"
android:textSize="22sp" android:textStyle="bold"
android:textColor="#1565C0" android:layout_marginBottom="16dp"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>

<EditText android:id="@+id/etStudentName" android:hint="Student Name"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<EditText android:id="@+id/etRegNo" android:hint="Register Number"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<Spinner android:id="@+id/spinnerSem"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="16dp"/>

<TextView android:text="Select Courses:" android:textSize="16sp"
android:textStyle="bold" android:layout_width="wrap_content"
android:layout_height="wrap_content" android:layout_marginBottom="8dp"/>

<CheckBox android:id="@+id/cb1" android:text="CS301 - Data Structures (4 Credits)"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<CheckBox android:id="@+id/cb2" android:text="CS302 - Algorithms (3 Credits)"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<CheckBox android:id="@+id/cb3" android:text="CS303 - DBMS (3 Credits)"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<CheckBox android:id="@+id/cb4" android:text="CS304 - Operating Systems (4 Credits)"
android:layout_width="wrap_content" android:layout_height="wrap_content"
android:layout_marginBottom="16dp"/>

<Button android:id="@+id/btnSubmit" android:text="Submit Registration"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#1565C0"/>

<TextView android:id="@+id/tvResult" android:layout_width="match_parent"
android:layout_height="wrap_content" android:layout_marginTop="12dp"
android:textSize="14sp" android:textColor="#333"/>

</LinearLayout>
</ScrollView>
```

### `MainActivity.java`

```java
package com.example.coursereg;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

EditText etStudentName, etRegNo;
Spinner spinnerSem;
CheckBox cb1, cb2, cb3, cb4;
Button btnSubmit;
TextView tvResult;
String[] semesters = {"Semester 1","Semester 2","Semester 3","Semester 4","Semester 5","Semester 6"};

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

etStudentName = findViewById(R.id.etStudentName);
etRegNo = findViewById(R.id.etRegNo);
spinnerSem = findViewById(R.id.spinnerSem);
cb1 = findViewById(R.id.cb1);
cb2 = findViewById(R.id.cb2);
cb3 = findViewById(R.id.cb3);
cb4 = findViewById(R.id.cb4);
btnSubmit = findViewById(R.id.btnSubmit);
tvResult = findViewById(R.id.tvResult);

ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
android.R.layout.simple_spinner_item, semesters);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinnerSem.setAdapter(adapter);

btnSubmit.setOnClickListener(v -> {
String name = etStudentName.getText().toString().trim();
String reg = etRegNo.getText().toString().trim();
if (name.isEmpty() || reg.isEmpty()) {
Toast.makeText(this, "Fill student details", Toast.LENGTH_SHORT).show();
return;
}
StringBuilder selected = new StringBuilder("Registered Courses:\n");
int credits = 0;
if (cb1.isChecked()) { selected.append("- Data Structures\n"); credits += 4; }
if (cb2.isChecked()) { selected.append("- Algorithms\n"); credits += 3; }
if (cb3.isChecked()) { selected.append("- DBMS\n"); credits += 3; }
if (cb4.isChecked()) { selected.append("- Operating Systems\n"); credits += 4; }
if (credits == 0) {
Toast.makeText(this, "Select at least one course", Toast.LENGTH_SHORT).show();
return;
}
selected.append("Total Credits: ").append(credits);
tvResult.setText(selected.toString());
Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
});
}
}
```

## 3. STUDENT TICKET BOOKING

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent" android:layout_height="match_parent"
android:padding="16dp">

<LinearLayout android:layout_width="match_parent"
android:layout_height="wrap_content" android:orientation="vertical">

<TextView android:text="Ticket Booking"
android:textSize="22sp" android:textStyle="bold"
android:textColor="#1565C0" android:layout_marginBottom="16dp"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>

<EditText android:id="@+id/etPassName" android:hint="Passenger Name"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<EditText android:id="@+id/etStudId" android:hint="Student ID"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<EditText android:id="@+id/etFrom" android:hint="From (Origin)"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<EditText android:id="@+id/etTo" android:hint="To (Destination)"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<EditText android:id="@+id/etDate" android:hint="Travel Date (DD/MM/YYYY)"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<TextView android:text="Seat Class:" android:layout_width="wrap_content"
android:layout_height="wrap_content"/>
<Spinner android:id="@+id/spinnerClass"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<EditText android:id="@+id/etTickets" android:hint="Number of Tickets"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:inputType="number" android:layout_marginBottom="16dp"/>

<Button android:id="@+id/btnBook" android:text="Book Ticket"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#1565C0"/>

<TextView android:id="@+id/tvBookingResult" android:layout_width="match_parent"
android:layout_height="wrap_content" android:layout_marginTop="12dp"
android:textSize="14sp" android:padding="10dp"/>

</LinearLayout>
</ScrollView>
```

### `MainActivity.java`

```java
package com.example.ticketbooking;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

EditText etPassName, etStudId, etFrom, etTo, etDate, etTickets;
Spinner spinnerClass;
Button btnBook;
TextView tvBookingResult;
String[] seatClasses = {"General - ₹50","Sleeper - ₹120","AC 3-Tier - ₹350","AC 2-Tier - ₹550"};
int[] prices = {50, 120, 350, 550};

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

etPassName = findViewById(R.id.etPassName);
etStudId = findViewById(R.id.etStudId);
etFrom = findViewById(R.id.etFrom);
etTo = findViewById(R.id.etTo);
etDate = findViewById(R.id.etDate);
etTickets = findViewById(R.id.etTickets);
spinnerClass = findViewById(R.id.spinnerClass);
btnBook = findViewById(R.id.btnBook);
tvBookingResult = findViewById(R.id.tvBookingResult);

ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
android.R.layout.simple_spinner_item, seatClasses);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinnerClass.setAdapter(adapter);

btnBook.setOnClickListener(v -> {
String name = etPassName.getText().toString().trim();
String from = etFrom.getText().toString().trim();
String to = etTo.getText().toString().trim();
String date = etDate.getText().toString().trim();
String ticketStr = etTickets.getText().toString().trim();

if (name.isEmpty() || from.isEmpty() || to.isEmpty() || date.isEmpty() || ticketStr.isEmpty()) {
Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
return;
}
int n = Integer.parseInt(ticketStr);
int idx = spinnerClass.getSelectedItemPosition();
int total = n * prices[idx];

tvBookingResult.setText(
"=== BOOKING CONFIRMED ===\n" +
"Passenger: " + name + "\n" +
"Route: " + from + " → " + to + "\n" +
"Date: " + date + "\n" +
"Class: " + seatClasses[idx] + "\n" +
"Tickets: " + n + "\n" +
"Total Amount: ₹" + total
);
});
}
}
```

## 4. STUDENT REGISTRATION (with SQLite Database)

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent" android:layout_height="match_parent"
android:padding="16dp">

<LinearLayout android:layout_width="match_parent"
android:layout_height="wrap_content" android:orientation="vertical">

<TextView android:text="Student Registration"
android:textSize="22sp" android:textStyle="bold"
android:textColor="#1565C0" android:layout_marginBottom="16dp"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>

<EditText android:id="@+id/etFirstName" android:hint="First Name"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>
<EditText android:id="@+id/etLastName" android:hint="Last Name"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>
<EditText android:id="@+id/etDOB" android:hint="Date of Birth (DD/MM/YYYY)"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<TextView android:text="Gender:" android:layout_width="wrap_content"
android:layout_height="wrap_content"/>
<RadioGroup android:id="@+id/rgGender" android:orientation="horizontal"
android:layout_width="wrap_content" android:layout_height="wrap_content"
android:layout_marginBottom="10dp">
<RadioButton android:id="@+id/rbMale" android:text="Male"/>
<RadioButton android:id="@+id/rbFemale" android:text="Female"/>
<RadioButton android:id="@+id/rbOther" android:text="Other"/>
</RadioGroup>

<Spinner android:id="@+id/spinnerYear"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>
<Spinner android:id="@+id/spinnerDept"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="10dp"/>

<EditText android:id="@+id/etAddress" android:hint="Address"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:minLines="2" android:layout_marginBottom="10dp"/>
<EditText android:id="@+id/etEmail" android:hint="Email"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:inputType="textEmailAddress" android:layout_marginBottom="10dp"/>
<EditText android:id="@+id/etPhone" android:hint="Phone"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:inputType="phone" android:layout_marginBottom="16dp"/>

<Button android:id="@+id/btnRegister" android:text="Register"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#1565C0"/>
<Button android:id="@+id/btnClear" android:text="Clear"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginTop="8dp" android:backgroundTint="#757575"/>

</LinearLayout>
</ScrollView>
```

### `DatabaseHelper.java`

```java
package com.example.studreg;

import android.content.Context;
import android.database.sqlite.*;

public class DatabaseHelper extends SQLiteOpenHelper {
public DatabaseHelper(Context context) {
super(context, "StudentDB", null, 1);
}
@Override
public void onCreate(SQLiteDatabase db) {
db.execSQL("CREATE TABLE students (" +
"id INTEGER PRIMARY KEY AUTOINCREMENT," +
"first_name TEXT, last_name TEXT, dob TEXT," +
"gender TEXT, year TEXT, dept TEXT," +
"address TEXT, email TEXT, phone TEXT)");
}
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS students");
onCreate(db);
}
}
```

### `MainActivity.java`

```java
package com.example.studreg;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

EditText etFirstName, etLastName, etDOB, etAddress, etEmail, etPhone;
RadioGroup rgGender;
Spinner spinnerYear, spinnerDept;
Button btnRegister, btnClear;
DatabaseHelper dbHelper;

String[] years = {"1st Year","2nd Year","3rd Year","4th Year"};
String[] depts = {"Computer Science","Electronics","Mechanical","Civil","IT"};

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

dbHelper = new DatabaseHelper(this);

etFirstName = findViewById(R.id.etFirstName);
etLastName = findViewById(R.id.etLastName);
etDOB = findViewById(R.id.etDOB);
etAddress = findViewById(R.id.etAddress);
etEmail = findViewById(R.id.etEmail);
etPhone = findViewById(R.id.etPhone);
rgGender = findViewById(R.id.rgGender);
spinnerYear = findViewById(R.id.spinnerYear);
spinnerDept = findViewById(R.id.spinnerDept);
btnRegister = findViewById(R.id.btnRegister);
btnClear = findViewById(R.id.btnClear);

spinnerYear.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years));
spinnerDept.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, depts));

btnRegister.setOnClickListener(v -> {
String firstName = etFirstName.getText().toString().trim();
String lastName = etLastName.getText().toString().trim();
if (firstName.isEmpty() || lastName.isEmpty()) {
Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show(); return;
}
int genderId = rgGender.getCheckedRadioButtonId();
String gender = genderId == R.id.rbMale ? "Male" : genderId == R.id.rbFemale ? "Female" : "Other";

SQLiteDatabase db = dbHelper.getWritableDatabase();
ContentValues cv = new ContentValues();
cv.put("first_name", firstName); cv.put("last_name", lastName);
cv.put("dob", etDOB.getText().toString()); cv.put("gender", gender);
cv.put("year", spinnerYear.getSelectedItem().toString());
cv.put("dept", spinnerDept.getSelectedItem().toString());
cv.put("address", etAddress.getText().toString());
cv.put("email", etEmail.getText().toString());
cv.put("phone", etPhone.getText().toString());
long id = db.insert("students", null, cv);
Toast.makeText(this, id > 0 ? "Student registered! ID: " + id : "Registration failed", Toast.LENGTH_LONG).show();
});

btnClear.setOnClickListener(v -> {
etFirstName.setText(""); etLastName.setText(""); etDOB.setText("");
etAddress.setText(""); etEmail.setText(""); etPhone.setText("");
rgGender.clearCheck(); spinnerYear.setSelection(0); spinnerDept.setSelection(0);
});
}
}
```

## 5. LIBRARY SYSTEM WITH DATABASE (SQLite)

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent" android:layout_height="match_parent"
android:orientation="vertical" android:padding="16dp">

<TextView android:text="Library Management System"
android:textSize="20sp" android:textStyle="bold" android:textColor="#1565C0"
android:layout_width="wrap_content" android:layout_height="wrap_content"
android:layout_marginBottom="12dp"/>

<EditText android:id="@+id/etSearch" android:hint="Search book by title..."
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="8dp"/>

<Button android:id="@+id/btnSearch" android:text="Search"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#1565C0" android:layout_marginBottom="8dp"/>

<EditText android:id="@+id/etTitle" android:hint="Book Title"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="8dp"/>

<EditText android:id="@+id/etAuthor" android:hint="Author"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="8dp"/>

<EditText android:id="@+id/etISBN" android:hint="ISBN"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="8dp"/>

<Button android:id="@+id/btnAdd" android:text="Add Book"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#2E7D32" android:layout_marginBottom="8dp"/>

<Button android:id="@+id/btnIssue" android:text="Issue Book"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#E65100" android:layout_marginBottom="8dp"/>

<Button android:id="@+id/btnReturn" android:text="Return Book"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#6A1B9A" android:layout_marginBottom="8dp"/>

<ListView android:id="@+id/lvBooks"
android:layout_width="match_parent" android:layout_height="0dp"
android:layout_weight="1"/>

</LinearLayout>
```

### `LibraryDBHelper.java`

```java
package com.example.library;

import android.content.Context;
import android.database.sqlite.*;

public class LibraryDBHelper extends SQLiteOpenHelper {
public LibraryDBHelper(Context context) {
super(context, "LibraryDB", null, 1);
}
@Override
public void onCreate(SQLiteDatabase db) {
db.execSQL("CREATE TABLE books (" +
"id INTEGER PRIMARY KEY AUTOINCREMENT," +
"title TEXT, author TEXT, isbn TEXT, status TEXT DEFAULT 'Available')");
}
@Override
public void onUpgrade(SQLiteDatabase db, int o, int n) {
db.execSQL("DROP TABLE IF EXISTS books"); onCreate(db);
}
}
```

### `MainActivity.java`

```java
package com.example.library;

import android.content.ContentValues;
import android.database.*;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

EditText etSearch, etTitle, etAuthor, etISBN;
Button btnSearch, btnAdd, btnIssue, btnReturn;
ListView lvBooks;
LibraryDBHelper dbHelper;
ArrayAdapter<String> listAdapter;
ArrayList<String> bookList = new ArrayList<>();

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

dbHelper = new LibraryDBHelper(this);
etSearch = findViewById(R.id.etSearch);
etTitle = findViewById(R.id.etTitle);
etAuthor = findViewById(R.id.etAuthor);
etISBN = findViewById(R.id.etISBN);
btnSearch = findViewById(R.id.btnSearch);
btnAdd = findViewById(R.id.btnAdd);
btnIssue = findViewById(R.id.btnIssue);
btnReturn = findViewById(R.id.btnReturn);
lvBooks = findViewById(R.id.lvBooks);

listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookList);
lvBooks.setAdapter(listAdapter);
loadBooks();

btnAdd.setOnClickListener(v -> {
String title = etTitle.getText().toString().trim();
String author = etAuthor.getText().toString().trim();
String isbn = etISBN.getText().toString().trim();
if (title.isEmpty()) { Toast.makeText(this,"Enter title",Toast.LENGTH_SHORT).show(); return; }
SQLiteDatabase db = dbHelper.getWritableDatabase();
ContentValues cv = new ContentValues();
cv.put("title", title); cv.put("author", author); cv.put("isbn", isbn);
db.insert("books", null, cv);
Toast.makeText(this, "Book added!", Toast.LENGTH_SHORT).show();
loadBooks();
});

btnSearch.setOnClickListener(v -> {
String q = etSearch.getText().toString().trim();
bookList.clear();
SQLiteDatabase db = dbHelper.getReadableDatabase();
Cursor c = db.rawQuery("SELECT title,author,status FROM books WHERE title LIKE ?", new String[]{"%"+q+"%"});
while (c.moveToNext()) bookList.add(c.getString(0)+" — "+c.getString(1)+" ["+c.getString(2)+"]");
c.close(); listAdapter.notifyDataSetChanged();
});

btnIssue.setOnClickListener(v -> updateStatus("Available","Issued"));
btnReturn.setOnClickListener(v -> updateStatus("Issued","Available"));
}

void loadBooks() {
bookList.clear();
SQLiteDatabase db = dbHelper.getReadableDatabase();
Cursor c = db.rawQuery("SELECT title,author,status FROM books", null);
while (c.moveToNext()) bookList.add(c.getString(0)+" — "+c.getString(1)+" ["+c.getString(2)+"]");
c.close(); listAdapter.notifyDataSetChanged();
}

void updateStatus(String from, String to) {
String isbn = etISBN.getText().toString().trim();
if (isbn.isEmpty()) { Toast.makeText(this,"Enter ISBN",Toast.LENGTH_SHORT).show(); return; }
SQLiteDatabase db = dbHelper.getWritableDatabase();
ContentValues cv = new ContentValues(); cv.put("status", to);
int rows = db.update("books", cv, "isbn=? AND status=?", new String[]{isbn, from});
Toast.makeText(this, rows > 0 ? "Book "+to+"!" : "Not found / already "+to, Toast.LENGTH_SHORT).show();
loadBooks();
}
}
```

## 6. UI COMPONENTS DEMO

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent" android:layout_height="match_parent"
android:padding="16dp">

<LinearLayout android:layout_width="match_parent"
android:layout_height="wrap_content" android:orientation="vertical">

<TextView android:text="UI Components Demo"
android:textSize="22sp" android:textStyle="bold" android:textColor="#1565C0"
android:layout_width="wrap_content" android:layout_height="wrap_content"
android:layout_marginBottom="12dp"/>

<TextView android:text="EditText:" android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<EditText android:id="@+id/etDemo" android:hint="Type something..."
android:layout_width="match_parent" android:layout_height="wrap_content" android:layout_marginBottom="10dp"/>

<TextView android:text="Spinner:" android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<Spinner android:id="@+id/spinner" android:layout_width="match_parent"
android:layout_height="wrap_content" android:layout_marginBottom="10dp"/>

<TextView android:text="CheckBox:" android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<CheckBox android:id="@+id/cbDemo" android:text="Accept Terms"
android:layout_width="wrap_content" android:layout_height="wrap_content" android:layout_marginBottom="10dp"/>

<TextView android:text="RadioGroup:" android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<RadioGroup android:id="@+id/rg" android:orientation="horizontal"
android:layout_width="wrap_content" android:layout_height="wrap_content" android:layout_marginBottom="10dp">
<RadioButton android:id="@+id/rbA" android:text="Option A"/>
<RadioButton android:id="@+id/rbB" android:text="Option B"/>
</RadioGroup>

<TextView android:text="SeekBar:" android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<SeekBar android:id="@+id/seekBar" android:layout_width="match_parent"
android:layout_height="wrap_content" android:max="100" android:layout_marginBottom="4dp"/>
<TextView android:id="@+id/tvSeek" android:text="Value: 0"
android:layout_width="wrap_content" android:layout_height="wrap_content" android:layout_marginBottom="10dp"/>

<TextView android:text="ProgressBar:" android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<ProgressBar android:id="@+id/progressBar" style="@style/Widget.AppCompat.ProgressBar.Horizontal"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:progress="60" android:max="100" android:layout_marginBottom="10dp"/>

<TextView android:text="RatingBar:" android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<RatingBar android:id="@+id/ratingBar" android:layout_width="wrap_content"
android:layout_height="wrap_content" android:numStars="5" android:stepSize="1"
android:rating="3" android:layout_marginBottom="16dp"/>

<Button android:id="@+id/btnShow" android:text="Show Toast"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#1565C0"/>

<TextView android:id="@+id/tvOutput" android:layout_width="match_parent"
android:layout_height="wrap_content" android:layout_marginTop="12dp"
android:textSize="14sp" android:padding="10dp"
android:background="#E3F2FD" android:textColor="#0D47A1"/>

</LinearLayout>
</ScrollView>
```

### `MainActivity.java`

```java
package com.example.uidemo;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

EditText etDemo;
Spinner spinner;
CheckBox cbDemo;
RadioGroup rg;
SeekBar seekBar;
ProgressBar progressBar;
RatingBar ratingBar;
Button btnShow;
TextView tvSeek, tvOutput;
String[] options = {"Option 1","Option 2","Option 3","Option 4"};

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

etDemo = findViewById(R.id.etDemo);
spinner = findViewById(R.id.spinner);
cbDemo = findViewById(R.id.cbDemo);
rg = findViewById(R.id.rg);
seekBar = findViewById(R.id.seekBar);
progressBar = findViewById(R.id.progressBar);
ratingBar = findViewById(R.id.ratingBar);
btnShow = findViewById(R.id.btnShow);
tvSeek = findViewById(R.id.tvSeek);
tvOutput = findViewById(R.id.tvOutput);

spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options));

seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
public void onProgressChanged(SeekBar sb, int p, boolean u) { tvSeek.setText("Value: " + p); progressBar.setProgress(p); }
public void onStartTrackingTouch(SeekBar sb) {}
public void onStopTrackingTouch(SeekBar sb) {}
});

btnShow.setOnClickListener(v -> {
int radioId = rg.getCheckedRadioButtonId();
String radio = radioId == R.id.rbA ? "Option A" : radioId == R.id.rbB ? "Option B" : "None";
String out = "Text: " + etDemo.getText() +
"\nSpinner: " + spinner.getSelectedItem() +
"\nCheckBox: " + cbDemo.isChecked() +
"\nRadio: " + radio +
"\nSeekBar: " + seekBar.getProgress() +
"\nRating: " + ratingBar.getRating();
tvOutput.setText(out);
Toast.makeText(this, "Values captured!", Toast.LENGTH_SHORT).show();
});
}
}
```

## 7. CALCULATOR APP

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent" android:layout_height="match_parent"
android:orientation="vertical" android:padding="16dp" android:gravity="bottom">

<TextView android:id="@+id/tvExpression" android:layout_width="match_parent"
android:layout_height="wrap_content" android:textSize="16sp"
android:textColor="#888" android:gravity="end" android:layout_marginBottom="4dp"/>

<TextView android:id="@+id/tvDisplay" android:layout_width="match_parent"
android:layout_height="wrap_content" android:text="0"
android:textSize="48sp" android:textStyle="bold"
android:gravity="end" android:layout_marginBottom="16dp"/>

<GridLayout android:layout_width="match_parent" android:layout_height="wrap_content"
android:columnCount="4" android:rowCount="5" android:useDefaultMargins="true">

<Button android:id="@+id/btnAC" android:text="AC" android:backgroundTint="#A5A5A5"/>
<Button android:id="@+id/btnPlusMinus" android:text="+/-" android:backgroundTint="#A5A5A5"/>
<Button android:id="@+id/btnPercent" android:text="%" android:backgroundTint="#A5A5A5"/>
<Button android:id="@+id/btnDiv" android:text="÷" android:backgroundTint="#FF9500"/>

<Button android:id="@+id/btn7" android:text="7"/>
<Button android:id="@+id/btn8" android:text="8"/>
<Button android:id="@+id/btn9" android:text="9"/>
<Button android:id="@+id/btnMul" android:text="×" android:backgroundTint="#FF9500"/>

<Button android:id="@+id/btn4" android:text="4"/>
<Button android:id="@+id/btn5" android:text="5"/>
<Button android:id="@+id/btn6" android:text="6"/>
<Button android:id="@+id/btnSub" android:text="−" android:backgroundTint="#FF9500"/>

<Button android:id="@+id/btn1" android:text="1"/>
<Button android:id="@+id/btn2" android:text="2"/>
<Button android:id="@+id/btn3" android:text="3"/>
<Button android:id="@+id/btnAdd" android:text="+" android:backgroundTint="#FF9500"/>

<Button android:id="@+id/btn0" android:text="0"
android:layout_columnSpan="2" android:layout_gravity="fill_horizontal"/>
<Button android:id="@+id/btnDot" android:text="."/>
<Button android:id="@+id/btnEquals" android:text="=" android:backgroundTint="#FF9500"/>

</GridLayout>
</LinearLayout>
```

### `MainActivity.java`

```java
package com.example.calculator;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

TextView tvDisplay, tvExpression;
double val1 = 0, val2 = 0;
char operator;
boolean newNumber = false;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

tvDisplay = findViewById(R.id.tvDisplay);
tvExpression = findViewById(R.id.tvExpression);

int[] numIds = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,
R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
for (int i = 0; i < numIds.length; i++) {
final String num = String.valueOf(i);
findViewById(numIds[i]).setOnClickListener(v -> appendNumber(num));
}

findViewById(R.id.btnDot).setOnClickListener(v -> {
String cur = tvDisplay.getText().toString();
if (!cur.contains(".")) tvDisplay.setText(cur + ".");
});

findViewById(R.id.btnAC).setOnClickListener(v -> {
tvDisplay.setText("0"); tvExpression.setText(""); val1 = 0; newNumber = false;
});

findViewById(R.id.btnPlusMinus).setOnClickListener(v -> {
double d = Double.parseDouble(tvDisplay.getText().toString());
tvDisplay.setText(format(-d));
});

findViewById(R.id.btnPercent).setOnClickListener(v -> {
double d = Double.parseDouble(tvDisplay.getText().toString());
tvDisplay.setText(format(d / 100));
});

setOperator(R.id.btnAdd, '+');
setOperator(R.id.btnSub, '−');
setOperator(R.id.btnMul, '×');
setOperator(R.id.btnDiv, '÷');

findViewById(R.id.btnEquals).setOnClickListener(v -> {
val2 = Double.parseDouble(tvDisplay.getText().toString());
double result = 0;
switch (operator) {
case '+': result = val1 + val2; break;
case '−': result = val1 - val2; break;
case '×': result = val1 * val2; break;
case '÷': result = val2 != 0 ? val1 / val2 : 0; break;
}
tvExpression.setText(format(val1) + " " + operator + " " + format(val2) + " =");
tvDisplay.setText(format(result));
newNumber = true;
});
}

void appendNumber(String n) {
String cur = tvDisplay.getText().toString();
if (newNumber || cur.equals("0")) { tvDisplay.setText(n); newNumber = false; }
else tvDisplay.setText(cur + n);
}

void setOperator(int id, char op) {
findViewById(id).setOnClickListener(v -> {
val1 = Double.parseDouble(tvDisplay.getText().toString());
operator = op; newNumber = true;
tvExpression.setText(format(val1) + " " + op);
});
}

String format(double d) {
return d == (long) d ? String.valueOf((long) d) : String.valueOf(d);
}
}
```

## 8. ONLINE SHOPPING APP

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent" android:layout_height="match_parent"
android:orientation="vertical" android:padding="16dp">

<TextView android:text="Online Store" android:textSize="22sp"
android:textStyle="bold" android:textColor="#1565C0"
android:layout_width="wrap_content" android:layout_height="wrap_content"
android:layout_marginBottom="12dp"/>

<EditText android:id="@+id/etSearch" android:hint="Search products..."
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="8dp"/>

<ListView android:id="@+id/lvProducts"
android:layout_width="match_parent" android:layout_height="0dp"
android:layout_weight="1"/>

<TextView android:id="@+id/tvTotal" android:text="Cart Total: ₹0"
android:textSize="16sp" android:textStyle="bold"
android:layout_width="wrap_content" android:layout_height="wrap_content"
android:layout_marginTop="8dp"/>

<Button android:id="@+id/btnCheckout" android:text="Checkout"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#1565C0" android:layout_marginTop="8dp"/>

</LinearLayout>
```

### `MainActivity.java`

```java
package com.example.shopping;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class MainActivity extends AppCompatActivity {

ListView lvProducts;
Button btnCheckout;
TextView tvTotal;
ArrayAdapter<String> adapter;
List<String> products = Arrays.asList(
"Smartphone - ₹14,999","Laptop Stand - ₹1,299",
"Headphones - ₹2,999","USB-C Hub - ₹899",
"Study Lamp - ₹749","Notebook Set - ₹299"
);
int[] prices = {14999, 1299, 2999, 899, 749, 299};
Set<Integer> cart = new HashSet<>();
int total = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

lvProducts = findViewById(R.id.lvProducts);
btnCheckout = findViewById(R.id.btnCheckout);
tvTotal = findViewById(R.id.tvTotal);

adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, products);
lvProducts.setAdapter(adapter);
lvProducts.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

lvProducts.setOnItemClickListener((parent, view, position, id) -> {
if (cart.contains(position)) { cart.remove(position); total -= prices[position]; }
else { cart.add(position); total += prices[position]; }
tvTotal.setText("Cart Total: ₹" + total);
});

btnCheckout.setOnClickListener(v -> {
if (cart.isEmpty()) { Toast.makeText(this, "Cart is empty", Toast.LENGTH_SHORT).show(); return; }
StringBuilder sb = new StringBuilder("Order placed!\n");
for (int i : cart) sb.append("• ").append(products.get(i)).append("\n");
sb.append("Total: ₹").append(total);
Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
});
}
}
```

## 9. EMAIL + NOTIFICATIONS

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent" android:layout_height="match_parent"
android:orientation="vertical" android:padding="16dp">

<TextView android:text="Email Notifications"
android:textSize="22sp" android:textStyle="bold" android:textColor="#1565C0"
android:layout_width="wrap_content" android:layout_height="wrap_content"
android:layout_marginBottom="12dp"/>

<EditText android:id="@+id/etTo" android:hint="To (email)"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:inputType="textEmailAddress" android:layout_marginBottom="8dp"/>

<EditText android:id="@+id/etSubject" android:hint="Subject"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="8dp"/>

<EditText android:id="@+id/etBody" android:hint="Message body..."
android:layout_width="match_parent" android:layout_height="wrap_content"
android:minLines="4" android:gravity="top" android:layout_marginBottom="12dp"/>

<Button android:id="@+id/btnSendEmail" android:text="Send Email"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#1565C0" android:layout_marginBottom="8dp"/>

<Button android:id="@+id/btnNotify" android:text="Send Notification"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#2E7D32"/>

</LinearLayout>
```

### `MainActivity.java`

```java
package com.example.emailnotif;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

static final String CHANNEL_ID = "email_channel";
EditText etTo, etSubject, etBody;
Button btnSendEmail, btnNotify;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

createNotificationChannel();

etTo = findViewById(R.id.etTo);
etSubject = findViewById(R.id.etSubject);
etBody = findViewById(R.id.etBody);
btnSendEmail = findViewById(R.id.btnSendEmail);
btnNotify = findViewById(R.id.btnNotify);

btnSendEmail.setOnClickListener(v -> {
String to = etTo.getText().toString().trim();
String subject = etSubject.getText().toString().trim();
String body = etBody.getText().toString().trim();
if (to.isEmpty() || subject.isEmpty()) {
Toast.makeText(this, "Fill recipient and subject", Toast.LENGTH_SHORT).show(); return;
}
Intent intent = new Intent(Intent.ACTION_SEND);
intent.setType("message/rfc822");
intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
intent.putExtra(Intent.EXTRA_SUBJECT, subject);
intent.putExtra(Intent.EXTRA_TEXT, body);
startActivity(Intent.createChooser(intent, "Choose Email App"));
});

btnNotify.setOnClickListener(v -> {
String subject = etSubject.getText().toString().trim();
if (subject.isEmpty()) { Toast.makeText(this,"Enter subject",Toast.LENGTH_SHORT).show(); return; }
NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
.setSmallIcon(android.R.drawable.ic_dialog_email)
.setContentTitle("New Email: " + subject)
.setContentText(etBody.getText().toString())
.setPriority(NotificationCompat.PRIORITY_DEFAULT)
.setAutoCancel(true);
NotificationManagerCompat.from(this).notify(1, builder.build());
Toast.makeText(this, "Notification sent!", Toast.LENGTH_SHORT).show();
});
}

void createNotificationChannel() {
NotificationChannel channel = new NotificationChannel(
CHANNEL_ID, "Email Channel", NotificationManager.IMPORTANCE_DEFAULT);
getSystemService(NotificationManager.class).createNotificationChannel(channel);
}
}
```

## 10. MESSAGE + NOTIFICATIONS

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent" android:layout_height="match_parent"
android:orientation="vertical" android:padding="16dp">

<TextView android:text="Message Notifications"
android:textSize="22sp" android:textStyle="bold" android:textColor="#1565C0"
android:layout_width="wrap_content" android:layout_height="wrap_content"
android:layout_marginBottom="12dp"/>

<EditText android:id="@+id/etRecipient" android:hint="Recipient Name"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="8dp"/>

<EditText android:id="@+id/etMessage" android:hint="Type your message..."
android:layout_width="match_parent" android:layout_height="wrap_content"
android:minLines="3" android:gravity="top" android:layout_marginBottom="12dp"/>

<Button android:id="@+id/btnSendMsg" android:text="Send Message"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#1565C0" android:layout_marginBottom="8dp"/>

<Button android:id="@+id/btnMsgNotify" android:text="Show Message Notification"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#6A1B9A" android:layout_marginBottom="16dp"/>

<ListView android:id="@+id/lvMessages"
android:layout_width="match_parent" android:layout_height="0dp"
android:layout_weight="1"/>

</LinearLayout>
```

### `MainActivity.java`

```java
package com.example.msgnotif;

import android.app.*;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

static final String CHANNEL_ID = "msg_channel";
EditText etRecipient, etMessage;
Button btnSendMsg, btnMsgNotify;
ListView lvMessages;
ArrayAdapter<String> adapter;
ArrayList<String> messages = new ArrayList<>();
int notifId = 100;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
createNotificationChannel();

etRecipient = findViewById(R.id.etRecipient);
etMessage = findViewById(R.id.etMessage);
btnSendMsg = findViewById(R.id.btnSendMsg);
btnMsgNotify = findViewById(R.id.btnMsgNotify);
lvMessages = findViewById(R.id.lvMessages);

adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, messages);
lvMessages.setAdapter(adapter);

btnSendMsg.setOnClickListener(v -> {
String to = etRecipient.getText().toString().trim();
String msg = etMessage.getText().toString().trim();
if (to.isEmpty() || msg.isEmpty()) { Toast.makeText(this,"Fill all fields",Toast.LENGTH_SHORT).show(); return; }
messages.add("To " + to + ": " + msg);
adapter.notifyDataSetChanged();
etMessage.setText("");
Toast.makeText(this, "Message sent to " + to, Toast.LENGTH_SHORT).show();
});

btnMsgNotify.setOnClickListener(v -> {
String to = etRecipient.getText().toString().trim();
String msg = etMessage.getText().toString().trim();
if (to.isEmpty()) { Toast.makeText(this,"Enter recipient",Toast.LENGTH_SHORT).show(); return; }
NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
.setSmallIcon(android.R.drawable.ic_dialog_info)
.setContentTitle("New message from " + to)
.setContentText(msg.isEmpty() ? "You have a new message" : msg)
.setPriority(NotificationCompat.PRIORITY_HIGH).setAutoCancel(true);
NotificationManagerCompat.from(this).notify(notifId++, builder.build());
});
}

void createNotificationChannel() {
NotificationChannel channel = new NotificationChannel(
CHANNEL_ID, "Messages", NotificationManager.IMPORTANCE_HIGH);
getSystemService(NotificationManager.class).createNotificationChannel(channel);
}
}
```

## 11. CHANGE BG COLOR, FONT STYLE, SIZE ON BUTTON CLICK

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent" android:layout_height="match_parent">

<LinearLayout android:id="@+id/mainLayout"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:orientation="vertical" android:padding="16dp">

<TextView android:text="Style Changer" android:textSize="22sp"
android:textStyle="bold" android:textColor="#1565C0"
android:layout_width="wrap_content" android:layout_height="wrap_content"
android:layout_marginBottom="12dp"/>

<TextView android:id="@+id/tvSample"
android:text="This is sample text. Press the buttons below to change style!"
android:textSize="18sp" android:padding="16dp"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:layout_marginBottom="16dp"/>

<TextView android:text="Background Color" android:textStyle="bold"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
android:orientation="horizontal" android:layout_marginBottom="12dp">
<Button android:id="@+id/btnBgWhite" android:text="White"
android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1"/>
<Button android:id="@+id/btnBgBlue" android:text="Blue"
android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1"/>
<Button android:id="@+id/btnBgGreen" android:text="Green"
android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1"/>
<Button android:id="@+id/btnBgYellow" android:text="Yellow"
android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1"/>
</LinearLayout>

<TextView android:text="Font Style" android:textStyle="bold"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
android:orientation="horizontal" android:layout_marginBottom="12dp">
<Button android:id="@+id/btnNormal" android:text="Normal"
android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1"/>
<Button android:id="@+id/btnBold" android:text="Bold"
android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1"/>
<Button android:id="@+id/btnItalic" android:text="Italic"
android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1"/>
</LinearLayout>

<TextView android:text="Font Size" android:textStyle="bold"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
android:orientation="horizontal" android:layout_marginBottom="12dp">
<Button android:id="@+id/btnSmall" android:text="Small"
android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1"/>
<Button android:id="@+id/btnMedium" android:text="Medium"
android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1"/>
<Button android:id="@+id/btnLarge" android:text="Large"
android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1"/>
</LinearLayout>

</LinearLayout>
</ScrollView>
```

### `MainActivity.java`

```java
package com.example.stylechanger;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

TextView tvSample;
LinearLayout mainLayout;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

tvSample = findViewById(R.id.tvSample);
mainLayout = findViewById(R.id.mainLayout);

// Background colors
findViewById(R.id.btnBgWhite).setOnClickListener(v -> mainLayout.setBackgroundColor(Color.WHITE));
findViewById(R.id.btnBgBlue).setOnClickListener(v -> mainLayout.setBackgroundColor(Color.parseColor("#E3F2FD")));
findViewById(R.id.btnBgGreen).setOnClickListener(v -> mainLayout.setBackgroundColor(Color.parseColor("#E8F5E9")));
findViewById(R.id.btnBgYellow).setOnClickListener(v -> mainLayout.setBackgroundColor(Color.parseColor("#FFFDE7")));

// Font styles
findViewById(R.id.btnNormal).setOnClickListener(v -> tvSample.setTypeface(null, Typeface.NORMAL));
findViewById(R.id.btnBold).setOnClickListener(v -> tvSample.setTypeface(null, Typeface.BOLD));
findViewById(R.id.btnItalic).setOnClickListener(v -> tvSample.setTypeface(null, Typeface.ITALIC));

// Font sizes
findViewById(R.id.btnSmall).setOnClickListener(v -> tvSample.setTextSize(12f));
findViewById(R.id.btnMedium).setOnClickListener(v -> tvSample.setTextSize(18f));
findViewById(R.id.btnLarge).setOnClickListener(v -> tvSample.setTextSize(26f));
}
}
```

## 12. LOGIN WITH NAME, PASSWORD, RESET & SUBMIT (Header Image + Label)

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent" android:layout_height="match_parent"
android:orientation="vertical">

<!-- Header Image Banner -->
<ImageView android:id="@+id/ivHeader"
android:layout_width="match_parent" android:layout_height="180dp"
android:scaleType="centerCrop"
android:background="#1565C0"
android:src="@drawable/ic_launcher_foreground"
android:contentDescription="Header"/>

<LinearLayout android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical" android:padding="24dp"
android:gravity="center_horizontal">

<TextView android:text="Student Portal Login"
android:textSize="24sp" android:textStyle="bold"
android:textColor="#1565C0" android:layout_marginBottom="6dp"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>

<TextView android:text="Sign in to continue"
android:textSize="14sp" android:textColor="#757575"
android:layout_marginBottom="24dp"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>

<EditText android:id="@+id/etUsername"
android:hint="Username / Student ID"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:inputType="textPersonName"
android:drawableStart="@android:drawable/ic_menu_myplaces"
android:layout_marginBottom="12dp"/>

<EditText android:id="@+id/etPassword"
android:hint="Password"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:inputType="textPassword"
android:drawableStart="@android:drawable/ic_lock_lock"
android:layout_marginBottom="24dp"/>

<Button android:id="@+id/btnSubmit"
android:text="Submit / Login"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#1565C0" android:layout_marginBottom="8dp"/>

<Button android:id="@+id/btnReset"
android:text="Reset"
android:layout_width="match_parent" android:layout_height="wrap_content"
android:backgroundTint="#C62828"/>

<TextView android:id="@+id/tvMessage" android:layout_width="wrap_content"
android:layout_height="wrap_content" android:layout_marginTop="16dp"
android:textSize="14sp"/>

</LinearLayout>
</LinearLayout>
```

### `MainActivity.java`

```java
package com.example.login;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

EditText etUsername, etPassword;
Button btnSubmit, btnReset;
TextView tvMessage;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

etUsername = findViewById(R.id.etUsername);
etPassword = findViewById(R.id.etPassword);
btnSubmit = findViewById(R.id.btnSubmit);
btnReset = findViewById(R.id.btnReset);
tvMessage = findViewById(R.id.tvMessage);

btnSubmit.setOnClickListener(v -> {
String user = etUsername.getText().toString().trim();
String pass = etPassword.getText().toString().trim();
if (user.isEmpty() || pass.isEmpty()) {
tvMessage.setText("Please fill all fields.");
tvMessage.setTextColor(0xFFC62828);
} else if (user.equals("admin") && pass.equals("1234")) {
tvMessage.setText("Login successful! Welcome, " + user);
tvMessage.setTextColor(0xFF2E7D32);
} else {
tvMessage.setText("Invalid credentials. Try admin/1234");
tvMessage.setTextColor(0xFFC62828);
}
});

btnReset.setOnClickListener(v -> {
etUsername.setText("");
etPassword.setText("");
tvMessage.setText("");
});
}
}
```

## 13. LAYOUT MANAGERS DEMO

### `activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent" android:layout_height="match_parent"
android:padding="16dp">

<LinearLayout android:layout_width="match_parent"
android:layout_height="wrap_content" android:orientation="vertical">

<TextView android:text="Layout Managers Demo"
android:textSize="22sp" android:textStyle="bold" android:textColor="#1565C0"
android:layout_width="wrap_content" android:layout_height="wrap_content"
android:layout_marginBottom="16dp"/>

<!-- LinearLayout Vertical -->
<TextView android:text="1. LinearLayout (Vertical)"
android:textStyle="bold" android:layout_width="wrap_content"
android:layout_height="wrap_content" android:layout_marginBottom="4dp"/>
<LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
android:orientation="vertical" android:background="#E3F2FD"
android:padding="8dp" android:layout_marginBottom="12dp">
<Button android:text="View 1" android:backgroundTint="#1565C0" android:layout_width="match_parent" android:layout_height="wrap_content"/>
<Button android:text="View 2" android:backgroundTint="#1976D2" android:layout_width="match_parent" android:layout_height="wrap_content" android:layout_marginTop="6dp"/>
<Button android:text="View 3" android:backgroundTint="#1E88E5" android:layout_width="match_parent" android:layout_height="wrap_content" android:layout_marginTop="6dp"/>
</LinearLayout>

<!-- LinearLayout Horizontal -->
<TextView android:text="2. LinearLayout (Horizontal)"
android:textStyle="bold" android:layout_width="wrap_content"
android:layout_height="wrap_content" android:layout_marginBottom="4dp"/>
<LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
android:orientation="horizontal" android:background="#E8F5E9"
android:padding="8dp" android:layout_marginBottom="12dp">
<Button android:text="A" android:backgroundTint="#1565C0"
android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1"/>
<Button android:text="B" android:backgroundTint="#1976D2"
android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1" android:layout_marginStart="6dp"/>
<Button android:text="C" android:backgroundTint="#1E88E5"
android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1" android:layout_marginStart="6dp"/>
</LinearLayout>

<!-- GridLayout -->
<TextView android:text="3. GridLayout (2x2)"
android:textStyle="bold" android:layout_width="wrap_content"
android:layout_height="wrap_content" android:layout_marginBottom="4dp"/>
<GridLayout android:layout_width="match_parent" android:layout_height="wrap_content"
android:columnCount="2" android:background="#FFF3E0"
android:padding="8dp" android:layout_marginBottom="12dp" android:useDefaultMargins="true">
<Button android:text="Grid 1" android:backgroundTint="#0D47A1"/>
<Button android:text="Grid 2" android:backgroundTint="#1565C0"/>
<Button android:text="Grid 3" android:backgroundTint="#1976D2"/>
<Button android:text="Grid 4" android:backgroundTint="#1E88E5"/>
</GridLayout>

<!-- RelativeLayout -->
<TextView android:text="4. RelativeLayout"
android:textStyle="bold" android:layout_width="wrap_content"
android:layout_height="wrap_content" android:layout_marginBottom="4dp"/>
<RelativeLayout android:layout_width="match_parent" android:layout_height="100dp"
android:background="#F3E5F5" android:padding="8dp" android:layout_marginBottom="12dp">
<Button android:id="@+id/btnTopLeft" android:text="Top Left"
android:backgroundTint="#1565C0"
android:layout_alignParentTop="true" android:layout_alignParentStart="true"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<Button android:text="Top Right" android:backgroundTint="#C62828"
android:layout_alignParentTop="true" android:layout_alignParentEnd="true"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<Button android:text="Center" android:backgroundTint="#2E7D32"
android:layout_centerInParent="true"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>
</RelativeLayout>

<!-- TableLayout -->
<TextView android:text="5. TableLayout"
android:textStyle="bold" android:layout_width="wrap_content"
android:layout_height="wrap_content" android:layout_marginBottom="4dp"/>
<TableLayout android:layout_width="match_parent" android:layout_height="wrap_content"
android:background="#E8F5E9" android:padding="8dp" android:layout_marginBottom="12dp"
android:stretchColumns="*">
<TableRow>
<TextView android:text="Name" android:textStyle="bold" android:padding="8dp"/>
<TextView android:text="Marks" android:textStyle="bold" android:padding="8dp"/>
<TextView android:text="Grade" android:textStyle="bold" android:padding="8dp"/>
</TableRow>
<TableRow>
<TextView android:text="Alice" android:padding="8dp"/>
<TextView android:text="92" android:padding="8dp"/>
<TextView android:text="A+" android:padding="8dp"/>
</TableRow>
<TableRow>
<TextView android:text="Bob" android:padding="8dp"/>
<TextView android:text="78" android:padding="8dp"/>
<TextView android:text="B" android:padding="8dp"/>
</TableRow>
</TableLayout>

<!-- FrameLayout -->
<TextView android:text="6. FrameLayout (Overlay)"
android:textStyle="bold" android:layout_width="wrap_content"
android:layout_height="wrap_content" android:layout_marginBottom="4dp"/>
<FrameLayout android:layout_width="match_parent" android:layout_height="80dp"
android:background="#FFEBEE">
<TextView android:text="Background Layer"
android:layout_gravity="center" android:textSize="16sp"
android:textColor="#C62828"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>
<TextView android:text="Overlay Layer (FrameLayout)"
android:layout_gravity="bottom|end" android:textSize="11sp"
android:textColor="#757575" android:padding="6dp"
android:layout_width="wrap_content" android:layout_height="wrap_content"/>
</FrameLayout>

</LinearLayout>
</ScrollView>
```

### `MainActivity.java`

```java
package com.example.layouts;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
Toast.makeText(this, "Layout Managers Demo loaded!", Toast.LENGTH_SHORT).show();
}
}

================================================================
END OF ALL PROGRAMS
================================================================
TIPS FOR ANDROID STUDIO:
- Create a new project for each app: File > New > New Project > Empty Activity
- Change the package name to match each program (e.g. com.example.bookstore)
- For SQLite apps, create DatabaseHelper.java as a separate class file
- For Notifications, add this to AndroidManifest.xml inside <uses-permission>:
<uses-permission android:name="android.permission.POST_NOTIFICATIONS"/>
- Minimum SDK: API 26 (Android 8.0) recommended
- Always run on emulator or physical device with USB debugging enabled
================================================================
```

