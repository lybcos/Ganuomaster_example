package com.example.mochenmanhua.data.HttpData.retrofit.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/3/19.
 */

public class Chapter {

    /**
     * error_code : 200
     * reason : 请求成功！
     * result : {"total":558,"limit":20,"comicName":"火影忍者","chapterList":[{"name":"第01卷","id":139833},{"name":"第02卷","id":139834},{"name":"第03卷","id":139836},{"name":"第04卷","id":139837}]}
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
         * total : 558
         * limit : 20
         * comicName : 火影忍者
         * chapterList : [{"name":"第01卷","id":139833},{"name":"第02卷","id":139834},{"name":"第03卷","id":139836},{"name":"第04卷","id":139837}]
         */

        private int total;
        private int limit;
        private String comicName;
        private List<ChapterListBean> chapterList;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public String getComicName() {
            return comicName;
        }

        public void setComicName(String comicName) {
            this.comicName = comicName;
        }

        public List<ChapterListBean> getChapterList() {
            return chapterList;
        }

        public void setChapterList(List<ChapterListBean> chapterList) {
            this.chapterList = chapterList;
        }

        public static class ChapterListBean {
            /**
             * name : 第01卷
             * id : 139833
             */

            private String name;
            private int id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
