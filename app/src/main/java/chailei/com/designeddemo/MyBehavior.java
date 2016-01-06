package chailei.com.designeddemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 16-1-6.
 */
public class MyBehavior extends FloatingActionButton.Behavior {

    public MyBehavior() {

    }
    public MyBehavior(Context context,AttributeSet attrs){
        super();
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {

        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) !=0;
//        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

  //  发生在CoordinatorLayout上的滚动
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
//        if(dyUnconsumed > 0){
//                child.setVisibility(View.GONE);
//        }else {
//                child.setVisibility(View.VISIBLE);
//        }
    }
//将要发生的滚动，还没有分发
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if(dy > 0){
            child.setVisibility(View.GONE);
        }else {
            child.setVisibility(View.VISIBLE);
        }
    }
}
