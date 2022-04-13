package com.techelevator.model;

import java.util.Objects;

public class Hit {

    private String topic;
    private String category;
    private String module;
    private String externalUrl;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hit hit = (Hit) o;
        return Objects.equals(topic, hit.topic) && Objects.equals(category, hit.category) && Objects.equals(module, hit.module) && Objects.equals(externalUrl, hit.externalUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, category, module, externalUrl);
    }
}
