package sust.uhms;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Siyam on 12-Mar-16.
 */
public class ListViewAdapter extends BaseAdapter {

    Activity activity;
    public ListViewAdapter(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    @Override
    public int getCount() {
        return StaticData.studentInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(activity).inflate(R.layout.itemlistview,parent,false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView regno = (TextView) convertView.findViewById(R.id.regno);
        TextView dept = (TextView) convertView.findViewById(R.id.dept);
        TextView session = (TextView) convertView.findViewById(R.id.session);
        name.setText("Name : " +(StaticData.studentInfos.get(position)).getName());
        regno.setText("Reg No : " +(StaticData.studentInfos.get(position)).getId() + "");
        dept.setText("Dept. : " +(StaticData.studentInfos.get(position)).getDept());
        session.setText("Session : " +(StaticData.studentInfos.get(position)).getSession());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StaticData.index = position;
                activity.startActivity(new Intent(activity, StatusDetails.class));

            }
        });

        return convertView;
    }
}
