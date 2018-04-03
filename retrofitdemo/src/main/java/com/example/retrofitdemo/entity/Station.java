package com.example.retrofitdemo;

import java.util.List;

/**
 * Created by Administrator on 2018/3/18.
 */

public class Station {

    /**
     * resultcode : 200
     * reason : Successed!
     * result : {"train_info":{"name":"G656","start":"西安北","end":"北京西","starttime":"10:10","endtime":"16:27","mileage":"1212km"},"station_list":[{"train_id":"1","station_name":"西安北","arrived_time":"-","leave_time":"10:10","mileage":"-","fsoftSeat":"-","ssoftSeat":"-","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"-","swz":"-","tdz":"-","gjrw":"-","stay":"-"},{"train_id":"2","station_name":"渭南北","arrived_time":"10:29","leave_time":"10:31","mileage":"63km","fsoftSeat":"44.5","ssoftSeat":"29.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"29.5","swz":"90.5","tdz":"-","gjrw":"-","stay":"2"},{"train_id":"3","station_name":"华山北","arrived_time":"10:51","leave_time":"11:02","mileage":"121km","fsoftSeat":"89.5","ssoftSeat":"54.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"54.5","swz":"175.5","tdz":"-","gjrw":"-","stay":"11"},{"train_id":"4","station_name":"三门峡南","arrived_time":"11:35","leave_time":"11:37","mileage":"257km","fsoftSeat":"189.5","ssoftSeat":"119.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"119.5","swz":"372.5","tdz":"-","gjrw":"-","stay":"2"},{"train_id":"5","station_name":"渑池南","arrived_time":"11:54","leave_time":"11:56","mileage":"315km","fsoftSeat":"229.5","ssoftSeat":"144.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"144.5","swz":"456.5","tdz":"-","gjrw":"-","stay":"2"},{"train_id":"6","station_name":"洛阳龙门","arrived_time":"12:15","leave_time":"12:17","mileage":"380km","fsoftSeat":"279.5","ssoftSeat":"174.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"174.5","swz":"550.5","tdz":"-","gjrw":"-","stay":"2"},{"train_id":"7","station_name":"巩义南","arrived_time":"12:31","leave_time":"12:33","mileage":"430km","fsoftSeat":"314.0","ssoftSeat":"199.0","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"199.0","swz":"623.0","tdz":"-","gjrw":"-","stay":"2"},{"train_id":"8","station_name":"郑州","arrived_time":"13:06","leave_time":"13:09","mileage":"505km","fsoftSeat":"369.0","ssoftSeat":"229.0","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"229.0","swz":"731.0","tdz":"-","gjrw":"-","stay":"3"},{"train_id":"9","station_name":"郑州东","arrived_time":"13:25","leave_time":"13:28","mileage":"519km","fsoftSeat":"379.0","ssoftSeat":"237.0","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"237.0","swz":"749.0","tdz":"-","gjrw":"-","stay":"3"},{"train_id":"10","station_name":"邯郸东","arrived_time":"14:21","leave_time":"14:25","mileage":"756km","fsoftSeat":"536.0","ssoftSeat":"335.0","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"335.0","swz":"1059.0","tdz":"-","gjrw":"-","stay":"4"},{"train_id":"11","station_name":"石家庄","arrived_time":"15:04","leave_time":"15:07","mileage":"931km","fsoftSeat":"651.5","ssoftSeat":"407.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"407.5","swz":"1286.5","tdz":"-","gjrw":"-","stay":"3"},{"train_id":"12","station_name":"涿州东","arrived_time":"15:59","leave_time":"16:02","mileage":"1150km","fsoftSeat":"785.5","ssoftSeat":"491.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"491.5","swz":"1551.5","tdz":"-","gjrw":"-","stay":"3"},{"train_id":"13","station_name":"北京西","arrived_time":"16:27","leave_time":"16:27","mileage":"1212km","fsoftSeat":"822.5","ssoftSeat":"513.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"513.5","swz":"1623.5","tdz":"-","gjrw":"-","stay":"-"}]}
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private ResultBean result;
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
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

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * train_info : {"name":"G656","start":"西安北","end":"北京西","starttime":"10:10","endtime":"16:27","mileage":"1212km"}
         * station_list : [{"train_id":"1","station_name":"西安北","arrived_time":"-","leave_time":"10:10","mileage":"-","fsoftSeat":"-","ssoftSeat":"-","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"-","swz":"-","tdz":"-","gjrw":"-","stay":"-"},{"train_id":"2","station_name":"渭南北","arrived_time":"10:29","leave_time":"10:31","mileage":"63km","fsoftSeat":"44.5","ssoftSeat":"29.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"29.5","swz":"90.5","tdz":"-","gjrw":"-","stay":"2"},{"train_id":"3","station_name":"华山北","arrived_time":"10:51","leave_time":"11:02","mileage":"121km","fsoftSeat":"89.5","ssoftSeat":"54.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"54.5","swz":"175.5","tdz":"-","gjrw":"-","stay":"11"},{"train_id":"4","station_name":"三门峡南","arrived_time":"11:35","leave_time":"11:37","mileage":"257km","fsoftSeat":"189.5","ssoftSeat":"119.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"119.5","swz":"372.5","tdz":"-","gjrw":"-","stay":"2"},{"train_id":"5","station_name":"渑池南","arrived_time":"11:54","leave_time":"11:56","mileage":"315km","fsoftSeat":"229.5","ssoftSeat":"144.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"144.5","swz":"456.5","tdz":"-","gjrw":"-","stay":"2"},{"train_id":"6","station_name":"洛阳龙门","arrived_time":"12:15","leave_time":"12:17","mileage":"380km","fsoftSeat":"279.5","ssoftSeat":"174.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"174.5","swz":"550.5","tdz":"-","gjrw":"-","stay":"2"},{"train_id":"7","station_name":"巩义南","arrived_time":"12:31","leave_time":"12:33","mileage":"430km","fsoftSeat":"314.0","ssoftSeat":"199.0","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"199.0","swz":"623.0","tdz":"-","gjrw":"-","stay":"2"},{"train_id":"8","station_name":"郑州","arrived_time":"13:06","leave_time":"13:09","mileage":"505km","fsoftSeat":"369.0","ssoftSeat":"229.0","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"229.0","swz":"731.0","tdz":"-","gjrw":"-","stay":"3"},{"train_id":"9","station_name":"郑州东","arrived_time":"13:25","leave_time":"13:28","mileage":"519km","fsoftSeat":"379.0","ssoftSeat":"237.0","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"237.0","swz":"749.0","tdz":"-","gjrw":"-","stay":"3"},{"train_id":"10","station_name":"邯郸东","arrived_time":"14:21","leave_time":"14:25","mileage":"756km","fsoftSeat":"536.0","ssoftSeat":"335.0","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"335.0","swz":"1059.0","tdz":"-","gjrw":"-","stay":"4"},{"train_id":"11","station_name":"石家庄","arrived_time":"15:04","leave_time":"15:07","mileage":"931km","fsoftSeat":"651.5","ssoftSeat":"407.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"407.5","swz":"1286.5","tdz":"-","gjrw":"-","stay":"3"},{"train_id":"12","station_name":"涿州东","arrived_time":"15:59","leave_time":"16:02","mileage":"1150km","fsoftSeat":"785.5","ssoftSeat":"491.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"491.5","swz":"1551.5","tdz":"-","gjrw":"-","stay":"3"},{"train_id":"13","station_name":"北京西","arrived_time":"16:27","leave_time":"16:27","mileage":"1212km","fsoftSeat":"822.5","ssoftSeat":"513.5","hardSead":"-","softSeat":"-","hardSleep":"-","softSleep":"-","wuzuo":"513.5","swz":"1623.5","tdz":"-","gjrw":"-","stay":"-"}]
         */

