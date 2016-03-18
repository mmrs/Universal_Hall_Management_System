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

public class StatusDetails extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_details);
        textView = (TextView) findViewById(R.id.status);
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

                                JSONObject jsonObject1 = new JSONObject(response);
                                StudentInfo studentInfo = StaticData.studentInfos.get(StaticData.index);

                                textView.setText("Student Name : \n" + studentInfo.getName() +"\n\n"
                                 + "Reg No :\n" + studentInfo.getId() + "\n\n"
                                 + "Hall Status :   " + jsonObject.getString("type") + "\n\n"
                                 + "Last Timestamp : \n" + jsonObject.getString("day_time") +"\n\n"
                                 + "current month meal quantity" + "\n"
                                 +"BREAKFAST :  " + jsonObject.getString("BREAKFAST") + "\n"
                                 +"LUNCH     :  " + jsonObject.getString("LUNCH") + "\n"
                                 +"DINNER    :  " + jsonObject.getString("DINNER") + "\n"

                                );

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
