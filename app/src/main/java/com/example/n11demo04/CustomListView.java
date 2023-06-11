package com.example.n11demo04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.n11demo04.Adapters.CustomAdapter;
import com.example.n11demo04.Adapters.StateAdapter;
import com.example.n11demo04.Models.State;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomListView extends AppCompatActivity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    private ListView lVcustom;
    private String[] names, capitals;
    private int[] flags;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        initAll();

        customAdapter = new CustomAdapter(this, flags, names);
        lVcustom.setAdapter(customAdapter);
        lVcustom.setOnItemClickListener(this);
        lVcustom.setOnItemLongClickListener(this);
    }

    private void initAll() {
        lVcustom = findViewById(R.id.lVcostum);

        names = new String[]
                {
                        "Alabama","Alaska","Arizona","Arkansas","California","Colorado",
                        "Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois",
                        "Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland",
                        "Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana",
                        "Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York",
                        "North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania",
                        "Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah",
                        "Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"
                };
        flags = new int[]
                {
                        R.drawable.al, R.drawable.ak, R.drawable.az, R.drawable.ar, R.drawable.ca,
                        R.drawable.co, R.drawable.ct, R.drawable.de, R.drawable.fl, R.drawable.ga,
                        R.drawable.hi, R.drawable.id, R.drawable.il, R.drawable.in, R.drawable.ia,
                        R.drawable.ks, R.drawable.ky, R.drawable.la, R.drawable.me, R.drawable.md,
                        R.drawable.ma, R.drawable.mi, R.drawable.mn, R.drawable.ms, R.drawable.mo,
                        R.drawable.mt, R.drawable.ne, R.drawable.nv, R.drawable.nh, R.drawable.nj,
                        R.drawable.nm, R.drawable.ny, R.drawable.nc, R.drawable.nd, R.drawable.oh,
                        R.drawable.ok, R.drawable.or, R.drawable.pa, R.drawable.ri, R.drawable.sc,
                        R.drawable.sd, R.drawable.tn, R.drawable.tx, R.drawable.ut, R.drawable.vt,
                        R.drawable.va, R.drawable.wa, R.drawable.wv, R.drawable.wi, R.drawable.wy
                };
        capitals = new String[]
                {
                        "Montgomery","Juneau","Phoenix","Little Rock","Sacramento","Denver",
                        "Hartford","Dover","Tallahassee","Atlanta","Honolulu","Boise","Springfield",
                        "Indianapolis","Des Moines","Topeka","Frankfort","Baton Rouge","Augusta",
                        "Annapolis","Boston","Lansing","St. Paul","Jackson","Jefferson City",
                        "Helena","Lincoln","Carson City","Concord","Trenton","Santa Fe","Albany",
                        "Raleigh","Bismarck","Columbus","Oklahoma City","Salem","Harrisburg",
                        "Providence","Columbia","Pierre","Nashville","Austin","Salt Lake City",
                        "Montpelier","Richmond","Olympia","Charleston","Madison","Cheyenne"
                };
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "The capital is "+ capitals[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete state")
                .setMessage("Are you sure you want to delete "+names[position]+"?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteState(position);
                        // Perform any action when the "OK" button is clicked
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return true;
    }

    private void deleteState(int position) {
        ArrayList<String> namesList = new ArrayList<String>();
        ArrayList<String> capitalsList = new ArrayList<String>();
        ArrayList<Integer> flagsList = new ArrayList<Integer>();
        for (int i = 0; i < flags.length; i++) {
            namesList.add(names[i]);
            capitalsList.add(capitals[i]);
            flagsList.add(flags[i]);
        }
        namesList.remove(position);
        capitalsList.remove(position);
        flagsList.remove(position);
        names = new String[names.length-1];
        capitals = new String[capitals.length-1];
        flags = new int[flags.length-1];
        for (int i = 0; i < names.length-1; i++) {
            names[i] = namesList.get(i);
            capitals[i] = capitalsList.get(i);
            flags[i] = flagsList.get(i);
        }
        customAdapter = new CustomAdapter(this, flags, names);
        lVcustom.setAdapter(customAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}