package com.chen.factory;

import com.chen.bean.Book;
import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;

/**
 * 实现了FactoryBean接口的类是Spring可以认识的工厂类
 * Spring会自动调用工厂方法创建实例
 *
 * 1、先编写FactoryBean的实现类
 * 2、在spring配置文件中注册
 */
public class MyFactoryBeanImpl implements FactoryBean<Book> {
    /**
     * getObject是工厂方法，Spring自动调用，返回创建的对象
     * @return
     * @throws Exception
     */
    @Override
    public Book getObject() throws Exception {
        Book book = new Book();
        book.setBookName(UUID.randomUUID().toString());
        return book;
    }

    /**
     * 返回创建的对象的类型， Spring自动调用这个方法来确认创建的对象是什么类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    /**
     * 是单例？false表示不是，true表示是单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
