package com.chen.factory;

import com.chen.bean.AirPlane;

/**
 * 静态工厂
 */
public class AirPlaneStaticFactory {

    //AirPlaneStaticFactory.getAirPlane()
    public static AirPlane getAirPlane(String jzName){
        System.out.println("AirPlaneStaticFactory正在造飞机");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("泰坦");
        airPlane.setFjsName("chen");
        airPlane.setJzName(jzName);
        airPlane.setPersonNum(300);
        airPlane.setYc("198m");
        return airPlane;
    }
}
