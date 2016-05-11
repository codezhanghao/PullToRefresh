package cn.hebut.hebut.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import cn.hebut.hebut.R;
import cn.hebut.hebut.views.ptr.PtrClassicDefaultHeader;
import cn.hebut.hebut.views.ptr.PtrFrameLayout;
import cn.hebut.hebut.views.ptr.PtrHandler;

/**
 * Created by hzh on 2016/5/3.
 */
public class WithScrollView extends TitleBaseFragment
{
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        setHeaderTitle("Scroll View");

        View contentView = inflater.inflate(R.layout.fragment_classic_header_with_scroll_view, null);
        final PtrFrameLayout ptrFrameLayout = (PtrFrameLayout) contentView.findViewById(R.id.ptr_frame_layout);
        PtrClassicDefaultHeader headerView = new PtrClassicDefaultHeader(getContext());

        //shared pereference: the key of last update time
        headerView.setLastUpdateTimeKey(this.getClass().getName());

        ptrFrameLayout.setHeaderView(headerView);
        ptrFrameLayout.setPtrUIHandler(headerView);

        ptrFrameLayout.setPtrHandler(new PtrHandler()
        {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header)
            {
                return !checkContentCanPullDown(frame, content, header);
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

    public boolean checkContentCanPullDown(PtrFrameLayout frame, View content, View header)
    {
        return content.getScrollY() > 0;
    }

    @Override
    protected boolean enableDefaultBack()
    {
        return true;
    }
}
