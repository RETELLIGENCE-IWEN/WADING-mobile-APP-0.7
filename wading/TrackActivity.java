package com.wading.retelligence.wading;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


public class TrackActivity extends AsyncTask<Void, Void, Void> {

    String tk;
    TextView grid1,grid2,grid3,grid4,grid5,grid6,grid7,grid8,grid9,grid12,grid13,grid14,grid15,grid16,grid17,grid18,grid19,grid20,grid21,grid22,grid23,grid24,grid10, grid11;
    TrackActivity(TextView g10,TextView g11)
    {
        tk="";
        grid10=g10;
        grid11=g11;
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        Socket socket = null;
        try {
            socket = new Socket("175.126.112.136", 12003);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream outToServer= new DataOutputStream(socket.getOutputStream());
            tk=inFromServer.readLine();
            outToServer.writeUTF("1");
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        if (tk.equals("10")) {
            grid10.setBackgroundColor(Color.rgb(255, 0, 0));
            grid11.setBackgroundColor(Color.rgb(255,255,255));
        }
        else if(tk.equals("01"))
        {
            grid11.setBackgroundColor(Color.rgb(255,0,0));
            grid10.setBackgroundColor(Color.rgb(255, 255, 255));
        }
        super.onPostExecute(result);
    }

}

