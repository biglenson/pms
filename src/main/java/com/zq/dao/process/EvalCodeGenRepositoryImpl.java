package com.zq.dao.process;

import javax.persistence.*;

public class EvalCodeGenRepositoryImpl  {

	@PersistenceContext
	private EntityManager em;
	
	public int incrementEvalCode(String deptShortName, String codeType) {
        String queryString = null;

        queryString = 
			"update d_eval_code_gen a  " +
			"   set a.currValue = ( case when a.yearMonth = extract(year_month from sysdate()) " +
			"			then (a.currValue + 1) " +
			"			else 0 end), " +
			" 	a.yearMonth = extract(year_month from sysdate()) " + 
			" where a.deptShortName = :deptShortName " +
			"   and a.codeType = :codeType ";
        Query q = em.createNativeQuery(queryString)
                                    .setParameter("deptShortName", deptShortName)
                                    .setParameter("codeType", codeType);
        System.out.println("---------------------deptShortName: " + deptShortName);
        return  q.executeUpdate();
	}
	
}

