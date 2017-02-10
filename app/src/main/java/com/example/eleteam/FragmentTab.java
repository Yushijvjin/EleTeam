package com.example.eleteam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 李小兵 on 2017/2/9.
 */
public class FragmentTab extends Fragment {

    private View mViewContent;
    private TextView mTvText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return getContentView(inflater, container);
    }

    private View getContentView(LayoutInflater inflater, ViewGroup container) {

        if (mViewContent == null) {

            mViewContent = inflater.inflate(R.layout.fragment_tab, container, false);


        }

        ViewGroup parent = (ViewGroup) mViewContent.getParent();

        if (parent !=null){
            parent.removeView(mViewContent);

        }

        if (mTvText==null) {
            mTvText = (TextView) mViewContent.findViewById(R.id.tab_tv_text);
        }


        return mViewContent;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTvText.setText(String.valueOf("Page: "+getTag()));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