        private TrainInfoBean train_info;
        private List<StationListBean> station_list;

        public TrainInfoBean getTrain_info() {
            return train_info;
        }

        public void setTrain_info(TrainInfoBean train_info) {
            this.train_info = train_info;
        }

        public List<StationListBean> getStation_list() {
            return station_list;
        }

        public void setStation_list(List<StationListBean> station_list) {
            this.station_list = station_list;
        }

        public static class TrainInfoBean {
            /**
             * name : G656
             * start : 西安北
             * end : 北京西
             * starttime : 10:10
             * endtime : 16:27
             * mileage : 1212km
             */

            private String name;
            private String start;
            private String end;
            private String starttime;
            private String endtime;
            private String mileage;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public String getMileage() {
                return mileage;
            }

            public void setMileage(String mileage) {
                this.mileage = mileage;
            }
        }

        public static class StationListBean {
            /**
             * train_id : 1
             * station_name : 西安北
             * arrived_time : -
             * leave_time : 10:10
             * mileage : -
             * fsoftSeat : -
             * ssoftSeat : -
             * hardSead : -
             * softSeat : -
             * hardSleep : -
             * softSleep : -
             * wuzuo : -
             * swz : -
             * tdz : -
             * gjrw : -
             * stay : -
             */

            private String train_id;
            private String station_name;
            private String arrived_time;
            private String leave_time;
            private String mileage;
            private String fsoftSeat;
            private String ssoftSeat;
            private String hardSead;
            private String softSeat;
            private String hardSleep;
            private String softSleep;
            private String wuzuo;
            private String swz;
            private String tdz;
            private String gjrw;
            private String stay;

