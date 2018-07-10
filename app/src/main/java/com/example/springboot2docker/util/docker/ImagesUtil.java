package com.example.springboot2docker.util.docker;

import com.example.springboot2docker.util.DockerUtils;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.SearchItem;
import com.github.dockerjava.core.command.PullImageResultCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImagesUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImagesUtil.class);

    private static DockerClient dockerClient = DockerUtils.getDockerClient();

    /**
     * 获取已下载的镜像列表
     *
     * @return List<Image>
     */
    public static List<Image> getImages() {
        return dockerClient.listImagesCmd().exec();
    }

    /**
     * 获取已下载的镜像列表
     *
     * @param imageName 镜像名称
     * @return List<Image>
     */
    public static List<Image> getImages(String imageName) {
        return dockerClient.listImagesCmd().withImageNameFilter(imageName).exec();
    }

    /**
     * 删除镜像 docker rmi imageId
     *
     * @param imageId 镜像id
     */
    public static void removeImage(String imageId) {
        dockerClient.removeImageCmd(imageId).exec();
        LOGGER.debug("【removeImage】：imageID：" + imageId);
    }

    /**
     * 删除镜像  docker stop containerId -> docker rm containerId -> docker rmi containerId
     *
     * @param containerId 容器id
     */
    public static void removeImageC(String containerId) {
        // 获取imageId
        String imageId = dockerClient.commitCmd(containerId).exec();

        // 停止容器
        dockerClient.stopContainerCmd(containerId).exec();

        // 删除容器
        dockerClient.removeContainerCmd(containerId).exec();

        // 删除镜像
        dockerClient.removeImageCmd(imageId);

        LOGGER.debug("【removeImage】：containerId：" + containerId);
    }

    public static List<SearchItem> searchImage(String term) {
        return dockerClient.searchImagesCmd(term).exec();
    }

    /**
     * 拉取镜像
     *
     * @param imageName 镜像名称 logr/alpine-glibc
     * @throws Exception
     */
    public static void pullImage(String imageName) throws Exception {
        dockerClient.pullImageCmd(imageName).exec(new PullImageResultCallback()).awaitCompletion(30, TimeUnit.SECONDS);
    }

}
