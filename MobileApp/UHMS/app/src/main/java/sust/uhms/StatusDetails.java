package sust.uhms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import android.widget.TextView;
import  android.widget.LinearLayout;

public class StatusDetails extends AppCompatActivity {

    LinearLayout linearstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_details);
        linearstatus = (LinearLayout) findViewById(R.id.linear2);
        getStatus();
    }

    private void getStatus() {

        StringRequest str = new StringRequest(Request.Method.POST, "http://"+StaticData.ip+getString(R.string.server_address) + "CheckHallStatus",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            if(status.equals("200")){



                                if(jsonObject.getString("type").equals("OUT")){

                                    linearstatus.setBackgroundDrawable(getDrawable(R.drawable.red));

                                }

                                StudentInfo studentInfo = StaticData.studentInfos.get(StaticData.index);
                                ((TextView)findViewById(R.id.name)).setText("student name : "+studentInfo.getName());
                                ((TextView)findViewById(R.id.regno)).setText("reg. no : "+studentInfo.getId() +"");
                                ((TextView)findViewById(R.id.session)).setText("session : "+studentInfo.getSession());
                                ((TextView)findViewById(R.id.dept)).setText("dept. : "+studentInfo.getDept());
                                ((TextView)findViewById(R.id.gardiannmae)).setText("gardian name : "+studentInfo.getGardianname());
                                ((TextView)findViewById(R.id.relation)).setText("gardian relation : "+studentInfo.getGardianrekation());


                                ((TextView)findViewById(R.id.hallstatus)).setText(jsonObject.getString("type"));


                                ((TextView)findViewById(R.id.breakfast)).setText("BREAKFAST : "+jsonObject.getString("BREAKFAST"));
                                ((TextView)findViewById(R.id.lunch)).setText("LUNCH : "+jsonObject.getString("LUNCH"));
                                ((TextView)findViewById(R.id.dinner)).setText("DINNER : " +jsonObject.getString("DINNER"));


                            }
                            else if(status.equals("400")) {

                                StaticData.showDialog(StatusDetails.this,jsonObject.getString("error_desc"));

                            }

                        } catch (Exception e) {
                            Log.i("mmrs",e.toString());

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                StaticData.showDialog(StatusDetails.this,error.toString());


            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String>params = new HashMap<>();
                params.put("phone",StaticData.phone);
                params.put("password", StaticData.password);
                params.put("id", (StaticData.studentInfos.get(StaticData.index)).getId() + "");
                return params;
            }
        };

        RequestManager.getRequestQueue(StatusDetails.this).add(str);

    }
}
