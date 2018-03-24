package com.example.mochenmanhua.data.HttpData.retrofit.entity;

/**
 * Created by Administrator on 2018/3/19.
 */

public class Detail {

    /**
     * error_code : 216301
     * reason : Not Found
     * result : {"comicName":"斗破苍穹","chapterId":404}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * comicName : 斗破苍穹
         * chapterId : 404
         */

        private String comicName;
        private int chapterId;

        public String getComicName() {
            return comicName;
        }

        public void setComicName(String comicName) {
            this.comicName = comicName;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }
    }
}
