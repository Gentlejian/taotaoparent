package com.taotao.rest.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.tools.internal.xjc.model.SymbolSpace;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(JedisTest.class);

    @Test
    public void testJedisSingle() {
        //创建一个jedis的对象。
        /*Jedis jedis = new Jedis("192.168.223.128", 7001);
        //调用jedis对象的方法，方法名称和redis的命令一致。
        jedis.setnx("key2", "jedis test");
        String string = jedis.get("key2");
        System.out.println(string);
        //关闭jedis。
        jedis.close();*/

        HostAndPort hostAndPort = new HostAndPort("192.168.223.128", 7001);
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        hostAndPortSet.add(hostAndPort);
        JedisCluster jedis = new JedisCluster(hostAndPortSet);
        jedis.setnx("bbbbb", "1234");
    }

    /**
     * 使用连接池
     */
    @Test
    public void testJedisPool() {
        //创建jedis连接池
        JedisPool pool = new JedisPool("192.168.223.128", 7001);
        //从连接池中获得Jedis对象
        Jedis jedis = pool.getResource();
        String string = jedis.get("bbbbb");
        System.out.println(string);
        //关闭jedis对象
        jedis.close();
        pool.close();
    }

    /**
     * 集群版测试
     * <p>Title: testJedisCluster</p>
     * <p>Description: </p>
     */
    @Test
    public void testJedisCluster() {
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.223.128", 7001));
        nodes.add(new HostAndPort("192.168.223.128", 7002));
        nodes.add(new HostAndPort("192.168.223.128", 7003));
        nodes.add(new HostAndPort("192.168.223.128", 7004));
        nodes.add(new HostAndPort("192.168.223.128", 7005));
        nodes.add(new HostAndPort("192.168.223.128", 7006));
        JedisCluster cluster = new JedisCluster(nodes);
        System.out.println(cluster);
        cluster.setnx("aaa", "1000");

        String string = cluster.get("aaa");
        System.out.println(string);
        cluster.close();

    }

    /**
     * 单机版测试
     * <p>Title: testSpringJedisSingle</p>
     * <p>Description: </p>
     */
    @Test
    public void testSpringJedisSingle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        JedisPool pool = (JedisPool) applicationContext.getBean("redisClient");
        Jedis jedis = pool.getResource();
        String string = jedis.get("key1");
        System.out.println(string);
        jedis.close();
        pool.close();
    }

    @Test
    public void testSpringJedisCluster() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        JedisCluster jedisCluster =  (JedisCluster) applicationContext.getBean("redisClient");
        String string = jedisCluster.get("key1");
        System.out.println(string);
        jedisCluster.close();
    }
}
