package cn.hebut.hebut.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.hebut.hebut.R;
import cn.hebut.hebut.views.ptr.PtrClassicDefaultHeader;
import cn.hebut.hebut.views.ptr.PtrFrameLayout;
import cn.hebut.hebut.views.ptr.PtrHandler;

/**
 * Created by hzh on 2016/5/10.
 */
public class WithTextView extends TitleBaseFragment
{
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        setHeaderTitle("Text View");

        View contentView = inflater.inflate(R.layout.fragment_classic_header_with_textview, null);

        final PtrFrameLayout ptrFrameLayout = (PtrFrameLayout) contentView.findViewById(R.id.text_with_rotate_header_frame);
        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(getContext());
        header.setLastUpdateTimeKey(this.getClass().getName());

        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.setPtrUIHandler(header);

        ptrFrameLayout.setPtrHandler(new PtrHandler()
        {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header)
            {
                return true;
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame)
            {
                frame.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        ptrFrameLayout.refreshComplete();
                    }
                }, 1500);
            }
        });

        return contentView;
    }

    @Override
    protected boolean enableDefaultBack()
    {
        return true;
    }
}
