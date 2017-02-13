package com.example.anmol.findmyride;

import android.content.Intent;

/**
 * Created by Anmol on 2/7/2017.
 */
public class Save {

    public String Send()
    {
       Intent intent=new Intent();
        String val=intent.getStringExtra("save");
        //Toast.makeText(context,val+"hello",Toast.LENGTH_SHORT).show();
        return val;
    }

}
