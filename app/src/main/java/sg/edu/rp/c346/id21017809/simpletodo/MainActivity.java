package sg.edu.rp.c346.id21017809.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTask;
    Button btnAdd;
    Button btnClear;
    ListView lvTask;
    ArrayAdapter<String> aaTask;
    ArrayList<String> alTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask = findViewById(R.id.editTextTask);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        lvTask = findViewById(R.id.listViewTask);

        alTask = new ArrayList<String>();

        aaTask = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alTask);
        lvTask.setAdapter(aaTask);
        lvTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String task = etTask.getText().toString();
                alTask.add(task);
                aaTask.notifyDataSetChanged();
            }
        });
    }
}
