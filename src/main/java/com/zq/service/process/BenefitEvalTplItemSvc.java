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
public class BenefitEvalTplItemSvc{
    private static Log logger = LogFactory.getLog(BenefitEvalTplItemSvc.class);
    @Autowired
    BenefitEvalTplItemRepository benefitEvalTplItemRepo;

    public List<BenefitEvalTplItemVO> getFormTemplate(int tplID) {
        List<BenefitEvalTplItemVO> benefitEvalTplItemVOList = new ArrayList<BenefitEvalTplItemVO>();
        List<BenefitEvalTplItem> benefitEvalTplItemList = benefitEvalTplItemRepo.getBenefitEvalTplItemByTplIDOrderByListOrder(tplID);

        BenefitEvalTplItemVO benefitEvalTplItemVO = null;
        
        for (BenefitEvalTplItem benefitEvalTplItem : benefitEvalTplItemList) {
            benefitEvalTplItemVO = new BenefitEvalTplItemVO();
            BeanUtils.copyProperties(benefitEvalTplItem, benefitEvalTplItemVO);
            logger.info("评估模板！----------------------------"+ benefitEvalTplItemVO.getEvalItem()); 
            benefitEvalTplItemVOList.add(benefitEvalTplItemVO);
        }
        return benefitEvalTplItemVOList;
    }
}
