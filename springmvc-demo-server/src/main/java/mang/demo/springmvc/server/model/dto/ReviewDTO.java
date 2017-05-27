package mang.demo.springmvc.server.model.dto;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;

/**
 *  ReviewRequest的DTO
 */
public class ReviewDTO implements Serializable {
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
    private String shipName;

    /**
     * 航次
     */
//    private String shipFlight;

    /**
     * 代理名称
     */
    private String agentName;
    
    /**
     * 代理编号
     */
//    private String agentCode;

    /**
     * 货主名称
     */
    private String customName;
    
    /**
     * 货主编号
     */
//    private String customCode;

    /**
     * 用户流向名称
     */
    private String customerName;

//    /**
//     * 货物原产地名称
//     */
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
     * MESS
     */
    private String mess;

    /**
     * 亏吨提醒，毛重小于该数值则提醒 单位kg
     */
    private Long outstoreminquan;

    /**
     * 货位名称
     */
//    private String goodsalloName;

    /**
     * 所属仓库编号
     */
    private String storecode;
    
    /**
     * 所属仓库
     */
    private Long storeId;

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
     * 货物编号
     */
//    private String goodsCode;

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

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipName() {
        return shipName;
    }


    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
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

	public String getStorecode() {
		return storecode;
	}

	public void setStorecode(String storecode) {
		this.storecode = storecode;
	}

//	public String getShipFlight() {
//		return shipFlight;
//	}
//
//	public void setShipFlight(String shipFlight) {
//		this.shipFlight = shipFlight;
//	}

//	public String getGopaddName() {
//		return gopaddName;
//	}
//
//	public void setGopaddName(String gopaddName) {
//		this.gopaddName = gopaddName;
//	}

//	public String getTaste() {
//		return taste;
//	}
//
//	public void setTaste(String taste) {
//		this.taste = taste;
//	}

//	public String getRfidType() {
//		return rfidType;
//	}
//
//	public void setRfidType(String rfidType) {
//		this.rfidType = rfidType;
//	}

//	public String getGoodsWater() {
//		return goodsWater;
//	}
//
//	public void setGoodsWater(String goodsWater) {
//		this.goodsWater = goodsWater;
//	}

//	public String getGoodssortName() {
//		return goodssortName;
//	}
//
//	public void setGoodssortName(String goodssortName) {
//		this.goodssortName = goodssortName;
//	}

//	public String getGoodsName() {
//		return goodsName;
//	}
//
//	public void setGoodsName(String goodsName) {
//		this.goodsName = goodsName;
//	}

//	public Double getPlanTons() {
//		return planTons;
//	}
//
//	public void setPlanTons(Double planTons) {
//		this.planTons = planTons;
//	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getRuname() {
		return runame;
	}

	public void setRuname(String runame) {
		this.runame = runame;
	}

//	public String getAgentCode() {
//		return agentCode;
//	}
//
//	public void setAgentCode(String agentCode) {
//		this.agentCode = agentCode;
//	}

//	public String getCustomCode() {
//		return customCode;
//	}
//
//	public void setCustomCode(String customCode) {
//		this.customCode = customCode;
//	}

//	public String getGoodsCode() {
//		return goodsCode;
//	}
//
//	public void setGoodsCode(String goodsCode) {
//		this.goodsCode = goodsCode;
//	}
	
    
}
