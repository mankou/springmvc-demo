package mang.demo.springmvc.common.aspect;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import mang.demo.springmvc.common.entity.RequestLog;
import mang.demo.springmvc.common.exception.ServiceException;
import mang.demo.springmvc.common.service.RequestService;
import mang.demo.springmvc.common.util.Constant;
import mang.demo.springmvc.common.util.MyVersion;
import mang.util.common.JsonUtil;
import mang.util.common.StringUtil;
import mang.util.common.TimestampUtil;

@Aspect
@Component
public class ControllerAspect {
	private static Logger logger = Logger.getLogger("log");

	@Autowired
	private RequestService requestService;

    public static final String CONTROLLER_PONINT_CUT="execution(* mang.demo.springmvc.server.controller..*.*(..))";

	@Before(CONTROLLER_PONINT_CUT)
	public void before(JoinPoint jp) {
		Object[] arg = jp.getArgs();
		String str = JsonUtil.obj2String(arg); // 入参
		Class clazz = jp.getTarget().getClass();
		String className = clazz.getName(); // 类名全写(包含包名)
		String classSimpleName = clazz.getSimpleName(); // 类名简写
		String method = jp.getSignature().getName(); // 方法名

	}

	@After(CONTROLLER_PONINT_CUT)
	public void after(JoinPoint joinPoint) {
		// 注 after是获取不到返回值的 其相当于try catch finally里的finally

	}

	@AfterReturning(value = CONTROLLER_PONINT_CUT, returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		// Object[] arg=joinPoint.getArgs();
		// String inStr=JsonUtil.obj2String(arg); //入参
		// String outStr=JsonUtil.obj2String(result); //出参
	}

	// 配置抛出异常后通知,使用在方法aspect()上注册的切入点
	@AfterThrowing(value = CONTROLLER_PONINT_CUT, throwing = "ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex) {
		// if(ex instanceof ServiceException){
		// Object data=((ServiceException) ex).getData();
		// String dataStr=JsonUtil.obj2String(data);
		// System.out.println("出参(业务异常):"+dataStr);
		// }
		// System.out.println("afterThrow");
	}

	@Around(CONTROLLER_PONINT_CUT)
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

		Timestamp startDate = TimestampUtil.getCurrentTime();

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String clientIp = request.getRemoteAddr();
		int clientPort = request.getRemotePort();
		String clientUrl = request.getRequestURI();
		String requestMethod=request.getMethod();

		logger.info("请求ip:" + clientIp + ":" + clientPort);
		logger.info("请求url:" + clientUrl);

		Class clazz = pjp.getTarget().getClass();
		String className = clazz.getName(); // 类名全写(包含包名)
		String classSimpleName = clazz.getSimpleName(); // 类名简写
		String method = pjp.getSignature().getName(); // 方法名
		Object[] arg = pjp.getArgs(); // 入参

		String inStr = null;
		Integer outCode = Constant.returnCode.ok;
		String outData = null;
		String returnType = null;
		String outMsg = null;

		// 如果是一个参数 一般是post请求过来的类 则直接取第1个 如果不是则所有的参数都转换成json字符串
		if (arg.length == 0) {
			inStr = null;
		} else if (arg.length == 1) {
			inStr = JsonUtil.obj2String(arg[0]);
		} else {
			inStr = JsonUtil.obj2String(arg);
		}

		try {
			logger.info("[" + classSimpleName + "." + method + "] " + "入参: " + inStr);
			Object result = pjp.proceed();
			outMsg = "ok";
			outData = JsonUtil.obj2String(result); // 出参
			logger.info("[" + classSimpleName + "." + method + "] " + "出参-正常返回: " + outMsg);
			returnType = Constant.returnType.returnOk;
			return result;
		} catch (Exception e) {
			if (e instanceof ServiceException) {
				ServiceException serviceException = (ServiceException) e;
				Object data = serviceException.getData();
				String dataStr = JsonUtil.obj2String(data);
				logger.info("[" + classSimpleName + "." + method + "] " + "出参-业务异常: " + "错误码:"
						+ serviceException.getCode() + " 异常信息: " + serviceException.getMessage());
				logger.info("[" + classSimpleName + "." + method + "] " + "出参-业务异常: " + "返回数据: " + dataStr);

				returnType = Constant.returnType.serviceException;
				outMsg = serviceException.getMessage();
				outCode = serviceException.getCode();
				outData = dataStr;
			} else {
				logger.info("[" + classSimpleName + "." + method + "] " + "出参-运行异常: " + "异常信息: " + e.getMessage());

				returnType = Constant.returnType.runtimeError;
				outMsg = e.getMessage();
				outCode = Constant.returnCode.runtimeError;
			}

			throw e;
		} finally {
			// finally是在try的return之前执行的 所以可以这样写

			Timestamp endDate = TimestampUtil.getCurrentTime();
			Long runTime = endDate.getTime() - startDate.getTime();
			logger.info("[" + classSimpleName + "." + method + "] " + "执行时长: " + runTime);
			logger.info("version:"+MyVersion.getCurrentVersionDesc());
			
			//字符串截取
			inStr=StringUtil.subString(inStr, Constant.defaultMaxLength);
			outMsg=StringUtil.subString(outMsg, Constant.defaultMaxLength);
			outData=StringUtil.subString(outData, Constant.defaultMaxLength);

			RequestLog requestLog = new RequestLog();
			requestLog.setClassSimpleName(classSimpleName);
			requestLog.setMethod(method);
			requestLog.setInStr(inStr);
			requestLog.setOutMsg(outMsg);
			requestLog.setOutCode(outCode);
			requestLog.setOutData(outData);
			requestLog.setRequestDate(startDate);
			requestLog.setRequestIp(clientIp);
			requestLog.setRequestAddr(clientUrl);
			requestLog.setReturnType(returnType);
			requestLog.setRunTimeCount(runTime);
			requestLog.setRequestMethod(requestMethod);
			requestLog.setProgramVersion(MyVersion.getCurrentVersionDesc());
			requestService.saveOrUpdate(requestLog);
		}

	}

}
