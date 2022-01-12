package lt.vcs.vcs_android_tomask_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> notes=new ArrayList<>();

        notes.add("1-Name1-Content1");
        notes.add("2-Name2-Content2");
        notes.add("3-Name3-Content3");
        notes.add("4-Name4-Content4");
        notes.add("5-Name5-Content5");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);

        ListView listView= findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);


    }

}