package com.dev.simplyhealthy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity
{

    private String[][] packages =
    {
            {"Package 1 : Full Body Checkup", "", "", "", "999"},
            {"Package 2 : Blood Test", "", "", "", "130"},
            {"Package 3 :COVID-19 Antibody", "", "", "", "150"},
            {"Package 4 : Dental X-Rays", "", "", "", "500"},
            {"Package 5 : ECG", "", "", "", "400"},
            {"Package 6 : Nutritionist", "", "", "", "200"},
    };
    private String[] package_details =
            {
            "1] Blood Glucose Fasting.\n" + "2] Complete Hemogram.\n" + "3] Iron Studies.\n" + "4] Kidney Functn Test.\n" + "5] LDH Lactate Dehydrogenase, Serum.\n" +  "6] Electrocardiogram (ECG).\n" + "7] Liver Function Test.",
            "* Blood Glucose Fasting. *",
            "* COVID-19 Antibody - IgG. *",
            "* Dental X-Rays. *",
            "* Electrocardiogram (ECG). *",
            "* Nutritionist. *"

    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listView;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);




        btnBack = findViewById(R.id.buttonOD1Back);
        listView = findViewById(R.id.listViewOD);

        btnBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<packages.length;i++)
        {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:" + packages[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] { "line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });


    }
}