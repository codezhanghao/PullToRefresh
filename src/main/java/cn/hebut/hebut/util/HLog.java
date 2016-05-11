package cn.hebut.hebut.util;

import android.util.Log;

/**
 * Created by hzh on 2016/4/27.
 */
public class HLog
{
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_WARNING = 3;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;

    private static int sLevel = LEVEL_VERBOSE;

    /**
     * 低于设置level的日志不会打印
     *
     * @param level
     */
    public static void setLevel(int level)
    {
        sLevel = level;
    }

    /**
     * 打印Verbose日志
     *
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg)
    {
        if (sLevel > LEVEL_VERBOSE)
        {
            return;
        }

        Log.v(tag, msg);
    }

    /**
     * 打印LEVEL_DEBUG日志
     *
     * @param tag
     * @param msg
     * @param args
     */
    public static void v(String tag, String msg, Object... args)
    {
        if (sLevel > LEVEL_VERBOSE)
        {
            return;
        }
        if (args.length > 0)
        {
            msg = String.format(msg, args);
        }
        Log.v(tag, msg);
    }

    /**
     * 打印LEVEL_DEBUG日志
     *
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg)
    {
        if (sLevel > LEVEL_DEBUG)
        {
            return;
        }

        Log.d(tag, msg);
    }

    /**
     * 打印Verbose日志
     *
     * @param tag
     * @param msg
     * @param args
     */
    public static void d(String tag, String msg, Object... args)
    {
        if (sLevel > LEVEL_DEBUG)
        {
            return;
        }
        if (args.length > 0)
        {
            msg = String.format(msg, args);
        }
        Log.d(tag, msg);
    }

    /**
     * 打印LEVEL_INFO日志
     *
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg)
    {
        if (sLevel > LEVEL_INFO)
        {
            return;
        }
        Log.i(tag, msg);
    }

    public static void i(String tag, String msg, Object... args)
    {
        if (sLevel > LEVEL_INFO)
        {
            return;
        }
        if (args.length > 0)
        {
            msg = String.format(msg, args);
        }
        Log.i(tag, msg);
    }

    /**
     * 打印LEVEL_WARNING日志
     *
     * @param tag
     * @param msg
     */
    public static void w(String tag, String msg)
    {
        if (sLevel > LEVEL_WARNING)
        {
            return;
        }
        Log.w(tag, msg);
    }

    public static void w(String tag, String msg, Object... args)
    {
        if (sLevel > LEVEL_WARNING)
        {
            return;
        }
        if (args.length > 0)
        {
            msg = String.format(msg, args);
        }
        Log.w(tag, msg);
    }

    /**
     * 打印LEVEL_ERROR日志
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg)
    {
        if (sLevel > LEVEL_ERROR)
        {
            return;
        }

        Log.e(tag, msg);
    }

    public static void e(String tag, String msg, Object... args)
    {
        if(sLevel > LEVEL_ERROR) {
            return;
        }
        if(args.length > 0) {
            msg = String.format(msg, args);
        }
        Log.e(tag, msg);
    }

    /**
     * 打印LEVEL_FATAL日志
     * @param tag
     * @param msg
     */
    public static void f(String tag, String msg)
    {
        if(sLevel > LEVEL_FATAL) {
            return;
        }
        Log.wtf(tag, msg);
    }

    public static void f(String tag, String msg, Object... args)
    {
        if(sLevel > LEVEL_FATAL) {
            return;
        }
        if(args.length > 0) {
            msg = String.format(msg, args);
        }
        Log.wtf(tag, msg);
    }
}
