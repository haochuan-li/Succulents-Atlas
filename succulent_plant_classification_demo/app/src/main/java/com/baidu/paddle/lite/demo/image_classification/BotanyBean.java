package com.baidu.paddle.lite.demo.image_classification;

import java.io.Serializable;

public class BotanyBean implements Serializable {
    private String name;//名字
    private String family;//科
    private String genus;//属
    private String introduce;//介绍
    private String image;//图片地址

    public BotanyBean() {
    }

    public BotanyBean(String name, String family, String genus,String image, String introduce) {
        this.name = name;
        this.family = family;
        this.genus = genus;
        this.introduce = introduce;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "BotanyBean{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", genus='" + genus + '\'' +
                ", introduce='" + introduce + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
