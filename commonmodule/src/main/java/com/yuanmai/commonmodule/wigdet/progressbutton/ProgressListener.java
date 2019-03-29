package com.yuanmai.commonmodule.wigdet.progressbutton;

/**
 * Created by zhanghui on 2019/3/26.
 */

public interface ProgressListener {
    void download(int progress);
    void normal(int status);
    void startDownload();
}
