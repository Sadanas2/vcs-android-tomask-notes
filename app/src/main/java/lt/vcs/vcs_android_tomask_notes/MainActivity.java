package lt.vcs.vcs_android_tomask_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "app_test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Note> notes=new ArrayList<>();

        Random random= new Random();
        Note note;
        int i=1;
        while(i<=10){
            note=new Note(i,"Name"+i,"Content"+i+" - "+random.nextInt(100000));
            notes.add(note);
            i++;

        }
        notes.add(new Note(1,"Name1","Content1"));
        notes.add(new Note(2,"Name2","Content2"));
        notes.add(new Note(3,"Name3","Content3"));
        notes.add(new Note(4,"Name4","Content4"));
        notes.add(new Note(5,"Name5","Content5"));

        ArrayAdapter<Note> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);

        ListView listView= findViewById(R.id.listView);

        listView.setAdapter(arrayAdapter);


        AdapterView.OnItemClickListener listener= new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick"+position);
            }
        };
        listView.setOnItemClickListener(listener);
    }

}