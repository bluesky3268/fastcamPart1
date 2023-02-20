package org.example.ch6.mvc;

import org.example.ch6.annotation.RequestMethod;

import java.util.Objects;

public class HandlerKey {

    private RequestMethod method;
    private String uriPath;

    public HandlerKey(RequestMethod method, String uriPath) {
        this.method = method;
        this.uriPath = uriPath;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public String getUriPath() {
        return uriPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlerKey that = (HandlerKey) o;
        return method == that.method && Objects.equals(uriPath, that.uriPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, uriPath);
    }


}
