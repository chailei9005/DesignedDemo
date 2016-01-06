package chailei.com.designeddemo;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SwipeDismissBehavior.OnDismissListener, View.OnClickListener {

    private TextView textView;
    private CoordinatorLayout coordinator;
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.txt);
        textView.setOnClickListener(this);
        coordinator = (CoordinatorLayout) findViewById(R.id.coordinate);
        //每个控件都有一个LayoutParams，来安排他在父容器中的位置
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) textView.getLayoutParams();
      //SwipeDismissBehavior   CoordinatorLayout的包裹子控件的交互行为的插件，提供支持（滑动 ---消失）的手势
        SwipeDismissBehavior behavior = new SwipeDismissBehavior();
        behavior.setListener(this);
        params.setBehavior(behavior);

//        behavior比较重要

//        Toolbar toolbar = new ;
        //把toolbar  当作actionbar,两者只能有一种
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onDismiss(final View view) {
//        view.setVisibility(View.GONE);

        //parent 和 coordinator  是一样的
        final ViewGroup parent = (ViewGroup) view.getParent();
        ViewCompat.setAlpha(view, 1);
//        ViewCompat.setTranslationX(view,0);
        parent.removeView(view);
//        Toast.makeText(this,"删除了一个textView",Toast.LENGTH_SHORT).show();
        Snackbar.make(coordinator,"删除了一个TextView",Snackbar.LENGTH_LONG)
                .setAction("撤销", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        coordinator.addView(view);
                    }
                })
                .show();
        //如果Snackbar中的view不是协调者布局，活动删除不可以
    }

    @Override
    public void onDragStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,CoordinatorActivity.class));
    }
}
