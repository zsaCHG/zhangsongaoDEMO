package com.demo.zhangsongaodemo.designpatterns.factory;

/**
 * Created by zsachg on 2018/8/9.
 */

public class CreatorLand extends Creator {

    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product= (Product) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)product;
    }

}
