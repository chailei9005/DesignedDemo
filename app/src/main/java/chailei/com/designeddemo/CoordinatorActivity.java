package chailei.com.designeddemo;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import chailei.com.designeddemo.adapters.MyAdapter;

public class CoordinatorActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recycler;
    private Toolbar toolbar;
    private FloatingActionButton floatButton;
    private CoordinatorLayout viewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        floatButton = (FloatingActionButton) findViewById(R.id.floating_button);
        floatButton.setOnClickListener(this);
        viewById = (CoordinatorLayout) findViewById(R.id.cooridinator);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(String.format("第%02d条数据",i));

        }
        recycler.setAdapter(new MyAdapter(this,list));

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(viewById, "点击事件", Snackbar.LENGTH_LONG).show();
    }
}
