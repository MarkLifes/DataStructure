package com.wangpos.datastructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wangpos.datastructure.sort.BisearchActivity;
import com.wangpos.datastructure.sort.DirectInsertSortActivity;
import com.wangpos.datastructure.sort.EasyLinkListActivity;
import com.wangpos.datastructure.sort.EasyLinkListReverseActivity;
import com.wangpos.datastructure.sort.SpaceComplexityActivity;
import com.wangpos.datastructure.sort.TimeComplexityActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int Bisearch = 1;

    public static final int EasyLinkList = 2;

    public static final int ReverseEasyLinkList = 3;

    public static final int DirectInsertSort = 4;

    public static final int TimeComplexity = 5;

    public static final int SpaceComplexity = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mListView = (ListView)findViewById(R.id.listView);
        final ListAdapter adapter = new ListAdapter(this);
        List<DataBean>list = new ArrayList<>();

        initData(list);

        adapter.setDataBeanList(list);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DataBean data = adapter.getDataBeanList().get(i);
                onClickItem(data);
            }
        });

    }

    private void onClickItem(DataBean data) {
        switch (data.type){
            case TimeComplexity:
                startActivity(new Intent(this,TimeComplexityActivity.class));
                break;
            case SpaceComplexity:
                startActivity(new Intent(this,SpaceComplexityActivity.class));
                break;
            case Bisearch:
                startActivity(new Intent(this, BisearchActivity.class));
                break;
            case EasyLinkList:
                startActivity(new Intent(this, EasyLinkListActivity.class));
                break;
            case ReverseEasyLinkList:
                startActivity(new Intent(this, EasyLinkListReverseActivity.class));
                break;
            case DirectInsertSort:
                startActivity(new Intent(this, DirectInsertSortActivity.class));
                break;
            default:
                break;
        }

    }

    private void initData(List<DataBean> list) {
        list.add(new DataBean(TimeComplexity,"时间复杂度介绍"));
        list.add(new DataBean(SpaceComplexity,"空间复杂度介绍"));
        list.add(new DataBean(Bisearch,"折半查找／二分法查找"));
        list.add(new DataBean(EasyLinkList,"Java链表实现"));
        list.add(new DataBean(ReverseEasyLinkList,"反转一个链表"));
        list.add(new DataBean(DirectInsertSort,"直接插入排序"));
    }
}
