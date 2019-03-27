package commons.dto;

public class Response<T> {
    private boolean success = true;
    private T data;
    private BaseError error;

    public boolean isSuccess() {
        return success;
    }

    public Response<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public T getData() {
        return data;
    }

    public Response<T> setData(T data) {
        this.data = data;
        return this;
    }

    public BaseError getError() {
        return error;
    }

    public Response<T> setError(BaseError error) {
        this.error = error;
        return this;
    }
}
