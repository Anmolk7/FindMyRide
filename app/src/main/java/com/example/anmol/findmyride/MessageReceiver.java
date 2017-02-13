package com.example.anmol.findmyride;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.widget.Toast;

/**
 * Created by Anmol on 1/23/2017.
 */

public class MessageReceiver  extends BroadcastReceiver {
    SharedPreferences sf;
    public static final String preference="pref";
    public static  String saveIt="saveKey";

    @Override
    public void onReceive(Context context,Intent intent)
    {
        //intent = new Intent(context,MainActivity.class);
        //context.startActivity(intent);
        ///here start the activity
        //
       // startActivity(new Intent(MainActivity.this,LoginActivity.class));
        //Intent j = new Intent();
        //j.setClassName("com.example.anmol.findmyride", "com.example.anmol.findmyride.MainActivity");
        //j.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //context.startActivity(j);

        sf = context.getSharedPreferences(preference,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sf.edit();
        editor.putString(saveIt,intent.getStringExtra("save"));
        editor.commit();
       // String no=intent.getStringExtra("save");
        Toast.makeText(context,sf.getString(saveIt,""), Toast.LENGTH_SHORT).show();
        //Save s=new Save();
        //String no=s.Send();
       // UserAreaActivity u=new UserAreaActivity();
     //  String no=u.Send().toString();
        //Toast.makeText(context,no, Toast.LENGTH_SHORT).show();
        Bundle bundle = intent.getExtras();
        SmsMessage[] messages;
        String str = "";
        String number = "";
       // int c=0;
        if (bundle != null)
        {
            Object[] pdus = (Object[]) bundle.get("pdus");//portable description object
            messages = new SmsMessage[pdus != null ? pdus.length : 0];
            for (int i = 0; i < messages.length; i++)
            {
                messages[i] = SmsMessage.createFromPdu(pdus != null ? (byte[]) pdus[i] : null);
                number += messages[i].getOriginatingAddress();
                str += messages[i].getMessageBody();
                str += "\n";
            }
         //   c=c+1;
           // Toast.makeText(context,String.valueOf(c),Toast.LENGTH_SHORT).show();

            if (number.equals("9779823614609"))
            {
                Intent broadcastIntent = new Intent();
                broadcastIntent.setAction("SMS_RECEIVED_ACTION");
                broadcastIntent.putExtra("message", str);
                context.sendBroadcast(broadcastIntent);
            }
        }
    }
}
