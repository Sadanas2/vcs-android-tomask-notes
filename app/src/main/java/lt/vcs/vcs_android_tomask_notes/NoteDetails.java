package lt.vcs.vcs_android_tomask_notes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class NoteDetails extends AppCompatActivity {
    public static final String TAG = "app_test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        Intent intent = getIntent();
        String messageOne = intent.getStringExtra("lt.vcs.tomask.main_activity_one");
        String messageTwo = intent.getStringExtra("lt.vcs.tomask.main_activity_two");
        Log.i(TAG, "onCreaate1: "+messageOne);
        Log.i(TAG, "onCreaate2: "+messageTwo);
    }
}