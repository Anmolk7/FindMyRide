package com.example.anmol.findmyride;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {
    SharedPreferences sf;
    public static final String preference="pref";
    public static  String saveIt="saveKey";
    public static  String save="saveKey";

    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        sf = getSharedPreferences(preference, Context.MODE_PRIVATE);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etAge = (EditText) findViewById(R.id.etAge);
        final TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomemsg);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        String phone = intent.getStringExtra("phone");

        SharedPreferences.Editor editor=sf.edit();

        editor.putString(saveIt,phone);
        editor.commit();

        intent.putExtra("phone",sf.getString(saveIt,"").toString());

        String message = "Welcome "+name;
        tvWelcomeMsg.setText(message);
        etUsername.setText(username);
        etAge.setText(phone);

       editor.putString(save,etAge.getText().toString());
        editor.commit();
        //String value=sf.getString(save,"");
       // Send();
        Intent i=new Intent();
        i.setAction("com.example.anmol.findmyride.UserAreaActivity");
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        i.putExtra("save",sf.getString(save,""));
        sendBroadcast(i);






    }
  /*  public String Send()
    {
        final EditText etAge = (EditText) findViewById(R.id.etAge);
        sf = getSharedPreferences(preference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sf.edit();

        editor.putString(save,etAge.getText().toString());
        editor.commit();
        String value=sf.getString(save,"");
        return value;

    }*/
    public void home(View view)
    {
        startActivity(new Intent(UserAreaActivity.this,MainActivity.class));
    }
}
