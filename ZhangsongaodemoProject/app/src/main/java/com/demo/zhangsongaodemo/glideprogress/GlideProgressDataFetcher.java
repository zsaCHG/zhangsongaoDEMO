package com.demo.zhangsongaodemo.glideprogress;

public class GlideProgressDataFetcher
//        implements DataFetcher<InputStream>
{

//    /**
//     * 链接地址
//     */
//    String model = "";
//
//
//    /**
//     * 封装了图片请求的参数集合
//     */
//    ImageLoaderUtils imageLoaderUtils;
//
//    InputStream inputStream;
//
//    private boolean isCancel;
//
//    private InputStream copyInputStream;
//
//    private long lastUpdateTime;
//
//    public GlideProgressDataFetcher(String model, ImageLoaderUtils imageLoaderUtils) {
//        this.model = model;
//        this.imageLoaderUtils = imageLoaderUtils;
//    }
//
//    @Override
//    public InputStream loadData(Priority priority) throws Exception {
//        try {
//            ByteArrayOutputStream baos = null;
//            baos = new ByteArrayOutputStream();
//            URL url = new URL(model);
//            //初始化 HttpURLConnection 设置相关信息
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setConnectTimeout(6 * 1000);
//            conn.setRequestMethod("GET");
//            if (isCancel) {
//                return null;
//            }
//            if (conn.getResponseCode() == 200) {
//                final int size = conn.getContentLength();
//                inputStream = conn.getInputStream();
//                byte buffer[] = new byte[1024];
//                int len = 0;
//                int threadTotal = 0;
//                //读取输入流 这里读取到的byte[] 同时做了两件事儿 一是拿到进度 二是复制输入流进入ByteArrayOutputStream
//                // 因为输入流只能读取一遍 我们拿到了进度 再把这个输入流返回改Glide 图片会显示失败 所以需要复制一份
//
//                while ((len = inputStream.read(buffer)) != -1) {
//                    baos.write(buffer, 0, len);
//                    threadTotal += len;
//                    if (imageLoaderUtils != null) {
//                        final int finalThreadTotal = threadTotal;
//                        final float progress = (float) finalThreadTotal / (float) size;
//                        //项目里 测试时设置的参数 因为网络速度很快 前端不需要响应太快
//                        if (System.currentTimeMillis() - lastUpdateTime > 5 || progress > 0.95) {
//                            lastUpdateTime = System.currentTimeMillis();
//                            //返回主线程 操作ui进度条 等
//                            Tools.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    imageLoaderUtils.imageLoaderProgressListener.getProgressValue((float) finalThreadTotal / (float) size);
//                                }
//                            });
//                        }
//                    }
//                }
//                baos.flush();
//                //成功获取图片的回调
//                imageLoaderUtils.imageLoaderProgressListener.onProgressFinish();
//                //返回 我们复制出来的输入流
//                return new ByteArrayInputStream(baos.toByteArray());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 清除 工作
//     */
//    @Override
//    public void cleanup() {
//        try {
//            if (inputStream != null) {
//                inputStream.close();
//                inputStream = null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public String getId() {
//        return model;
//    }
//
//    @Override
//    public void cancel() {
//        isCancel = true;
//    }
}
