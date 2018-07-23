package com.example.springboot2docker.config;

import com.weibo.api.motan.config.springsupport.BasicRefererConfigBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MotanBean {
    @Bean(name = "motan_message")
    public ProtocolConfigBean protocolConfig() {
        ProtocolConfigBean config = new ProtocolConfigBean();
        config.setDefault(true);
        config.setName("motan");
        config.setSerialization("hessian2");
        config.setLoadbalance("activeWeight");
        config.setHaStrategy("failover");
        config.setMaxWorkerThread(200);
        config.setMinWorkerThread(20);
        config.setMaxClientConnection(10);
        config.setMinClientConnection(2);

        return config;
    }

    @Bean(name = "registryConfig")
    public RegistryConfigBean registryConfig() {
        RegistryConfigBean config = new RegistryConfigBean();
        config.setRegProtocol("zookeeper");
        config.setName("sdzz_zookeeper");
        config.setAddress("192.168.10.6:2181");
        config.setConnectTimeout(30000);
        return config;
    }

    @Bean(name = "basicRefererConfig")
    public BasicRefererConfigBean basicRefererConfigBean() {
        BasicRefererConfigBean config = new BasicRefererConfigBean();
        config.setShareChannel(true);
        config.setCheck(false);
        config.setRequestTimeout(30000);
        config.setVersion("wujiapeng");
        config.setRegistry("registryConfig");
        config.setFilter("motanCat,traceIdReferer");
        config.setAccessLog(true);
        config.setFilter("motanCat");

        return config;
    }
}
