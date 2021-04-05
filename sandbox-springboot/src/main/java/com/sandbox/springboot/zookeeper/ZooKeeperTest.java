package com.sandbox.springboot.zookeeper;

import com.aio.portable.swiss.module.zookeeper.ZooKeeperSugar;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZooKeeperTest {
    ZooKeeper zooKeeper;
    String address = "192.168.71.254:2181";
    int sessionTimeout = 500000;



    public void main() throws IOException {
        zooKeeper = ZooKeeperSugar.build(address, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent+"!!!!!!!!!!!!!!!!!!");
                System.out.println(watchedEvent.getState());
                if (Event.KeeperState.SyncConnected == watchedEvent.getState())
                    System.out.println("Connect OK!!!!!!!!!!!!!!!!1");
            }
        });
        System.out.println(zooKeeper.getState());


        try {
            String path = "/abc/def";
            path = "/zk";
            String bbb = ZooKeeperSugar.createEphemeralSequential(zooKeeper, path);// /zk0000000001
            String ccc = ZooKeeperSugar.createEphemeralSequential(zooKeeper, path);// /zk0000000002
            Stat stat = zooKeeper.exists(path, false);
            Stat stat2 = zooKeeper.exists(path, true);
//            if (stat.)
//            zooKeeper.create()
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
