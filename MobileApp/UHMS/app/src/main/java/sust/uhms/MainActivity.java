package sust.uhms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;

public class MainActivity extends AppCompatActivity {

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
}
