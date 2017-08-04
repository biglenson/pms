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
public interface BenefitEvalTplItemRepository extends JpaRepository<BenefitEvalTplItem, Long>{

    /** 
     * @param priviID
     * @return
     */

    //BenefitEvalTplItem getBenefitEvalTplByTplID(int tplID);
    List<BenefitEvalTplItem> getBenefitEvalTplItemByTplIDOrderByListOrder(int tplID);

}

