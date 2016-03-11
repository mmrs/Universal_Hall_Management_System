package sust.uhms;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import java.util.ArrayList;

/**
 * Created by Siyam on 12-Mar-16.
 */
public class StaticData {

    static String phone,password;
    static ArrayList<StudentInfo> studentInfos = new ArrayList<>();



    static void showDialog(Context context ,String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }
}
