package com.example.springboot2docker.util;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;

public class DockerUtils {
    private static DockerClient dockerClient;

    DockerUtils() {
    }

    public static DockerClient getDockerClient() {
        if (dockerClient == null) {
            synchronized (DockerUtils.class) {
                if (dockerClient == null) {
                    // 默认情况下，Docker daemon监听unix://var/run/docker.sock，并且客户端必须有root权限用来与daemon交互。
                    dockerClient = DockerClientBuilder.getInstance().build();
                }
            }
        }
        return dockerClient;
    }
}
