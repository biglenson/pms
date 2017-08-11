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
public class BenefitEvalSvc{
    private static Log logger = LogFactory.getLog(BenefitEvalSvc.class);
    @Autowired
    BenefitEvalRepository benefitEvalRepo;

    @Autowired
    BenefitEvalTplRepository benefitEvalTplRepo;

    public BenefitEvalVO getBenefitEvalInfo(int evalID) {
        BenefitEvalVO benefitEvalVO = new BenefitEvalVO();
        BenefitEval benefitEval = benefitEvalRepo.getBenefitEvalByEvalID(evalID);
        BenefitEvalTpl benefitEvalTpl = benefitEvalTplRepo.getBenefitEvalTplByTplID(benefitEval.getTplID());
        benefitEvalVO.setTplTitle(benefitEvalTpl.getTplTitle());
        benefitEvalVO.setEvalPhase(benefitEvalTpl.getEvalPhase());
        benefitEvalVO.setEvalFor(benefitEvalTpl.getEvalFor());

        return benefitEvalVO;
    }
    public List<TaskTodoItemVO> getTaskTodo() {
            return benefitEvalRepo.getTaskTodo("lenson");
    }
    public List<TaskTodoItemVO> getTaskDone() {
            return benefitEvalRepo.getTaskDone("lenson");

    }
}
