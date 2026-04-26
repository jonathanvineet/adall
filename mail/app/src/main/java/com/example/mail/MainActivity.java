package com.example.mail;


import android.app.*; import android.os.Bundle;
import android.os.AsyncTask; import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class MainActivity extends AppCompatActivity {
    static final String CH_ID = "email_channel";
    EditText etTo, etSubject, etBody;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTo      = findViewById(R.id.etTo);
        etSubject = findViewById(R.id.etSubject);
        etBody    = findViewById(R.id.etBody);
        createNotificationChannel();
        findViewById(R.id.btnSend).setOnClickListener(v -> sendEmail());
    }


    void sendEmail() {
        String to = etTo.getText().toString();
        String sub= etSubject.getText().toString();
        String body= etBody.getText().toString();


        new AsyncTask<Void,Void,Boolean>(){
            @Override protected Boolean doInBackground(Void... v){
                try {
                    Properties p = new Properties();
                    p.put("mail.smtp.auth","true");
                    p.put("mail.smtp.starttls.enable","true");
                    p.put("mail.smtp.host","smtp.gmail.com");
                    p.put("mail.smtp.port","587");
                    Session s = Session.getInstance(p, new Authenticator(){
                        protected PasswordAuthentication getPasswordAuthentication(){
                            return new PasswordAuthentication("YOUR_GMAIL","YOUR_APP_PASSWORD");
                        }
                    });
                    Message msg = new MimeMessage(s);
                    msg.setFrom(new InternetAddress("YOUR_GMAIL"));
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                    msg.setSubject(sub);
                    msg.setText(body);
                    Transport.send(msg);
                    return true;
                } catch(Exception e){ return false; }
            }
            @Override protected void onPostExecute(Boolean ok){
                Toast.makeText(MainActivity.this, ok?"Sent!":"Failed!", Toast.LENGTH_SHORT).show();
                if(ok) showNotification("Email Sent","Message delivered to "+to);
            }
        }.execute();
    }


    void showNotification(String title, String msg){
        NotificationCompat.Builder b = new NotificationCompat.Builder(this, CH_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_email)
                .setContentTitle(title).setContentText(msg)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        ((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).notify(1, b.build());
    }


    void createNotificationChannel(){
        NotificationChannel ch = new NotificationChannel(CH_ID,"Email",
                NotificationManager.IMPORTANCE_DEFAULT);
        ((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).createNotificationChannel(ch);
    }
}
