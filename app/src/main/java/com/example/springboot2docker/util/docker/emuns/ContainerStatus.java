package com.example.springboot2docker.util.docker.emuns;


public enum ContainerStatus {
    PAUSED("paused", "暂停"),
    CREATED("created", "创建"),
    RUNNING("running", "运行"),
    EXITED("exited", "退出"),;

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ContainerStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
