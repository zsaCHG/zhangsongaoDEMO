package com.flood.tanke.util;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import com.demo.zhangsongaodemo.glideprogress.GlideProgressDataFetcher;

import java.io.InputStream;

/**
 * Created by zsachg on 2018/8/31.
 * 需要 先把ImageLoaderUtils  set进去 要不回调不了进度
 */

public class GlideProcessShowLoader implements StreamModelLoader<String> {

    private ImageLoaderUtils imageLoaderUtils;

    public ImageLoaderUtils getImageLoaderUtils() {
        return imageLoaderUtils;
    }

    /**
     * 需要 先设置 进度回调 参数
     */
    public void setImageLoaderUtils(ImageLoaderUtils imageLoaderUtils) {
        this.imageLoaderUtils = imageLoaderUtils;
    }

    @Override
    public DataFetcher<InputStream> getResourceFetcher(String model, int width, int height) {
        return new GlideProgressDataFetcher(model,getImageLoaderUtils());
    }
}
