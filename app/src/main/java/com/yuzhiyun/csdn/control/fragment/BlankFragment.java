package com.yuzhiyun.csdn.control.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuzhiyun.csdn.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


//    @Bind(R.id.tvContent)
    TextView tvContent;
    String content;
    public BlankFragment() {
    }

    public BlankFragment(String content) {
        this.content=content;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_blank, container, false);
        tvContent= (TextView) root.findViewById(R.id.tvContent);
//        ButterKnife.bind(getActivity());
        initContent();
        return root;
    }

    private void initContent() {
    tvContent.setText(content);
    }

}
