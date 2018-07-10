package com.example.springboot2docker.util.docker;

import com.example.springboot2docker.util.DockerUtils;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DockerInfoUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DockerInfoUtil.class);

    private static DockerClient dockerClient = DockerUtils.getDockerClient();


    public static void getDockerInfo() {
        Info info = dockerClient.infoCmd().exec();
        System.out.println(info.getSystemStatus());
    }




}
