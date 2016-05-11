package cn.hebut.hebut.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import cn.hebut.hebut.R;
import cn.hebut.hebut.util.HLog;

/**
 * Created by hzh on 2016/4/27.
 */
public abstract class TitleBaseFragment extends HebutFragment
{
    private Toolbar mTitleHeaderBar;
    private ActionBar mActionBar;
    private LinearLayout mContentContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(getFrameLayoutId(), null);
        LinearLayout contentContainer = (LinearLayout) view.findViewById(R.id.content_frame_content);

        mTitleHeaderBar = (Toolbar) view.findViewById(R.id.content_frame_title_header);
        mContentContainer = contentContainer;

        getContext().setSupportActionBar(mTitleHeaderBar);
        mActionBar = getContext().getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(enableDefaultBack());

        //由子类确定内容区域
        View contentView = createView(inflater, container, savedInstanceState);
        contentView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        contentContainer.addView(contentView);

        return view;
    }

    protected int getFrameLayoutId()
    {
        return R.layout.content_frame_with_title_header;
    }

    protected void setHeaderTitle(int id)
    {
        if(mActionBar != null) {
            mActionBar.setTitle(id);
        }
    }

    protected boolean enableDefaultBack()
    {
        return true;
    }

    protected void setHeaderTitle(String title)
    {
        if(mActionBar != null) {
            mActionBar.setTitle(title);
        }
    }

    public Toolbar getTitleHeaderBar()
    {
        return mTitleHeaderBar;
    }
}
