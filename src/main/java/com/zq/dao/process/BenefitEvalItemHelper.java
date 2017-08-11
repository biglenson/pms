package com.zq.dao.process;

import java.util.*;
import javax.persistence.*;

import com.zq.vo.process.*;

public interface BenefitEvalItemHelper{

    List<BenefitEvalItemVO> getBenefitEvalForm(int evalID);

}
