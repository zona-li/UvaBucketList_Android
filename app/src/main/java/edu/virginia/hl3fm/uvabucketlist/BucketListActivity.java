package edu.virginia.hl3fm.uvabucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class BucketListActivity extends AppCompatActivity {

    // Declare RecyclerView and its Layout Manager
    private RecyclerView mRecyclerView;
    private ArrayList<ListItems> listItems = new ArrayList<>();
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket_list);

        //Allocated memory for the RecyclerView and its Layout Manager
        mRecyclerView = (RecyclerView) findViewById(R.id.rvListItems);
        mAdapter = new RecyclerAdapter(this, listItems);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        prepareListData();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startAddActivity = new Intent(BucketListActivity.this, AddItemActivity.class);
                startActivity(startAddActivity);
            }
        });

    }

    private void prepareListData() {
        ListItems graduation = new ListItems(true, "12.1.2016", "Apply for graduation");
        ListItems csHw = new ListItems(false, "2.6.2017", "Complete Android mini app");
        listItems.add(csHw);
        listItems.add(graduation);
        mAdapter.notifyDataSetChanged();
    }

    public void addNewList(String name, String date, Boolean isCompleted) {
        listItems.add(0, new ListItems(isCompleted, date, name));
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bucket_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
