package com.zq.dao.process;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zq.entity.process.*;

/**
 * @author shujukuss
 *
 */
public interface BenefitEvalItemRepository extends JpaRepository<BenefitEvalItem, Long>, BenefitEvalItemHelper{

    /** 
     * @param priviID
     * @return
     */

    //BenefitEvalItem getBenefitEvalByID(int tplID);
    //List<BenefitEvalItemVO> getBenefitEvalFormInfo(int evalID);

}

