package com.jobcenter.model;

/**
 * Created  on 10/29/2016.
 */
public class DataResponse<T> {
    private T result;
    private String error;

    public DataResponse(String error) {
        this.error = error;
    }

    public DataResponse(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean hasErrorMessage() {
        return this.error != null;
    }
}
