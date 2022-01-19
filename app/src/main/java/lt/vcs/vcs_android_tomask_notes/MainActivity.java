package lt.vcs.vcs_android_tomask_notes;

import static lt.vcs.vcs_android_tomask_notes.Constants.DATABASE_NAME;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "app_test";
    private List<Note> notes;
    private ArrayAdapter<Note> arrayAdapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        UseCaseRepository useCaseRepository = new UseCaseRepository();

        setUpListView(useCaseRepository, listView);

        MainDatabase database =
                Room.databaseBuilder(
                        getApplicationContext(),
                        MainDatabase.class,
                        DATABASE_NAME
                )   .allowMainThreadQueries()
            	    .fallbackToDestructiveMigration()
                    .build();

        NoteDao noteDao = database.noteDao();
//        noteDao.getAll()
        noteDao.insertNotes(notes);

        fab= findViewById(R.id.fab);

        onClickItem(listView);

        onLongClickItem(listView);

        setUpFab();
    }



    private void onLongClickItem(ListView listView) {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemLongClick: " + notes.get(position).getId());
//                notes.remove(position);
//                arrayAdapter.notifyDataSetChanged();
                showAlertDialog(position);
                return true;
            }
        });
    }

    private void onClickItem(ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i(TAG, "onItemClick: " + notes.get(position).getId());

                Intent intent= new Intent(MainActivity.this, NoteDetails.class);
                intent.putExtra("lt.vcs.tomask.main_activity_one", notes.get(position).getName());
                intent.putExtra("lt.vcs.tomask.main_activity_two", notes.get(position).getUpdateDate().toString());
            startActivity(intent);
            }
        });
    }

    @NonNull
    private void setUpListView(UseCaseRepository useCaseRepository, ListView listView) {
        notes = useCaseRepository.generateNoteList(15);

        arrayAdapter = new ArrayAdapter<>(this, R.layout.my_list_item, notes);

        listView.setAdapter(arrayAdapter);

    }

    private void setUpFab() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar
                        .make(v, R.string.same_text, Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private void showAlertDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setMessage("Are you sure you would like to remove?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                notes.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        })
                .setNegativeButton("No", null)
                .show();

    }
}