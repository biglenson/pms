package com.zq.dao.process;

import java.util.*;
import java.sql.Timestamp;
import javax.persistence.*;

import com.zq.vo.process.*;
import org.springframework.data.domain.PageRequest;

public class BenefitEvalItemRepositoryImpl implements BenefitEvalItemHelper {
    @PersistenceContext
    private EntityManager em;

    public List<BenefitEvalItemVO> getBenefitEvalForm(int evalID) {
        List<BenefitEvalItemVO> benefitEvalForm = new ArrayList<BenefitEvalItemVO>();
        BenefitEvalItemVO benefitEvalItemVO = null;
        
        String queryString = 
                    "   select b.itemID, a.tplItemID, a.evalItem, a.evalDimension, a.evalDesc, a.refValue,    " +
                    "          b.evalValue, b.evalNote, a.listOrder   " +
                    "     from g_benefit_eval_tpl_item a, d_benefit_eval_item b   " +
                    "    where b.tplItemID = a.tplItemID and b.evalID= :evalID    " ;

        Query q = em.createNativeQuery(queryString).setParameter("evalID", evalID);

        List rslt = q.getResultList();
        Iterator rsltIter = rslt.iterator();
        while ( rsltIter.hasNext() ) {
            benefitEvalItemVO = new BenefitEvalItemVO();
            Object[] obj = (Object[])rsltIter.next();
            benefitEvalItemVO.setItemID((Integer)obj[0]);
            benefitEvalItemVO.setTplItemID((Integer)obj[1]);
            benefitEvalItemVO.setEvalItem((String)obj[2]);
            benefitEvalItemVO.setEvalDimension((String)obj[3]);
            benefitEvalItemVO.setEvalDesc((String)obj[4]);
            benefitEvalItemVO.setRefValue((String)obj[5]);
            benefitEvalItemVO.setEvalValue((String)obj[6]);
            benefitEvalItemVO.setEvalNote((String)obj[7]);
            benefitEvalItemVO.setListOrder((Integer)obj[8]);
            benefitEvalForm.add(benefitEvalItemVO);
        }
        return benefitEvalForm;
    }

}
