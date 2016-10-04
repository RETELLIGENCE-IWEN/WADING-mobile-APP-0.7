/*
 * MIT License
 *
 * Copyright (c) [year] [fullname]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.wading.retelligence.wading;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.multidex.MultiDex;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.ActionBar;


public class MainActivity extends AppCompatActivity{

    Button button;
    Button buttonsign;
    EditText editTextName, editTextId, editTextPd;
    TextView textResponse;
    Boolean login= false;
    TextView grid1,grid2,grid3,grid4,grid5,grid6,grid7,grid8,grid9,grid12,grid13,grid14,grid15,grid16,grid17,grid18,grid19,grid20,grid21,grid22,grid23,grid24,grid10, grid11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentViewById(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        buttonsign = (Button) findViewById(R.id.buttonsign);
        grid10 = (TextView) findViewById(R.id.grid10);
        grid11 = (TextView) findViewById(R.id.grid11);
        grid12 = (TextView) findViewById(R.id.grid12);
        grid13 = (TextView) findViewById(R.id.grid13);
        grid14 = (TextView) findViewById(R.id.grid14);
        grid15 = (TextView) findViewById(R.id.grid15);
        grid16 = (TextView) findViewById(R.id.grid16);
        grid17 = (TextView) findViewById(R.id.grid17);
        grid18 = (TextView) findViewById(R.id.grid18);
        grid19 = (TextView) findViewById(R.id.grid19);
        grid20 = (TextView) findViewById(R.id.grid20);
        grid21 = (TextView) findViewById(R.id.grid21);
        grid22 = (TextView) findViewById(R.id.grid22);
        grid23 = (TextView) findViewById(R.id.grid23);
        grid24 = (TextView) findViewById(R.id.grid24);
        grid1 = (TextView) findViewById(R.id.grid1);
        grid2 = (TextView) findViewById(R.id.grid2);
        grid3 = (TextView) findViewById(R.id.grid3);
        grid4 = (TextView) findViewById(R.id.grid4);
        grid5 = (TextView) findViewById(R.id.grid5);
        grid6 = (TextView) findViewById(R.id.grid6);
        grid7 = (TextView) findViewById(R.id.grid7);
        grid8 = (TextView) findViewById(R.id.grid8);
        grid9 = (TextView) findViewById(R.id.grid9);
    }
    private int currentViewId = -1;

    public void setCurrentViewById(int id)
    {
        setContentView(id);
        currentViewId = id;
    }

    public int getCurrentViewById()
    {
        return currentViewId;
    }
    public void buttonClicked(View view){
        if(view.getId() == R.id.button){
            setCurrentViewById(R.layout.activity_login);
        }
        else if(view.getId() == R.id.buttonsign){
            editTextName = (EditText)findViewById(R.id.name);
            editTextId = (EditText)findViewById(R.id.id);
            editTextPd = (EditText)findViewById(R.id.pd);
            textResponse=(TextView)findViewById(R.id.response);
            Server_call obj=new Server_call(editTextName.getText().toString()
                    , editTextId.getText().toString(), editTextPd.getText().toString(), textResponse);
            try {
                obj.execute();
                if(obj.log){
                    login=true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
        else if(view.getId() == R.id.buttonback||view.getId() == R.id.buttonback2||view.getId() == R.id.buttonback3||view.getId() == R.id.buttonback4||view.getId() == R.id.buttonback5||view.getId() == R.id.buttonback6||view.getId() == R.id.buttonback7){
            setCurrentViewById(R.layout.activity_main);
        }
        else if(view.getId() == R.id.button2) {
            setCurrentViewById(R.layout.activity_track);
            grid10 = (TextView) findViewById(R.id.grid10);
            grid11 = (TextView) findViewById(R.id.grid11);
            TrackActivity ob = new TrackActivity(grid10, grid11);
            ob.execute();
        }
        else if(view.getId() == R.id.button3){
            setCurrentViewById(R.layout.activity_wad);
        }
        else if(view.getId() == R.id.button4){
            setCurrentViewById(R.layout.activity_flight);
        }
        else if(view.getId() == R.id.button5){
            Intent intentSubActivity = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intentSubActivity);
        }
        else if(view.getId() == R.id.button6){
            setCurrentViewById(R.layout.activity_donate);
        }
        else if(view.getId() == R.id.button8) {
            setCurrentViewById(R.layout.activity_setting);
        }
        else if(view.getId() == R.id.button7){
            Intent intent = new Intent(MainActivity.this, AssistActivity.class);
            startActivity(intent);
        }
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
