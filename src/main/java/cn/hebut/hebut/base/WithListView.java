package cn.hebut.hebut.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cn.hebut.hebut.R;
import cn.hebut.hebut.views.ptr.PtrClassicDefaultHeader;
import cn.hebut.hebut.views.ptr.PtrFrameLayout;
import cn.hebut.hebut.views.ptr.PtrHandler;

/**
 * Created by hzh on 2016/4/27.
 */
public class WithListView extends TitleBaseFragment
{
    private String[] data = new String[26];

    private ArrayAdapter<String> mAdapter;

    @Override
    protected boolean enableDefaultBack()
    {
        return true;
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        setHeaderTitle("List View");

        int j = 0;
        for(char i = 'A'; i <= 'Z'; i++)
        {
            data[j++] = i + "";
        }

        mAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,
                data);

        View contentView = inflater.inflate(R.layout.fragment_classic_header_with_listview, null);
        final PtrFrameLayout ptrFrameLayout = (PtrFrameLayout) contentView.findViewById(R.id.ptr_frame_layout);

        PtrClassicDefaultHeader ptrHeader = new PtrClassicDefaultHeader(getContext());
        ptrFrameLayout.setHeaderView(ptrHeader);
        ptrFrameLayout.setPtrUIHandler(ptrHeader);

        ptrHeader.setLastUpdateTimeKey(this.getClass().getName());

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

        ListView listView = (ListView) contentView.findViewById(R.id.list_view);
        listView.setAdapter(mAdapter);

        return contentView;
    }

    private boolean checkContentCanPullDown(PtrFrameLayout frame, View content, View header)
    {
        if(content instanceof AbsListView) {
            AbsListView absListView = (AbsListView) content;
            return absListView.getChildCount() > 0  &&
                    (absListView.getFirstVisiblePosition() > 0 ||
                            absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        } else {
            return content.getScrollY() > 0;
        }
    }
}
