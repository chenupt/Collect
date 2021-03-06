package me.roy.collect.app.libs.manage;

import android.os.Bundle;

import me.roy.collect.R;
import me.roy.collect.common.base.BaseActivity;

/**
 * Created by chenupt@gmail.com on 2014/7/7.
 * Description : TODO
 */
public class DetailActivity extends BaseActivity{

    private DetailFragment fragment;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_libraries_activity_detail);

        id = getIntent().getLongExtra("id", -1);

        initView();
        action();
    }

    private void initView(){
        fragment = new DetailFragment();
        fragment.setId(id);
    }

    private void action(){
        replaceContentFragment();
    }

    private void replaceContentFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }


}
