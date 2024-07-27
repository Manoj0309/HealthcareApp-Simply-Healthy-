package com.dev.simplyhealthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name :Dr.Prabhu Dass","Hospital Address :No.90/4,Hosur Main Road,Anekal(T)","Exp :10yrs", "Mobile No:09663000065","350"},
                    {"Doctor Name :Dr.Sachin", "Hospital Address :No.258/A,Bommasandra,Hosur Main Road,Anekal(T)","Exp :7yrs", "Mobile No:08067506870","700"},
                    {"Doctor Name :Dr.Varun yadhav", "Hospital Address :jayanagara 9th Block,Bengaluru","Exp :8.5yrs", "Mobile No:08022977229","800",},
                    {"Doctor Name :Dr.Mnjunath", "Hospital Address :HAL,kodihalli,Bengaluru","Exp :9yrs", "Mobile No:18001024647","800"},
                    {"Doctor Name :Dr.karthik kumar", "Hospital Address :Bannerghatta","Exp :10yrs", "Mobile No:08026304050","900"},

            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name :Dr.Deepa","Hospital Address :No.90/4,Hosur Main Road,Anekal(T)","Exp :8yrs", "Mobile No:09663000065","450"},
                    {"Doctor Name :Dr.Ajay", "Hospital Address :No.258/A,Bommasandra,Hosur Main Road,Anekal(T)","Exp :6yrs", "Mobile No:08067506870","700"},
                    {"Doctor Name :Dr.Vismay", "Hospital Address :jayanagara 9th Block,Bengaluru","Exp :4yrs", "Mobile No:08022977229","500",},
                    {"Doctor Name :Dr.Anil", "Hospital Address :HAL,kodihalli,Bengaluru","Exp :9yrs", "Mobile No:18001024647","800"},
                    {"Doctor Name :Dr.Nagraj", "Hospital Address :Bannerghatta","Exp :11yrs", "Mobile No:08026304050","1000"},

            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name :Dr.Kishan","Hospital Address :Anekal","Exp :18yrs", "Mobile No:09663000065","900"},
                    {"Doctor Name :Dr.Yogitha", "Hosur ","Exp :7yrs", "Mobile No:08067506870","600"},
                    {"Doctor Name :Dr.Namrutha", "Hospital Address :jayanagara ,Bengaluru","Exp :5yrs", "Mobile No:08022977229","700",},
                    {"Doctor Name :Dr.Mnjunath", "Hospital Address :HAL,kodihalli,Bengaluru","Exp :9yrs", "Mobile No:18001024647","800"},
                    {"Doctor Name :Dr.kumar", "Hospital Address :Bannerghatta","Exp :4yrs", "Mobile No:08026304050","400"},

            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name :Dr.Girish","Hospital Address :No.90/4,Hosur ","Exp :10yrs", "Mobile No:09663000065","1200"},
                    {"Doctor Name :Dr.Aishwarya", "Hospital Address :No.258/A,Bommasandra","Exp :5yrs", "Mobile No:08067506870","6500"},
                    {"Doctor Name :Dr.Varun ", "Hospital Address :jayanagara 9th Block,Bengaluru","Exp :8.5yrs", "Mobile No:08022977229","800",},
                    {"Doctor Name :Dr.Mnju", "Hospital Address :HAL","Exp :9.6yrs", "Mobile No:18001024647","700"},
                    {"Doctor Name :Dr.kirthi", "Hospital Address :Bannerghatta","Exp :10yrs", "Mobile No:08026304050","900"},

            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name :Dr.Amrutha","Hospital Address :No.90/4,Electronic city","Exp:10yrs","Mobile No:09663000065","650"},
                    {"Doctor Name :Dr.Naryan", "Hospital Address :No.258/A,Bommasandra,Hosur Main Road,Anekal(T)","Exp :7yrs", "Mobile No:08067506870","700"},
                    {"Doctor Name :Dr.Vasuki", "Hospital Address :jayanagara 9th Block,Bengaluru","Exp :8.5yrs", "Mobile No:08022977229","800",},
                    {"Doctor Name :Dr.Jayanth", "Hospital Address :HAL,kodihalli,Bengaluru","Exp :9yrs", "Mobile No:18001024647","800"},
                    {"Doctor Name :Dr.Parashanth", "Hospital Address :Bannerghatta","Exp:10yrs", "Mobile No:08026304050","900"},

            };
    TextView tv;
    Button btn;
    String[][] doctor_details ={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        Toast.makeText(getApplicationContext(), "DOCTOR DETAILS", Toast.LENGTH_LONG).show();

        tv = findViewById(R.id.textViewTitle);
        btn = findViewById(R.id.buttonOD1Back);


        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);

        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst =findViewById(R.id.listViewOD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);

            }
        });

    }
}