            public String getTrain_id() {
                return train_id;
            }

            public void setTrain_id(String train_id) {
                this.train_id = train_id;
            }

            public String getStation_name() {
                return station_name;
            }

            public void setStation_name(String station_name) {
                this.station_name = station_name;
            }

            public String getArrived_time() {
                return arrived_time;
            }

            public void setArrived_time(String arrived_time) {
                this.arrived_time = arrived_time;
            }

            public String getLeave_time() {
                return leave_time;
            }

            public void setLeave_time(String leave_time) {
                this.leave_time = leave_time;
            }

            public String getMileage() {
                return mileage;
            }

            public void setMileage(String mileage) {
                this.mileage = mileage;
            }

            public String getFsoftSeat() {
                return fsoftSeat;
            }

            public void setFsoftSeat(String fsoftSeat) {
                this.fsoftSeat = fsoftSeat;
            }

            public String getSsoftSeat() {
                return ssoftSeat;
            }

            public void setSsoftSeat(String ssoftSeat) {
                this.ssoftSeat = ssoftSeat;
            }

            public String getHardSead() {
                return hardSead;
            }

            public void setHardSead(String hardSead) {
                this.hardSead = hardSead;
            }

            public String getSoftSeat() {
                return softSeat;
            }

            public void setSoftSeat(String softSeat) {
                this.softSeat = softSeat;
            }

            public String getHardSleep() {
                return hardSleep;
            }

            public void setHardSleep(String hardSleep) {
                this.hardSleep = hardSleep;
            }

            public String getSoftSleep() {
                return softSleep;
            }

            public void setSoftSleep(String softSleep) {
                this.softSleep = softSleep;
            }

            public String getWuzuo() {
                return wuzuo;
            }

            public void setWuzuo(String wuzuo) {
                this.wuzuo = wuzuo;
            }

            public String getSwz() {
                return swz;
            }

            public void setSwz(String swz) {
                this.swz = swz;
            }

            public String getTdz() {
                return tdz;
            }

            public void setTdz(String tdz) {
                this.tdz = tdz;
            }

            public String getGjrw() {
                return gjrw;
            }

            public void setGjrw(String gjrw) {
                this.gjrw = gjrw;
            }

            public String getStay() {
                return stay;
            }

            public void setStay(String stay) {
                this.stay = stay;
            }
        }
    }
}
