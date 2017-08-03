package com.zq.service.process;

import com.zq.vo.process.*;
import com.zq.entity.process.*;
import com.zq.dao.process.*;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.*;


@Component
public class BenefitEvalTplSvc{
    private static Log logger = LogFactory.getLog(BenefitEvalTplSvc.class);
    @Autowired
    BenefitEvalTplRepository benefitEvalTplRepo;

    public List<BenefitEvalTplVO> getBenefitEvalTplList(int evalPhase, int evalFor) {
        List<BenefitEvalTplVO> benefitEvalTplVOList = new ArrayList<BenefitEvalTplVO>();
        List<BenefitEvalTpl> benefitEvalTplList = benefitEvalTplRepo.getBenefitEvalTplByEvalPhaseAndEvalFor(evalPhase, evalFor);


        BenefitEvalTpl benefitEvalTpl = null;
        BenefitEvalTplVO benefitEvalTplVO = null;
        
        Iterator<BenefitEvalTpl> benefitEvalTplIter = benefitEvalTplList.iterator();
        while (benefitEvalTplIter.hasNext()) {
            benefitEvalTpl = benefitEvalTplIter.next();
            benefitEvalTplVO = new BenefitEvalTplVO();
            BeanUtils.copyProperties(benefitEvalTpl, benefitEvalTplVO);
            logger.info("评估模板列表！----------------------------"+ benefitEvalTplVO.getTplTitle()); 
            benefitEvalTplVOList.add(benefitEvalTplVO);
        }
        return benefitEvalTplVOList;
    }
}
