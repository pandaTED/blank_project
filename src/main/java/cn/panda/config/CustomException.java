package cn.panda.config;

public class CustomException extends RuntimeException {

    private String retCd ;  //异常对应的返回码
    private String msgDes;  //异常对应的描述信息

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
        msgDes = message;
    }

    public CustomException(String retCd, String msgDes) {
        super();
        this.retCd = retCd;
        this.msgDes = msgDes;
    }

    public String getRetCd() {
        return retCd;
    }

    public String getMsgDes() {
        return msgDes;
    }

}
