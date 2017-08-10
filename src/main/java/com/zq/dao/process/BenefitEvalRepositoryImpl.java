package com.zq.dao.process;

import java.util.*;
import java.sql.Timestamp;
import javax.persistence.*;

import com.zq.vo.process.*;
import org.springframework.data.domain.PageRequest;

public class BenefitEvalRepositoryImpl implements BenefitEvalHelper {
    @PersistenceContext
    private EntityManager em;

    public List<TaskTodoItemVO> getTaskTodo(String userID) {
        List<TaskTodoItemVO> taskTodo = new ArrayList<TaskTodoItemVO>();
        TaskTodoItemVO taskTodoItemVO = null;
        
        String queryString = 
            " select a.processID, a.evalTitle, b.NAME_ taskName, c.evalPhase, c.tplTitle, b.ASSIGNEE_ assignee, b.CREATE_TIME_ createTime "+
            "  from d_benefit_eval a, ACT_RU_TASK b, g_benefit_eval_tpl c "+
            " where b.ASSIGNEE_ = :userID "+
            "       and a.processID = b.PROC_INST_ID_ "+
            "       and a.tplID=c.tplID ";

        Query q = em.createNativeQuery(queryString).setParameter("userID", userID);

        List rslt = q.getResultList();
        Iterator rsltIter = rslt.iterator();
        while ( rsltIter.hasNext() ) {
            taskTodoItemVO = new TaskTodoItemVO();
            Object[] obj = (Object[])rsltIter.next();
            taskTodoItemVO.setProcessID((String)obj[0]);
            taskTodoItemVO.setEvalTitle((String)obj[1]);
            taskTodoItemVO.setTaskName((String)obj[2]);
            taskTodoItemVO.setEvalPhase((Integer)obj[3]);
            taskTodoItemVO.setTplTitle((String)obj[4]);
            taskTodoItemVO.setAssignee((String)obj[5]);
            taskTodoItemVO.setCreateTime((Timestamp)obj[6]);
            taskTodo.add(taskTodoItemVO);
        }
        return taskTodo;
    }

    public List<TaskTodoItemVO> getTaskDone(String userID) {
        List<TaskTodoItemVO> taskDone = new ArrayList<TaskTodoItemVO>();
        TaskTodoItemVO taskDoneItemVO = null;
        
        String queryString = 
            " select a.processID, a.evalTitle, b.NAME_ taskName, c.evalPhase, c.tplTitle, b.ASSIGNEE_ assignee, b.CREATE_TIME_ createTime "+
            "  from d_benefit_eval a, ACT_RU_TASK b, g_benefit_eval_tpl c "+
            " where a.processID in (select distinct PROC_INST_ID_ from ACT_HI_TASKINST where ASSIGNEE_ = :userID) "+
            "       and a.processID = b.PROC_INST_ID_ "+
            "       and a.tplID=c.tplID ";

        Query q = em.createNativeQuery(queryString).setParameter("userID", userID);

        List rslt = q.getResultList();
        Iterator rsltIter = rslt.iterator();
        while ( rsltIter.hasNext() ) {
            taskDoneItemVO = new TaskTodoItemVO();
            Object[] obj = (Object[])rsltIter.next();
            taskDoneItemVO.setProcessID((String)obj[0]);
            taskDoneItemVO.setEvalTitle((String)obj[1]);
            taskDoneItemVO.setTaskName((String)obj[2]);
            taskDoneItemVO.setEvalPhase((Integer)obj[3]);
            taskDoneItemVO.setTplTitle((String)obj[4]);
            taskDoneItemVO.setAssignee((String)obj[5]);
            taskDoneItemVO.setCreateTime((Timestamp)obj[6]);
            taskDone.add(taskDoneItemVO);
        }
        return taskDone;
    }
}
