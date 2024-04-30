package art.dborg.library_management.v1.core.resutl;


import lombok.Getter;

@Getter
public class ResultData <T> extends Result{
    private T data;

    public ResultData(boolean status, String message, String httpCode, T data) {
        super(status, message, httpCode);
        this.data = data;
    }

}
