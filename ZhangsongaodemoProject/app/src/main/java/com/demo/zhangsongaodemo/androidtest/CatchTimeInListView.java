package com.demo.zhangsongaodemo.androidtest;

import java.util.List;

/**
 * Created by zsachg on 2018/11/14.
 * 统计list的item可见时间，如果大于1秒则提交日志
 */

public class CatchTimeInListView {

    //当前的list item区间position起始值
    private static int orderFirstIndex;

    private static int orderLastIndex;

    //当前的list 上一次提交的起点和终点值 用于过滤新上传的字段
    private static int submitFirstIndex;

    private static int submitLastIndex;

    //用于计时的running
    private static Runnable run;


    /**
     * 获取listview上 item显示的时间 如果大于1秒 则记录日志
     */
    public static void catchItemShowTime(int firstVisibleItem, int visibleItemCount, int totalItemCount,
                                         final List<Object> recommendList) {

        try {
            if (recommendList != null && recommendList.size() > 0) {
                if (orderFirstIndex != firstVisibleItem || orderLastIndex != visibleItemCount + firstVisibleItem - 1) {
                    //如果当前可见item区间和上一次的记录不一致，那么说明用户滑动了
                    if (run != null) {
                        //取消上一次的轮询
                        //Tools.removeCallbacks(run);
                    }
                    //记录新的区间起始点数据
                    orderFirstIndex = firstVisibleItem;
                    orderLastIndex = visibleItemCount + firstVisibleItem - 1;
                    run = new Runnable() {
                        @Override
                        public void run() {
                            //提交日志
                            reportItem(recommendList);
                        }
                    };
                    //做一个延时1秒的轮询
                    //Tools.postDelayed(run, 1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reportItem(List<Object> recommendList) {
        for (int i = orderFirstIndex; orderFirstIndex <= i && i <= orderLastIndex; i++) {
            if (submitFirstIndex != 0 || submitLastIndex != 0) {
                if (i <= submitLastIndex && i >= submitFirstIndex) {
                    return;
                }
            }
            if (recommendList != null && recommendList.size() > i) {
                Object re = recommendList.get(i);
                if (re != null) {
//                    ABTestTools.itemShowLongerThanOne(re.articleId, re.recommendSource);
                }
            }
        }
        submitFirstIndex = orderFirstIndex;
        submitLastIndex = orderLastIndex;
    }

}
