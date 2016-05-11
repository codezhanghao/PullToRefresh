package cn.hebut.hebut.base;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.hebut.hebut.util.HLog;

/**
 * Created by hzh on 2016/4/27.
 */
public abstract class HebutFragment extends Fragment implements IHebutFragment
{
    private static final boolean DEBUG = true;
    private static final String TAG = ".hebut.base.HebutFragment";

    private Object mDataIn;

    public abstract View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    public HebutFragmentActiviy getContext()
    {
        return (HebutFragmentActiviy) getActivity();
    }

    @Override
    public void onEnter(Object data)
    {
        if(DEBUG) {
            HLog.d(TAG, "onEnter");
        }

        mDataIn = data;
    }

    @Override
    public void onLeave()
    {
        if(DEBUG) {
            HLog.d(TAG, "onLeave");
        }
    }

    @Override
    public void onBack()
    {
        if(DEBUG) {
            HLog.d(TAG, "onBack");
        }
    }

    @Override
    public void onBackWithData(Object data)
    {
        if(DEBUG) {
            HLog.d(TAG, "onBackWithData");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if(DEBUG) {
            HLog.d(TAG, "onCreateView");
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(DEBUG) {
            HLog.d(TAG, "onCreate");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        if(DEBUG) {
            HLog.d(TAG, "onActivityCreated");
        }
    }

    @Override
    public void onStart()
    {
        super.onStart();
        if(DEBUG) {
            HLog.d(TAG, "onStart");
        }
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if(DEBUG) {
            HLog.d(TAG, "onResume");
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();
        if(DEBUG) {
            HLog.d(TAG, "onPause");
        }
    }

    @Override
    public void onStop()
    {
        super.onStop();
        if(DEBUG) {
            HLog.d(TAG, "onStop");
        }
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        if(DEBUG) {
            HLog.d(TAG, "onDestroyView");
        }
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if(DEBUG) {
            HLog.d(TAG, "onDestroy");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        if(DEBUG) {
            HLog.d(TAG, "onDetach");
        }
    }
}
