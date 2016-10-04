package com.yuzhiyun.csdn.control.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yuzhiyun.csdn.R;
import com.yuzhiyun.csdn.model.Constant;
import com.yuzhiyun.csdn.model.NewsItemBiz;
import com.yuzhiyun.csdn.model.adapter.ContentAdapter;
import com.yuzhiyun.csdn.model.entity.NewsItem;
import com.yuzhiyun.csdn.model.exception.CommonException;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {

    List<NewsItem> newsItems =new ArrayList<>();
    int index;
    ListView listVTitle;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //        显示到listview
            listVTitle.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getStringArray()));
        }
    };
    public ContentFragment() {
    }

    public ContentFragment(int index) {
        this.index = index;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_blank, container, false);
        listVTitle = (ListView) root.findViewById(R.id.listVTitle);
//        ButterKnife.bind(getActivity());
        try {
            initContent();
        } catch (CommonException e) {
            e.printStackTrace();
        }
        return root;
    }

    private void initContent() throws CommonException {
        new myAsynctask().execute();
    }

    private String[] getStringArray() {
        String[] string=new String[newsItems.size()];
        for (int i=0;i<newsItems.size();i++)
            string[i]=newsItems.get(i).getTitle();
        return  string;
    }


    class myAsynctask extends AsyncTask{
        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            handler.sendEmptyMessage(10);
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            NewsItemBiz newsItemBiz=new NewsItemBiz();
            Log.i("data",index+"");
//        获取数据
            switch (index) {
//            业界
                case Constant.INDEX_PAGE_1:
                    try {
                        newsItems=newsItemBiz.getNewsItems(Constant.NEWS_TYPE_YEJIE, 1);
                    } catch (CommonException e) {
                        e.printStackTrace();
                    }
                    break;
//            研发
                case Constant.INDEX_PAGE_2:
                    try {
                        newsItems=newsItemBiz.getNewsItems(Constant.NEWS_TYPE_YANFA, 1);
                    } catch (CommonException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            Log.i("data","***************");
            for (NewsItem item : newsItems) {
                Log.i("data",item.toString());
            }

            return null;
        }
    }

}
