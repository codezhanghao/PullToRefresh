package cn.hebut.hebut.base;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import cn.hebut.hebut.util.HLog;

/**
 * 让Fragment的行为和Activity保持一致
 */
public abstract class HebutFragmentActiviy extends AppCompatActivity
{
    public static final boolean DEBUG = true;
    private static final String TAG = ".hebut.base.HebutFragmentActiviy";

    protected HebutFragment mCurrentFragment;
    /**
     * fragment放到哪个容器中，由子类决定
     */
    protected abstract int getContainerId();

    public void pushFragmentToBackStack(Class<?> cls, Object data)
    {
        FragmentParam param = new FragmentParam();
        param.cls = cls;
        param.data = data;

        goToThisFragment(param);
    }

    private void goToThisFragment(FragmentParam param)
    {
        int containerId = getContainerId();
        Class<?> cls = param.cls;
        String fragmentTag = getFragmentTag(param);

        try {
            FragmentManager fm = getFragmentManager();
            HebutFragment fragment = (HebutFragment) fm.findFragmentByTag(fragmentTag);
            if (fragment == null) {
                fragment = (HebutFragment) cls.newInstance();
            }

            //调用IHebugFragment生命周期方法
            if(mCurrentFragment != null && mCurrentFragment != fragment) {
                mCurrentFragment.onLeave();
            }
            fragment.onEnter(param.data);

            FragmentTransaction ft = fm.beginTransaction();
            if(fragment.isAdded()) {
                if(DEBUG) {
                    HLog.d(TAG, "%s has been added, will be shown again.", fragmentTag);
                }
                ft.show(fragment);
            }else {
                if(DEBUG) {
                    HLog.d(TAG, "%s is added.", fragmentTag);
                }
                ft.add(containerId, fragment, fragmentTag);
            }

            mCurrentFragment = fragment;

            ft.addToBackStack(fragmentTag);
            ft.commitAllowingStateLoss();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private String getFragmentTag(FragmentParam param)
    {
        StringBuilder sb = new StringBuilder(param.cls.toString());
        return sb.toString();
    }

    public void goToFragment(Class<?> cls, Object data)
    {
        if(cls == null) {
            return;
        }

        HebutFragment fragment = (HebutFragment) getFragmentManager().findFragmentByTag(cls.toString());
        if(fragment != null) {
            mCurrentFragment = fragment;
            fragment.onBackWithData(data);
        }
        getFragmentManager().popBackStackImmediate(cls.toString(), 0);
    }

    public void popTopFragment(Object data)
    {
        FragmentManager fm = getFragmentManager();
        fm.popBackStackImmediate();
        if(tryToUpdateCurrentAfterPop() && mCurrentFragment != null) {
            mCurrentFragment.onBackWithData(data);
        }
    }

    public void popToRoot(Object data)
    {
        FragmentManager fm = getFragmentManager();
        while(fm.getBackStackEntryCount() > 1) {
            fm.popBackStackImmediate();
        }
        popTopFragment(data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == android.R.id.home) {
            doRetrunBack();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void doRetrunBack()
    {
        int count = getFragmentManager().getBackStackEntryCount();
        if(count <= 1) {
            finish();
        } else {
            getFragmentManager().popBackStackImmediate();
        }
    }

    private boolean tryToUpdateCurrentAfterPop()
    {
        FragmentManager fm = getFragmentManager();
        int cnt = fm.getBackStackEntryCount();
        if(cnt > 0) {
            String name = fm.getBackStackEntryAt(cnt - 1).getName();
            Fragment fragment = fm.findFragmentByTag(name);
            if(fragment != null && fragment instanceof HebutFragment) {
                mCurrentFragment = (HebutFragment) fragment;
            }
            return true;
        }
        return false;
    }
}
