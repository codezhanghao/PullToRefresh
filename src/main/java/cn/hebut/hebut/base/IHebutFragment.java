package cn.hebut.hebut.base;

/**
 * 给HebutFragment提供一些方法，让HebutFragment的行为和activity类似
 */
public interface IHebutFragment
{
    void onEnter(Object data);

    void onLeave();

    void onBack();

    void onBackWithData(Object data);
}
