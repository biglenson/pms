package com.zq.service.Impl.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.commons.utils.TypeUtils;
import com.zq.dao.system.ISysStandardtimeRepository;
import com.zq.entity.basic.purchase.BasSecondBill;
import com.zq.entity.system.SysStandardtime;
import com.zq.service.system.ISysDicService;
import com.zq.service.system.ISysStandardtimeService;

/**
 *
 * SysStandardtime 表数据服务层接口实现类
 *
 */
@Service
public class SysStandardtimeServiceImpl implements ISysStandardtimeService {


	private static Logger logger = Logger.getLogger(SysStandardtimeServiceImpl.class);
    @Autowired
    private ISysStandardtimeRepository iSysStandardtimeRepository;
    
    @Autowired
    private ISysDicService iSysDicService;
    
	@Override
	public HttpServletRequest getFinishInTimeFromSysStandardtime(HttpServletRequest request) {
		Date dataUpdateDate = null;
		String year=request.getParameter("year");
		int index=TypeUtils.getIntFromString(request.getParameter("index"));
		Map<String,Integer> startTimesMap = new HashMap();
		Map<String,Integer> finishTimesNormalMap = new HashMap();
		Map<String,Integer> finishTimesImportantMap = new HashMap();
		List<SysStandardtime> allFinishTimes = this.getAllSysStandardtime();
		if(allFinishTimes != null){
			for(SysStandardtime finishTime : allFinishTimes){
				String name = iSysDicService.getNameByClasscodeAndCode("purchasing_method",finishTime.getPurchasingMethod());
				Integer value = Integer.parseInt(finishTime.getStandardCompletionTimit());
				if(name.contains("招标")){
					startTimesMap.put("招标", value==null?0:value);
				}else if(name.contains("比选")){
					startTimesMap.put("比选", value==null?0:value);
				}else if(name.contains("询价")){
					startTimesMap.put("询价", value==null?0:value);
				}else if(name.contains("竞争性谈判")){
					startTimesMap.put("竞争性谈判", value==null?0:value);
				}
			}
		}
		if(allFinishTimes != null){
			for(SysStandardtime finishTime : allFinishTimes){
				String name = iSysDicService.getNameByClasscodeAndCode("purchasing_method",finishTime.getPurchasingMethod());
				String level = iSysDicService.getNameByClasscodeAndCode("confirm_level",finishTime.getComfirmLevel());
				Integer value = Integer.parseInt(finishTime.getStandardStartupTimit());
				if(level.contains("总经理")){
					if(name.contains("招标")){
						finishTimesImportantMap.put("招标", value==null?0:value);
					}else if(name.contains("比选")){
						finishTimesImportantMap.put("比选", value==null?0:value);
					}else if(name.contains("询价")){
						finishTimesImportantMap.put("询价", value==null?0:value);
					}else if(name.contains("竞争性谈判")){
						finishTimesImportantMap.put("竞争性谈判", value==null?0:value);
					}
				}else{
					if(name.contains("招标")){
						finishTimesNormalMap.put("招标", value==null?0:value);
					}else if(name.contains("比选")){
						finishTimesNormalMap.put("比选", value==null?0:value);
					}else if(name.contains("询价")){
						finishTimesNormalMap.put("询价", value==null?0:value);
					}else if(name.contains("竞争性谈判")){
						finishTimesNormalMap.put("竞争性谈判", value==null?0:value);
					}
				}
			}
		}
		request.setAttribute("startTimesMap", startTimesMap);
		request.setAttribute("finishTimesNormalMap", finishTimesNormalMap);
		request.setAttribute("finishTimesImportantMap", finishTimesImportantMap);
		return request;
	}
	private List<SysStandardtime> getAllSysStandardtime() {
		
		return iSysStandardtimeRepository.findAll();
	}

	
}