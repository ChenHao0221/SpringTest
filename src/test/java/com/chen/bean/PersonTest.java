package com.chen.bean;

import org.hamcrest.Condition;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextLoader;

import java.util.List;
import java.util.Map;

public class PersonTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
    ApplicationContext ioc2 = new ClassPathXmlApplicationContext("ioc2.xml");
    ApplicationContext ioc3 = new ClassPathXmlApplicationContext("ioc3.xml");

    /**
     *  1、源码包开始的路径，称为类路径的开始（这里的类路径的开始不是src，因为java才是真正的源码包（蓝色））
     *      所有源码包里面的东西都会被合并放在类路径里面
     *      java：/bin/（这个项目里面是target下的classes）
     *      web：/WEB-INF/classes/
     *  2、先导包再创建配置文件
     */

    /**
     *  几个细节：
     *  ClassPathXmlApplicationContext("ioc.xml")：表示ioc容器的配置文件在类路径下
     *  FileSystemXmlApplicationContext()：表示ioc容器的配置文件在磁盘路径下
     */

    /**
     * 从容器中拿到这个组件
     */
    @Test
    public void test(){
        //ApplicationContext代表ioc容器
        //ClassPathXmlApplicationContext代表当前应用的xml配置文件在ClassPath下
        //根据Spring的配置文件得到ioc对象
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        //容器帮我们创建好对象
        Person bean = (Person) ioc.getBean("person01");

        System.out.println(bean);
    }

    /**
     * 实验2：根据bean的类型从IOC容器获取bean的实例
     * 如果ioc容器中这个类型的bean由多个，根据类型查找会失败
     */
    @Test
    public void test02(){
//        ioc容器中Person类型的bean由多个，根据类型查找会失败
//        Person bean = ioc.getBean(Person.class);
//        System.out.println(bean);

        //id + 类型查找
        Person bean1 = ioc.getBean("person01", Person.class);
        System.out.println(bean1);

        Object bean2 = ioc.getBean("person03");
        System.out.println(bean2);

        Object bean3 = ioc.getBean("person04");
        System.out.println(bean3);

        Object bean4 = ioc.getBean("person06");
        System.out.println(bean4);
    }

    /**
     * 正确为各种属性赋值
     * 测试使用null值，默认引用类型就是null，基本类型是默认值
     * name属性有默认值“小明”，现在要将其改为null
     */
    @Test
    public void test03(){
        Person bean = (Person) ioc2.getBean("person01");
        System.out.println(bean);

        System.out.println(bean.getCar());

        //getBooks()是Person所特有的方法，因此是需要向下转型的
        Person bean1 = (Person) ioc2.getBean("person02");
        List<Book> books = bean1.getBooks();
        System.out.println(books);

        Map<String, Object> maps = bean1.getMaps();
        System.out.println(maps);

        System.out.println(bean1.getProperties());
    }

    @Test
    public void test04(){
        Person person03 = (Person) ioc2.getBean("person03");
        Map<String, Object> maps = person03.getMaps();
        System.out.println(maps);

        Map<String, Object> myMap = (Map<String, Object>) ioc2.getBean("myMap");
        System.out.println(myMap);
    }

    @Test
    public void test06(){
        Person person04 = (Person) ioc2.getBean("person04");
        System.out.println(person04);

        Person person06 = (Person) ioc2.getBean("person06");
        System.out.println(person06);
    }

    @Test
    public void test07(){
        Object airPlane01 = ioc3.getBean("airPlane01");
        System.out.println(airPlane01);

        Object airPlane02 = ioc3.getBean("airPlane02");
        System.out.println(airPlane02);
    }

    @Test
    public void test08(){
        Object myFactoryBeanImpl = ioc3.getBean("myFactoryBeanImpl");
        System.out.println(myFactoryBeanImpl);
    }

    @Test
    public void test09(){
        Book book02 = (Book) ioc3.getBean("book02");
        System.out.println(book02);
    }
}
