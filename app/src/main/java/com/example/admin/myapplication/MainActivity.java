package com.example.admin.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity
{
    private static final int PICK_CONTACT = 0;
    Button sendBtn ;
    EditText txtphoneNo;
    EditText txtMessage ;
    TextView tv ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        sendBtn = (Button)findViewById(R.id.button) ;
        txtphoneNo = (EditText) findViewById(R.id.editText1) ;
        txtMessage = (EditText) findViewById(R.id.editText2) ;
        tv = (TextView) findViewById(R.id.textView);

        sendBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendSMSMessage() ;
            }
        });
    }

    private void sendSMSMessage()
    {
        Log.i("Send SMS", "") ;
        String phoneNo = txtphoneNo.getText().toString() ;
        String message = txtMessage.getText().toString() ;

        try
        {
            SmsManager smsManager = SmsManager.getDefault() ;
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG ).show();
            tv.setText(txtMessage.getText());
            tv.setVisibility(View.VISIBLE);
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again !", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
