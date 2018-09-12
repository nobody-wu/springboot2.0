package com.example.springboot2docker.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 10:33 2018/9/12
 */
public class FileUtils {
    private final Logger logger = LoggerFactory.getLogger(FileUtils.class);
    /**
     * 复制文件到目标地址，已经存在的话，会覆盖。
     *
     * @param sourceInputStream
     * @param targetPath
     * @return
     */
    public String copyFile(InputStream sourceInputStream, String targetPath) throws IOException {
        if (Objects.isNull(sourceInputStream) || StringUtils.isEmpty(targetPath) || targetPath.endsWith(File.separator)) {
            return null;
        }
        File target = new File(targetPath);
        if (!target.exists()) {
            boolean flag;
            if (!target.getParentFile().exists()) {
                flag = target.getParentFile().mkdirs();
                if (!flag) {
                    logger.error("mkdirs error, targetPath={}", targetPath);
                    return null;
                }
            }
            flag = target.createNewFile();
            if (!flag) {
                logger.error("createNewFile error, targetPath={}", targetPath);
                return null;
            }
        } else {
            logger.warn("targetPath already exist, targetPath={}", targetPath);
        }

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(target);
            byte[] b = new byte[1024];
            int length;
            while ((length = sourceInputStream.read(b)) != -1) {
                outputStream.write(b, 0, length);
                outputStream.flush();
            }
        } catch (Exception e) {
            logger.error("error....", e);
        } finally {
            sourceInputStream.close();
            if (Objects.nonNull(outputStream)) {
                outputStream.close();
            }
        }
        return target.getAbsolutePath();
    }
}
