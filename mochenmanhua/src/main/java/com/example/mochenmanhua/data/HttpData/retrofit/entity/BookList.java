package com.example.mochenmanhua.data.HttpData.retrofit.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/3/19.
 */

public class BookList {

    /**
     * error_code : 200
     * reason : 请求成功！
     * result : {"total":503,"comicName":"斗罗大陆","chapterList":[{"name":"番外篇-钟情","id":195350},{"name":"番外篇-饭之爱","id":195351},{"name":"番外篇-Friend朋友","id":195352},{"name":"番外篇-一天的另一面","id":195353},{"name":"番外","id":195354},{"name":"第01话","id":195355},{"name":"第02话","id":195356},{"name":"第03话","id":195357},{"name":"第04话","id":195358},{"name":"第05话","id":195359},{"name":"第06话","id":195360},{"name":"第07话","id":195361},{"name":"第08话","id":195362},{"name":"第09话","id":195363},{"name":"第10话","id":195364},{"name":"第11话","id":195365},{"name":"第12话","id":195366},{"name":"第13话","id":195367},{"name":"第14话","id":195368},{"name":"第15话","id":195369}],"limit":20,"skip":1}
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
         * total : 503
         * comicName : 斗罗大陆
         * chapterList : [{"name":"番外篇-钟情","id":195350},{"name":"番外篇-饭之爱","id":195351},{"name":"番外篇-Friend朋友","id":195352},{"name":"番外篇-一天的另一面","id":195353},{"name":"番外","id":195354},{"name":"第01话","id":195355},{"name":"第02话","id":195356},{"name":"第03话","id":195357},{"name":"第04话","id":195358},{"name":"第05话","id":195359},{"name":"第06话","id":195360},{"name":"第07话","id":195361},{"name":"第08话","id":195362},{"name":"第09话","id":195363},{"name":"第10话","id":195364},{"name":"第11话","id":195365},{"name":"第12话","id":195366},{"name":"第13话","id":195367},{"name":"第14话","id":195368},{"name":"第15话","id":195369}]
         * limit : 20
         * skip : 1
         */

        private int total;
        private String comicName;
        private int limit;
        private int skip;
        private List<ChapterListBean> chapterList;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getComicName() {
            return comicName;
        }

        public void setComicName(String comicName) {
            this.comicName = comicName;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getSkip() {
            return skip;
        }

        public void setSkip(int skip) {
            this.skip = skip;
        }

        public List<ChapterListBean> getChapterList() {
            return chapterList;
        }

        public void setChapterList(List<ChapterListBean> chapterList) {
            this.chapterList = chapterList;
        }

        public static class ChapterListBean {
            /**
             * name : 番外篇-钟情
             * id : 195350
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
