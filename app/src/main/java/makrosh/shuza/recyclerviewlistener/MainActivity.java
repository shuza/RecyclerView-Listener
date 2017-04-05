package makrosh.shuza.recyclerviewlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import makrosh.shuza.recyclerlibrary.RecyclerClickListener;

public class MainActivity extends AppCompatActivity implements RecyclerClickListener {
    private RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvList = (RecyclerView) findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            names.add("row " + i);
        }

        MyAdapter adapter = new MyAdapter(this, R.layout.list_item, names);
        rvList.setAdapter(adapter);
    }

    @Override
    public void onRowClickListener(int position) {
        Toast.makeText(this, position + " clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRowLongClickListener(int position) {
        Toast.makeText(this, position + " long clicked", Toast.LENGTH_SHORT).show();
    }
}
