package mang.demo.springmvc.server.model.request;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 原BuPlanRelationCarTemp表
 */
public class ReviewRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * rfid
     * */
    private String rfid;

    /**
     * 计划单号
     */
    private String pno;

    /**
     * 社会车队名称
     */
//    private String outFleet;

    /**
     * 车牌号
     */
    private String plate;

    /**
     * 车型
     */
//    private String carType;

    /**
     * 司机姓名
     */
    private String carDriver;

    /**
     * 司机电话
     */
    private String driverTelephone;

    /**
     * 车辆载重
     */
//    private String carLoad;

    /**
     * 派车时间
     */
    private Timestamp sendCarTime;

    /**
     * 船名
     */
//    private String shipName;

    /**
     * 航次
     */
//    private String shipFlight;

    /**
     * 代理名称
     */
//    private String agentName;

    /**
     * 货主名称
     */
//    private String customName;

    /**
     * 用户流向名称
     */
//    private String customerName;

    /**
     * 货物原产地名称
     */
//    private String gopaddName;

    /**
     * 品位
     */
//    private String taste;

    /**
     * 意见留言
     */
//    private String message;

    /**
     * RFID类型(1:单次 2:循环)
     */
//    private String rfidType;

    /**
     * 来源id
     */
//    private Long lyid;

    /**
     * 超载限制，毛重大于该数值则禁止过磅 单位kg
     */
    private Long outstoremaxquan;

    /**
     * 亏吨提醒，毛重小于该数值则提醒 单位kg
     */
    private Long outstoreminquan;
    
    
    /**
     * MESS
     */
    private String mess;

    /**
     * 货位名称
     */
//    private String goodsalloName;

    /**
     * 所属仓库编号
     */
//    private String storecode;

    /**
     * 水分
     */
//    private String goodsWater;

    /**
     * 货物种类名称
     */
//    private String goodssortName;

    /**
     * 货物名称
     */
//    private String goodsName;

    /**
     * 作业计划吨
     */
//    private Double planTons;

    /**
     * 所属仓库序号
     */
//    private BigDecimal storeid;

    /**
     * 所属仓库名称
     */
    private String storename;

    /**
     * 扩展字段1
     */
//    private String ext1;

    /**
     * 扩展字段2
     */
//    private String ext2;

    /**
     * 制单人代码
     */
//    private String ruid;

    /**
     * 制单人姓名
     */
//    private String runame;

    /**
     * 制单日期
     */
//    private Timestamp recorddate;

    /**
     * 部门名称
     */
//    private String gdeptname;

    /**
     * 部门ID
     */
//    private String gdeptid;

    /**
     * 部门路径ID
     */
//    private String gdeptfullid;

    /**
     * 部门路径
     */
//    private String gdeptfullname;

    /**
     * 单位ID
     */
//    private String gcomid;

    /**
     * 单位名称
     */
//    private String gcomname;
    
    
    /**
     * 操作人姓名
     * */
    private String runame;


    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getPno() {
        return pno;
    }

//    public void setOutFleet(String outFleet) {
//        this.outFleet = outFleet;
//    }
//
//    public String getOutFleet() {
//        return outFleet;
//    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }


    public void setCarDriver(String carDriver) {
        this.carDriver = carDriver;
    }

    public String getCarDriver() {
        return carDriver;
    }

    public void setDriverTelephone(String driverTelephone) {
        this.driverTelephone = driverTelephone;
    }

    public String getDriverTelephone() {
        return driverTelephone;
    }


    public void setSendCarTime(Timestamp sendCarTime) {
        this.sendCarTime = sendCarTime;
    }

    public Timestamp getSendCarTime() {
        return sendCarTime;
    }


    public void setOutstoremaxquan(Long outstoremaxquan) {
        this.outstoremaxquan = outstoremaxquan;
    }

    public Long getOutstoremaxquan() {
        return outstoremaxquan;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getMess() {
        return mess;
    }

    public void setOutstoreminquan(Long outstoreminquan) {
        this.outstoreminquan = outstoreminquan;
    }

    public Long getOutstoreminquan() {
        return outstoreminquan;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getStorename() {
        return storename;
    }


	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public String getRuname() {
		return runame;
	}

	public void setRuname(String runame) {
		this.runame = runame;
	}
	
    
}
