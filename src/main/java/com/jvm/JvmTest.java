package com.jvm;

/**
 * Function: jvm的垃圾回收测试和内存分配 ;
 * Date:18-7-23下午7:44
 * Copyright (c) 2018, 北京大生知行科技有限公司.
 * gc调优http://www.cnblogs.com/duanxz/p/5229379.htmls
 *
 * @Author cailin
 */
public class JvmTest {
    public static void main(String[] args) {
        testTenuringThreshold();
    }

    private static final int _1MB = 1024 * 1024;

    /**
     * 内存分配测试,由于我本机用的jdk8 因此不存在永久代了
     * PSYoungGen      total 9216K, used 2793K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 8192K, 34% used [0x00000000ff600000,0x00000000ff8ba650,0x00000000ffe00000)
     *   from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
     *   to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
     *  ParOldGen       total 10240K, used 8193K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     *   object space 10240K, 80% used [0x00000000fec00000,0x00000000ff4004d8,0x00000000ff600000)
     *  Metaspace       used 3311K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 364K, capacity 388K, committed 512K, reserved 1048576K
     *
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * surviorRatio=4
     *             =2:4(Σs：eden)
     *             =1:6(s0:(eden+s0+1))
     * surviorRatio=8
     *             =1:1:8
     *             =10M*roundUP(8/(8+1+1))
     *        eden =8M
     * surviorRatio=6
     *             =1:1:6
     *             =10* roundUP(6/6+1+1)
     *             =7.5
     * surviorRatio =3
     *          eden= 10M*roundUP(3/(3+1+1))
     *              = 10M*0.6=6
     *
     *              =9
     *              =10*(9/(9+1+1))
     *
     * xmn=eden+s0+s1
     * yong=eden+s0
     * heap= yong+old
     *     = (eden+s0+s1)+old
     * old = heap-(eden+s0+s1)
     * XX:SurvivorRatio=s0占1，s1占1 eden占8
     *
     * gc日志分析
     * http://ctwen.iteye.com/blog/2092452
     *
     * [GC [<collector>: <starting occupancy1> -> <ending occupancy1>, <pause time1> secs] <starting occupancy3> -> <ending occupancy3>, <pause time3> secs]
     * <collector>GC收集器的名称
     *
     * <starting occupancy1> 新生代在GC前占用的内存
     * <ending occupancy1> 新生代在GC后占用的内存
     * <pause time1> 新生代局部收集时jvm暂停处理的时间
     *
     * <starting occupancy3> JVM Heap 在GC前占用的内存
     * <ending occupancy3> JVM Heap 在GC后占用的内存
     * <pause time3> GC过程中jvm暂停处理的总时间
     *
     *  https://blog.csdn.net/en_joker/article/details/79788568anben
     *
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4,allocation5,allocation6;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
        //allocation5 = new byte[100* _1MB];//这里会内存溢出
    }
    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     *  -XX:+UseSerialGC -XX:+PrintTenuringDistribution
     * 在经历了多次的Minor GC后仍然存活：在触发了Minor GC后，存活对象被存入Survivor区在经历了多次Minor GC之后，如果仍然存活的话，则该对象被晋升到Old区。
     * 虚拟机既然采用了分代收集的思想来管理内存，那内存回收时就必须能识别哪些对象应当放在新生代，哪些对象应放在老年代中。为了做到这点，虚拟机给每个对象定义了一个对象年龄（Age）计数器。
     * 如果对象在Eden出生并经过第一次Minor GC后仍然存活，并且能被Survivor容纳的话，将被移动到Survivor空间中，并将对象年龄设为1。对象在Survivor区中每熬过一次Minor GC，
     * 年龄就增加1岁，当它的年龄增加到一定程度（默认为15岁）时，就会被晋升到老年代中。对象晋升老年代的年龄阈值，可以通过参数-XX:MaxTenuringThreshold来设置。
     * Minor GC后Survivor空间不足就直接放入Old区
     */

    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        // 什么时候进入老年代决定于XX:MaxTenuringThreshold设置
        allocation1 = new byte[_1MB / 4];
        System.out.println("1");
        allocation2 = new byte[4 * _1MB];
        System.out.println("2");
        allocation3 = new byte[4 * _1MB];
        System.out.println("3");
        allocation3 = null;
        System.out.println("4");
        allocation3 = new byte[4 * _1MB];
        System.out.println("5");
    }

}
