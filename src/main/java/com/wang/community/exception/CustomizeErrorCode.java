package com.wang.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001, "这个问题不见了，去找找别的吧"),
    TARGET_PARAM_NOT_FOUND(2002, "先选择问题才能回复哟"),
    NO_LOGIN(2003, "请先登录再进行此操作"),
    SYS_ERROR(2004, "服务器故障，请稍后再试"),
    TYPE_PARAM_WRONG(2005, "操作错误，评论不存在"),
    COMMENT_NOT_FOUND(2006, "评论不存在，换一个试试"),
    CONTENT_IS_EMPTY(2007, "输入内容不能为空")
    ;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

}