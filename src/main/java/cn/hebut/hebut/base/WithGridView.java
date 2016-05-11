package cn.hebut.hebut.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import cn.hebut.hebut.R;
import cn.hebut.hebut.views.ptr.PtrClassicDefaultHeader;
import cn.hebut.hebut.views.ptr.PtrFrameLayout;
import cn.hebut.hebut.views.ptr.PtrHandler;

/**
 * Created by hzh on 2016/5/10.
 */
public class WithGridView extends TitleBaseFragment
{
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        setHeaderTitle("Grid view");

        View contentView = inflater.inflate(R.layout.fragment_classic_header_with_gridview, null);

        final PtrFrameLayout ptrFrameLayout = (PtrFrameLayout) contentView.findViewById(R.id.rotate_header_grid_view_frame);
        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(getContext());
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.setPtrUIHandler(header);

        header.setLastUpdateTimeKey(this.getClass().getName());

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

        GridView gridView = (GridView) contentView.findViewById(R.id.grid_view);
        ImageAdatper adatper = new ImageAdatper();
        gridView.setAdapter(adatper);

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

    @Override
    protected boolean enableDefaultBack()
    {
        return true;
    }

    // adapter of grid view
    private class ImageAdatper extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            return mImageIds.length;
        }

        @Override
        public Object getItem(int position)
        {
            return mImageIds[position];
        }

        @Override
        public long getItemId(int position)
        {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ImageView imageView;
            if(convertView == null) {
                imageView = new ImageView(getContext());
                imageView.setLayoutParams(new GridView.LayoutParams(-1, -1));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);;

            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mImageIds[position]);

            return imageView;
        }

        private Integer[] mImageIds = {
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7,
                R.drawable.sample_0, R.drawable.sample_1,
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7,
                R.drawable.sample_0, R.drawable.sample_1,
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7,
        };
    }
}
