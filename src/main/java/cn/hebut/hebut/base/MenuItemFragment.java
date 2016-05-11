package cn.hebut.hebut.base;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.hebut.hebut.R;


/**
 * Created by hzh on 2016/4/28.
 */
public abstract class MenuItemFragment extends TitleBaseFragment
{
    protected ArrayList<MenuItemInfo> mItemInfos = new ArrayList<MenuItemInfo>();

    public abstract int getLayoutId();
    public abstract void addItemInfos(ArrayList<MenuItemInfo> itemInfos);
    public abstract void setupViews(View view);

    protected MenuItemInfo newItemInfo(int color, String title, View.OnClickListener listener)
    {
        return new MenuItemInfo(getResources().getColor(color), title, listener);
    }

    protected MenuItemInfo newItemInfo(String color, String title, View.OnClickListener listener)
    {
        return new MenuItemInfo(Color.parseColor(color), title, listener);
    }

    protected MenuItemInfo newItemInfo(int color, int title, View.OnClickListener listener)
    {
        return new MenuItemInfo(getResources().getColor(color), getString(title), listener);
    }

    protected MenuItemInfo newItemInfo(String color, int title, View.OnClickListener listener)
    {
        return new MenuItemInfo(Color.parseColor(color), getString(title), listener);
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        setHeaderTitle("MenuItemFragment");
        View view = inflater.inflate(getLayoutId(), null);
        addItemInfos(mItemInfos);
        setupViews(view);

        return view;
    }

    public static class MenuItemInfo
    {
        private int mColor;
        private String mTitle;
        private View.OnClickListener mOnClickListener;

        public MenuItemInfo(int color, String title, View.OnClickListener listener)
        {
            mColor = color;
            mTitle = title;
            mOnClickListener = listener;
        }

        public void onClick(View v)
        {
            if(mOnClickListener != null) {
                mOnClickListener.onClick(v);
            }
        }

        public int getColor()
        {
            return mColor;
        }

        public String getTitle()
        {
            return mTitle;
        }
    }
}
