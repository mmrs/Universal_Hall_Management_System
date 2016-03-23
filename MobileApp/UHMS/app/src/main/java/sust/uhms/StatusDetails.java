package sust.uhms;

import android.content.Intent;
import android.net.Uri;
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
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import android.widget.TextView;
import  android.widget.LinearLayout;

public class StatusDetails extends AppCompatActivity {

    LinearLayout linearstatus;
    View scroll,progressView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_details);
        linearstatus = (LinearLayout) findViewById(R.id.linear2);
        progressView = findViewById(R.id.login_progress2);
        scroll = findViewById(R.id.scrollViewInDetaisl);

        getStatus();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void getStatus() {

        StringRequest str = new StringRequest(Request.Method.POST, "http://" + StaticData.ip + getString(R.string.server_address) + "CheckHallStatus",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            if (status.equals("200")) {


                                scroll.setVisibility(View.VISIBLE);
                                if (jsonObject.getString("type").equals("OUT")) {

                                    linearstatus.setBackgroundDrawable(getDrawable(R.drawable.red));

                                }
                                progressView.setVisibility(View.GONE);
                                StudentInfo studentInfo = StaticData.studentInfos.get(StaticData.index);
                                ((TextView) findViewById(R.id.name)).setText("student name : " + studentInfo.getName());
                                ((TextView) findViewById(R.id.regno)).setText("reg. no : " + studentInfo.getId() + "");
                                ((TextView) findViewById(R.id.session)).setText("session : " + studentInfo.getSession());
                                ((TextView) findViewById(R.id.dept)).setText("dept. : " + studentInfo.getDept());
                                ((TextView) findViewById(R.id.gardiannmae)).setText("gardian name : " + studentInfo.getGardianname());
                                ((TextView) findViewById(R.id.relation)).setText("gardian relation : " + studentInfo.getGardianrekation());


                                ((TextView) findViewById(R.id.hallstatus)).setText(jsonObject.getString("type"));


                                ((TextView) findViewById(R.id.breakfast)).setText("BREAKFAST : " + jsonObject.getString("BREAKFAST"));
                                ((TextView) findViewById(R.id.lunch)).setText("LUNCH : " + jsonObject.getString("LUNCH"));
                                ((TextView) findViewById(R.id.dinner)).setText("DINNER : " + jsonObject.getString("DINNER"));
                                ((TextView) findViewById(R.id.mealrate)).setText("Meal Rate : " + jsonObject.getString("meal_rate"));

                                Double cost = Double.parseDouble("" + jsonObject.getString("BREAKFAST"));
                                cost +=  Double.parseDouble("" + jsonObject.getString("LUNCH"));
                                cost +=  Double.parseDouble("" + jsonObject.getString("DINNER"));
                                cost*= Double.parseDouble("" + jsonObject.getString("meal_rate"));
                                ((TextView) findViewById(R.id.totalcostinstatus)).setText("Total Cost : " + cost);

                            } else if (status.equals("400")) {

                                StaticData.showDialog(StatusDetails.this, jsonObject.getString("error_desc"));

                            }

                        } catch (Exception e) {
                         //   Log.i("mmrs", e.toString());

                        }
                        progressView.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                StaticData.showDialog(StatusDetails.this, error.toString());
                progressView.setVisibility(View.GONE);


            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("phone", StaticData.phone);
                params.put("password", StaticData.password);
                params.put("id", (StaticData.studentInfos.get(StaticData.index)).getId() + "");
                return params;
            }
        };

        RequestManager.getRequestQueue(StatusDetails.this).add(str);

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "StatusDetails Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://sust.uhms/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "StatusDetails Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://sust.uhms/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
