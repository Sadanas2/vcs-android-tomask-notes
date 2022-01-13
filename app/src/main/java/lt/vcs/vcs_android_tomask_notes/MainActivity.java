package lt.vcs.vcs_android_tomask_notes;

import androidx.annotation.NonNull;
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

        ListView listView= findViewById(R.id.listView);

        UseCaseRepository useCaseRepository= new UseCaseRepository();

        setUpListView(useCaseRepository, listView);

        AdapterView.OnItemClickListener listener= new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick"+position);
            }
        };
        listView.setOnItemClickListener(listener);
    }

    @NonNull
    private void setUpListView(UseCaseRepository useCaseRepository, ListView listView) {
        List<Note> notes= useCaseRepository.generateNoteList(15);

        ArrayAdapter<Note> arrayAdapter = new ArrayAdapter<>(this, R.layout.my_list_item, notes);
        listView.setAdapter(arrayAdapter);

    }

}