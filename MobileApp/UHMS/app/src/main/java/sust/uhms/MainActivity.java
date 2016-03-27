package sust.uhms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.view.Menu;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import android.view.MenuItem;
import android.widget.Toast;

import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;


public class MainActivity extends AppCompatActivity {

    Dialog passwordChangeDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);
        ListViewAdapter listViewAdapter = new ListViewAdapter(MainActivity.this);
        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(listViewAdapter);
       alphaInAnimationAdapter.setAbsListView(listView);
       alphaInAnimationAdapter.getViewAnimator().setAnimationDelayMillis(15000);
     //   alphaInAnimationAdapter.getViewAnimator().setShouldAnimateFromPosition(0);
    //    alphaInAnimationAdapter.getViewAnimator().setInitialDelayMillis(15000);

        listView.setAdapter(alphaInAnimationAdapter);
        listView.setAdapter(listViewAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id== R.id.changepassword){


            passwordChangeDialog = new Dialog(MainActivity.this);
            passwordChangeDialog.setContentView(R.layout.change_password);
            passwordChangeDialog.setTitle("Change Password : ");
            passwordChangeDialog.show();
            Button confirm = (Button) passwordChangeDialog.findViewById(R.id.confirm_password_change);
            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String oldPass = ((EditText) passwordChangeDialog.findViewById(R.id.oldpassword)).getText().toString();
                    String newPass = ((EditText) passwordChangeDialog.findViewById(R.id.password)).getText().toString();
                    String confirmpass = ((EditText) passwordChangeDialog.findViewById(R.id.confirmpassword)).getText().toString();
                    if (!confirmpass.equals(newPass)) {
                        Toast toast = Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT);
                        toast.setGravity(BIND_ABOVE_CLIENT, -0, -100);
                        toast.setText("check new password");
                        toast.show();
                        return;
                    }
                    sendRequestToUpdatePassword(oldPass, newPass);

                }
            });




        }

        return  true;
    }

    private void sendRequestToUpdatePassword(final String oldPass, final String newPass) {

        StringRequest str = new StringRequest(Request.Method.POST, "http://"+StaticData.ip+getString(R.string.server_address) + "ChangePassword",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            if(status.equals("200")){


                                StaticData.showDialog(MainActivity.this,jsonObject.getString("message"));
                                passwordChangeDialog.dismiss();

                            }
                            else if(status.equals("400")){

                                StaticData.showDialog(MainActivity.this,jsonObject.getString("error_desc"));

                            }

                        } catch (Exception e) {
                            Log.i("mmrs",e.toString());

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                StaticData.showDialog(MainActivity.this,error.toString());


            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String>params = new HashMap<>();
                params.put("phone",StaticData.phone);
                params.put("oldpassword",oldPass);
                params.put("newpassword",newPass);
                return params;
            }
        };

        RequestManager.getRequestQueue(MainActivity.this).add(str);



    }

}
