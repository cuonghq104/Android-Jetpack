package com.example.jetpack.viewmodels;

public class ResourceListener<T> {
    private ViewModelStatus status;
    private String message;
    private T data;

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public ViewModelStatus getStatus() {
        return status;
    }

    public ResourceListener<T> success(T data) {
        this.data = data;
        this.message = null;
        this.status = ViewModelStatus.SUCCESS;
        return this;
    }

    public ResourceListener<T> error(String message, T data) {
        this.data = data;
        this.message = message;
        this.status = ViewModelStatus.ERROR;
        return this;
    }

    public ResourceListener<T> loading(String message, T data) {
        this.data = data;
        this.message = message;
        this.status = ViewModelStatus.LOADING;
        return this;
    }

}
