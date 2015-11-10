package dk.cphbusiness.exampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private List<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView)findViewById(R.id.listView);
        list.setOnItemClickListener(this);
        names.add("Kurt");
        names.add("Sonja");
        names.add("Nebukanezer");
        updateList();
        }

    /**
     * Helper method
     */
    private void updateList() {
        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names));
        }

    public void addNameButtonClicked(View view) {
        names.add(((EditText) findViewById(R.id.editName)).getText().toString());
        updateList();
        }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "View clicked at #"+position, Toast.LENGTH_LONG).show();
        names.remove(position);
        updateList();
        }

    }
