package com.itesm.bookland;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends AppCompatActivity {
    EditText email_destination, email_subject, email_message;
    Button button_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        //imagen2=findViewById(R.id.imagen);
        //String url="http://androidstorepddm.000webhostapp.com/images/blue.jpg";
        //Picasso.get().load(url).into(imagen2);

       /* URL newurl = null;
        try {
            newurl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap mIcon_val = null;
        try {
            mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        imagen2.setImageBitmap(mIcon_val);*/

        email_destination = (EditText)findViewById(R.id.txtTo);
        email_subject = (EditText)findViewById(R.id.txtSub);
        email_message = (EditText)findViewById(R.id.txtMsg);

        button_send = (Button)findViewById(R.id.btnSend);

        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{email_destination.getText().toString()});
                it.putExtra(Intent.EXTRA_SUBJECT,email_subject.getText().toString());
                it.putExtra(Intent.EXTRA_TEXT,email_message.getText());
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it,"Choose Mail App"));
            }
        });
    }
}

