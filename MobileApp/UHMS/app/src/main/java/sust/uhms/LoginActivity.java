package sust.uhms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = mEmailView.getText().toString();
                String password = mPasswordView.getText().toString();
                if(phone.isEmpty() || password.isEmpty()){

                    Toast.makeText(LoginActivity.this,"Check Phone Number or Password",Toast.LENGTH_SHORT).show();
                    return;
                }

                StaticData.phone = phone;
                StaticData.password = password;
                StaticData.ip = ((EditText)findViewById(R.id.ip)).getText().toString();
                mPasswordView.setText("");
                mProgressView.setVisibility(View.VISIBLE);
                attempLogIn(phone, password);


            }
        });
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void attempLogIn(final String phone, final String password) {

      StringRequest str = new StringRequest(Request.Method.POST, "http://"+StaticData.ip+getString(R.string.server_address) + "logInAuthentication",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        mProgressView.setVisibility(View.GONE);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            if(status.equals("200")){

                                JSONArray jsonArray = jsonObject.getJSONArray("info");
                                Log.i("mmrs",jsonArray.toString());
                                StaticData.studentInfos.clear();
                             //   StudentInfo studentInfo = new StudentInfo();
                                for(int i=0;i<jsonArray.length();i++){
                                    jsonObject = jsonArray.getJSONObject(i);
                                    StudentInfo studentInfo = new StudentInfo();
                                    studentInfo.setId(jsonObject.getInt("student_id"));
                                    studentInfo.setName(jsonObject.getString("student_name"));
                                    studentInfo.setDept(jsonObject.getString("student_dept"));
                                    studentInfo.setSession(jsonObject.getString("student_session"));
                                    StaticData.studentInfos.add(studentInfo);
                                }

                                startActivity(new Intent(LoginActivity.this,MainActivity.class));

                            }
                            else if(status.equals("400")){

                                StaticData.showDialog(LoginActivity.this,jsonObject.getString("error_desc"));

                            }

                        } catch (Exception e) {
                            Log.i("mmrs",e.toString());

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                mProgressView.setVisibility(View.GONE);
                StaticData.showDialog(LoginActivity.this,error.toString());


            }
        }){
          @Override
          protected Map<String, String> getParams() throws AuthFailureError {

               Map<String,String>params = new HashMap<>();
              params.put("phone",phone);
              params.put("password",password);
              return params;
          }
      };

        RequestManager.getRequestQueue(LoginActivity.this).add(str);

    }
}
