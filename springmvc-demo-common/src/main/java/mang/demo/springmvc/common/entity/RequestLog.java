package mang.demo.springmvc.common.entity;



import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "m_request_log")
public class RequestLog implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", nullable = true)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    /**
     * requestDate
     */
    @Column(name = "REQUEST_DATE", nullable = true)    
    private Timestamp requestDate ;
    
    /**
     * requestMethod
     */
    @Column(name = "REQUEST_METHOD", nullable = true)    
    private String requestMethod ;

    /**
     * requestIp
     */
    @Column(name = "REQUEST_IP", nullable = true)    
    private String requestIp;
    
    /**
     * requestIp
     */
    @Column(name = "REQUEST_ADDR", nullable = true)    
    private String requestAddr;
    
    

    /**
     * classSimpleName
     */
    @Column(name = "CLASS_SIMPLE_NAME", nullable = true)  
    private String classSimpleName;

    /**
     * method
     */
    @Column(name = "METHOD", nullable = true)  
    private String method;

    /**
     * inStr
     */
    @Column(name = "IN_STR", nullable = true) 
    private String inStr;

    /**
     * outMsg
     */
    @Column(name = "OUT_MSG", nullable = true) 
    private String outMsg;
    
    
    /**
     * outCode
     */
    @Column(name = "OUT_CODE", nullable = true) 
    private Integer outCode;
    
    
    /**
     * outData
     */
    @Column(name = "OUT_DATA", nullable = true) 
    private String outData;

    /**
     * returnType
     */
    @Column(name = "RETURN_TYPE", nullable = true) 
    private String returnType;

    /**
     * runTimeCount
     */
    @Column(name = "RUN_TIME_COUNT", nullable = true) 
    private Long runTimeCount;
    
    
    /**
     * runTimeCount
     */
    @Column(name = "PROGRAM_VERSION", nullable = true) 
    private String programVersion;
    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public String getClassSimpleName() {
		return classSimpleName;
	}

	public void setClassSimpleName(String classSimpleName) {
		this.classSimpleName = classSimpleName;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getInStr() {
		return inStr;
	}

	public void setInStr(String inStr) {
		this.inStr = inStr;
	}

	public String getOutMsg() {
		return outMsg;
	}

	public void setOutMsg(String outMsg) {
		this.outMsg = outMsg;
	}

	public Integer getOutCode() {
		return outCode;
	}

	public void setOutCode(Integer outCode) {
		this.outCode = outCode;
	}

	public String getOutData() {
		return outData;
	}

	public void setOutData(String outData) {
		this.outData = outData;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public Long getRunTimeCount() {
		return runTimeCount;
	}

	public void setRunTimeCount(Long runTimeCount) {
		this.runTimeCount = runTimeCount;
	}

	public String getRequestAddr() {
		return requestAddr;
	}

	public void setRequestAddr(String requestAddr) {
		this.requestAddr = requestAddr;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getProgramVersion() {
		return programVersion;
	}

	public void setProgramVersion(String programVersion) {
		this.programVersion = programVersion;
	}
  
}
