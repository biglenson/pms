package com.zq.service.Impl.basic.capex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXRequirmentRepository;
import com.zq.entity.basic.capex.BasCAPEXRequirment;
import com.zq.service.basic.capex.IBasCAPEXRequirmentService;
import com.zq.service.system.ISysDicService;
import com.zq.vo.basic.capex.BasCAPEXRequirmentVO;

/**
 *
 * BasCAPEXRequirment 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXRequirmentImpl implements IBasCAPEXRequirmentService {

    @Autowired
    private IBasCAPEXRequirmentRepository iBasCAPEXRequirmentRepository;    
    
    @Autowired
    private ISysDicService iSysDicService;

	@Override
	public Page<BasCAPEXRequirment> getBasCAPEXRequirment(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCAPEXRequirmentRepository.findAll(request);
	}

	@Override
	public List<BasCAPEXRequirmentVO> getBasCAPEXRequirmentVOList(List<BasCAPEXRequirment> content) {
		List<BasCAPEXRequirmentVO> voList = new ArrayList<>();		
		for(BasCAPEXRequirment po:content){
			BasCAPEXRequirmentVO vo = new BasCAPEXRequirmentVO();
			BeanUtils.copyProperties(po, vo);		
			String reqSubmitStatus = iSysDicService.getNameByClasscodeAndCode("yesno_code",po.getReqSubmitStatus());
			String reqAuditStatus = iSysDicService.getNameByClasscodeAndCode("audit_status",po.getReqAuditStatus());
			if(reqSubmitStatus==null||reqSubmitStatus.equals("")){
				vo.setReqSubmitStatus("未录入数据");
			}else{
				vo.setReqSubmitStatus(reqSubmitStatus);
			}
			if(reqAuditStatus==null||reqAuditStatus.equals("")){
				vo.setReqAuditStatus("未录入数据");
			}else{
				vo.setReqAuditStatus(reqAuditStatus);
			}
			voList.add(vo);
		}
		return voList;
	}
    
   

}