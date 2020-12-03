package com.nz.test.domain;

import org.apache.ibatis.type.Alias;

@Alias("BaseResultMap")
public class Task {

    private Integer id;

    private String name;

    private Integer type;

    private Integer status;

    private Long cTime;

    private Long sTime;

    private Long eTime;

    private Integer progress;

    private Integer startStyle;

    private String startParam;

    private Integer serviceId;

    private Integer envType;

    private String envId;

    private String faultId;

    private Integer caseId;

    private String failReason;

    private String executeLog;

    private boolean isDelete;

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getcTime() {
        return cTime;
    }

    public void setcTime(Long cTime) {
        this.cTime = cTime;
    }

    public Long getsTime() {
        return sTime;
    }

    public void setsTime(Long sTime) {
        this.sTime = sTime;
    }

    public Long geteTime() {
        return eTime;
    }

    public void seteTime(Long eTime) {
        this.eTime = eTime;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getStartStyle() {
        return startStyle;
    }

    public void setStartStyle(Integer startStyle) {
        this.startStyle = startStyle;
    }

    public String getStartParam() {
        return startParam;
    }

    public void setStartParam(String startParam) {
        this.startParam = startParam;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getEnvType() {
        return envType;
    }

    public void setEnvType(Integer envType) {
        this.envType = envType;
    }

    public String getEnvId() {
        return envId;
    }

    public void setEnvId(String envId) {
        this.envId = envId;
    }

    public String getFaultId() {
        return faultId;
    }

    public void setFaultId(String faultId) {
        this.faultId = faultId;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getExecuteLog() {
        return executeLog;
    }

    public void setExecuteLog(String executeLog) {
        this.executeLog = executeLog;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
