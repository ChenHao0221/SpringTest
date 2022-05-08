package com.chen.factory;

import com.chen.bean.AirPlane;

/**
 * 实例工厂
 */
public class AirPlaneInstanceFactory {

    //new AirPlaneInstanceFactory().getAirPlane();
    public AirPlane getAirPlane(String jzName){
        System.out.println("AirPlaneInstanceFactory正在造飞机");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("泰坦");
        airPlane.setFjsName("chen");
        airPlane.setJzName(jzName);
        airPlane.setPersonNum(300);
        airPlane.setYc("198m");
        return airPlane;
    }
}
