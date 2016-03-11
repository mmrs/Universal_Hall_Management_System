package sust.uhms;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Siyam on 12-Mar-16.
 */
public class RequestManager {

    static RequestQueue requestQueue = null;

    static RequestQueue getRequestQueue(Context context){

        if(requestQueue!= null){
            return requestQueue;
        }
        else {
            requestQueue = Volley.newRequestQueue(context);
            return  requestQueue;
        }
    }



}
