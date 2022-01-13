package lt.vcs.vcs_android_tomask_notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "app_test";
    private List<Note> notes;
    private ArrayAdapter<Note> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView= findViewById(R.id.listView);

        UseCaseRepository useCaseRepository= new UseCaseRepository();

        setUpListView(useCaseRepository, listView);

        onClickItem(listView);

        onLongClickItem(listView);
    }

    private void onLongClickItem(ListView listView) {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemLongClick: "+notes.get(position).getId());
                notes.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void onClickItem(ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView< ?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick: "+notes.get(position).getId());
            }
        });
    }

    @NonNull
    private void setUpListView(UseCaseRepository useCaseRepository, ListView listView) {
        notes= useCaseRepository.generateNoteList(15);

        arrayAdapter = new ArrayAdapter<>(this, R.layout.my_list_item, notes);

        listView.setAdapter(arrayAdapter);

    }

}