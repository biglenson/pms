package com.zq.dao.process;

import java.util.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import javax.persistence.*;

import com.zq.vo.process.*;
import org.springframework.data.domain.PageRequest;

public class BenefitEvalRepositoryImpl implements BenefitEvalHelper {
    @PersistenceContext
    private EntityManager em;

    public List<UserInfoVO> getUserInfoList() {
        List<UserInfoVO> userInfoListVO = new ArrayList<UserInfoVO>();
        UserInfoVO userInfoVO = null;
        
        String queryString = 
            "select a.id deptID, a.name deptName, b.id userID, b.name userName from sys_user b, sys_department a where b.department_code = a.id order by a.name, b.name";
        Query q = em.createNativeQuery(queryString);

        List rslt = q.getResultList();
        Iterator rsltIter = rslt.iterator();
        while ( rsltIter.hasNext() ) {
            userInfoVO = new UserInfoVO();
            Object[] obj = (Object[])rsltIter.next();
            userInfoVO.setDeptID(((BigInteger)obj[0]).longValue());
            userInfoVO.setDeptName((String)obj[1]);
            userInfoVO.setUserID(((BigInteger)obj[2]).longValue());
            userInfoVO.setUserName((String)obj[3]);
            userInfoListVO.add(userInfoVO);
        }
        return userInfoListVO;
    }

    public List<TaskHisItemVO> getTaskHis(String processID) {
        List<TaskHisItemVO> taskHis = new ArrayList<TaskHisItemVO>();
        TaskHisItemVO taskHisItemVO = null;
        
        /*
        String queryString = 
            "    select a.NAME_ taskName, ASSIGNEE_ assignee, END_TIME_ endTime, c.TEXT_ dealResult, MESSAGE_ comment    " +
            "      from ACT_HI_TASKINST a     " +
            "           left join ACT_HI_COMMENT b on a.ID_ = b.TASK_ID_    " +
            "           left join ACT_HI_VARINST c on a.ID_ = c.TASK_ID_ and c.NAME_ = 'dealRslt'     " +
            "     where a.PROC_INST_ID_ = :processID     " +
            "     order by  END_TIME_ desc    "; 
            */
        String queryString = 
            "    select a.ACT_NAME_ taskName, ASSIGNEE_ assignee, ifnull(END_TIME_,sysdate()) endTime, c.TEXT_ dealResult, b.TEXT_ comment    " +
            "      from ACT_HI_ACTINST a     " +
            "           left join ACT_HI_VARINST b on a.TASK_ID_ = b.TASK_ID_ and b.NAME_ = 'dealOpinion'   " +
            "           left join ACT_HI_VARINST c on a.TASK_ID_ = c.TASK_ID_ and c.NAME_ = 'rsltDesc'     " +
            "     where a.PROC_INST_ID_ = :processID     " +
            "           and ACT_TYPE_ in ('startEvent', 'userTask', 'endEvent')    " +
            "     order by  START_TIME_ desc, endTime desc, dealResult desc    "; 
        Query q = em.createNativeQuery(queryString).setParameter("processID", processID);

        List rslt = q.getResultList();
        Iterator rsltIter = rslt.iterator();
        while ( rsltIter.hasNext() ) {
            taskHisItemVO = new TaskHisItemVO();
            Object[] obj = (Object[])rsltIter.next();
            taskHisItemVO.setTaskName((String)obj[0]);
            taskHisItemVO.setAssignee((String)obj[1]);
            taskHisItemVO.setDealTime((Timestamp)obj[2]);
            taskHisItemVO.setDealResult((String)obj[3]);
            taskHisItemVO.setDealOpinion((String)obj[4]);
            taskHis.add(taskHisItemVO);
        }
        return taskHis;
    }

    public PageModel<TaskTodoItemVO> getTaskTodo(String userID, int pageNo) {
        List<TaskTodoItemVO> taskTodo = new ArrayList<TaskTodoItemVO>();
        TaskTodoItemVO taskTodoItemVO = null;
        int pageSize = 10;
        int totalItems = 0;
        int totalPages = 0;
        PageModel taskTodoPage = new PageModel<TaskTodoItemVO>();

        String queryString = 
            " select count(*) from ACT_RU_TASK where ASSIGNEE_ = :userID ";
        Query q = em.createNativeQuery(queryString).setParameter("userID", userID);
        //totalItems = q.getResultList().size();
        totalItems = Integer.parseInt(q.getSingleResult().toString());
        totalPages = (int)(totalItems / pageSize) +1;
        System.out.println("totalItems: "+totalItems+ "----totalPages: "+totalPages);
        System.out.println("pageSize: "+pageSize+ "----pageNo: "+pageNo); 
        
        queryString = 
            " select a.processID, a.evalTitle, b.ID_ taskID , b.NAME_ taskName, c.evalPhase, c.evalFor, c.tplTitle, b.ASSIGNEE_ assignee, b.CREATE_TIME_ createTime "+
            "  from d_benefit_eval a, ACT_RU_TASK b, g_benefit_eval_tpl c "+
            " where b.ASSIGNEE_ = :userID "+
            "       and a.processID = b.PROC_INST_ID_ "+
            "       and a.tplID=c.tplID " +
            " order by b.CREATE_TIME_ desc";

        q = em.createNativeQuery(queryString).setParameter("userID", userID);
        q.setMaxResults(pageSize);
        q.setFirstResult(pageNo * pageSize);

        List rslt = q.getResultList();
        Iterator rsltIter = rslt.iterator();
        while ( rsltIter.hasNext() ) {
            taskTodoItemVO = new TaskTodoItemVO();
            Object[] obj = (Object[])rsltIter.next();
            taskTodoItemVO.setProcessID((String)obj[0]);
            taskTodoItemVO.setEvalTitle((String)obj[1]);
            taskTodoItemVO.setTaskID((String)obj[2]);
            taskTodoItemVO.setTaskName((String)obj[3]);
            taskTodoItemVO.setEvalPhase((Integer)obj[4]);
            taskTodoItemVO.setEvalFor((Integer)obj[5]);
            taskTodoItemVO.setTplTitle((String)obj[6]);
            taskTodoItemVO.setAssignee((String)obj[7]);
            taskTodoItemVO.setCreateTime((Timestamp)obj[8]);
            taskTodo.add(taskTodoItemVO);
        }
        taskTodoPage.setResultList(taskTodo);
        taskTodoPage.setTotalItems(totalItems);
        taskTodoPage.setTotalPages(totalPages);

        return taskTodoPage;
    }

    public PageModel<TaskTodoItemVO> getTaskDone(String userID, int pageNo) {
        List<TaskTodoItemVO> taskDone = new ArrayList<TaskTodoItemVO>();
        TaskTodoItemVO taskDoneItemVO = null;
        int pageSize = 10;
        int totalItems = 0;
        int totalPages = 0;
        PageModel taskDonePage = new PageModel<TaskTodoItemVO>();

        String queryString = 
            " select count(*)  from ACT_HI_TASKINST where ASSIGNEE_ = :userID  and END_TIME_ is not null ";
        Query q = em.createNativeQuery(queryString).setParameter("userID", userID);
        totalItems = Integer.parseInt(q.getSingleResult().toString());
        totalPages = (int)(totalItems / pageSize) +1;
        System.out.println("totalItems: "+totalItems+ "----totalPages: "+totalPages);
        System.out.println("pageSize: "+pageSize+ "----pageNo: "+pageNo); 



        queryString =
            " select a.processID, a.evalTitle, b.ID_ taskID, b.NAME_ taskName, c.evalPhase, c.evalFor, " +
            "        c.tplTitle, b.ASSIGNEE_ assignee, ifnull(b.END_TIME_, sysdate())  createTime "+
            "  from d_benefit_eval a, ACT_HI_TASKINST b, g_benefit_eval_tpl c "+
            " where b.ASSIGNEE_ = :userID  "+
            "       and b.END_TIME_ is not null "+
            "       and a.processID = b.PROC_INST_ID_ "+
            "       and a.tplID=c.tplID " +
            " order by createTime desc";

        q = em.createNativeQuery(queryString).setParameter("userID", userID);
        q.setMaxResults(pageSize);
        q.setFirstResult(pageNo * pageSize);


        List rslt = q.getResultList();
        Iterator rsltIter = rslt.iterator();
        while ( rsltIter.hasNext() ) {
            taskDoneItemVO = new TaskTodoItemVO();
            Object[] obj = (Object[])rsltIter.next();
            taskDoneItemVO.setProcessID((String)obj[0]);
            taskDoneItemVO.setEvalTitle((String)obj[1]);
            taskDoneItemVO.setTaskID((String)obj[2]);
            taskDoneItemVO.setTaskName((String)obj[3]);
            taskDoneItemVO.setEvalPhase((Integer)obj[4]);
            taskDoneItemVO.setEvalFor((Integer)obj[5]);
            taskDoneItemVO.setTplTitle((String)obj[6]);
            taskDoneItemVO.setAssignee((String)obj[7]);
            taskDoneItemVO.setCreateTime((Timestamp)obj[8]);
            taskDone.add(taskDoneItemVO);
        }
        taskDonePage.setResultList(taskDone);
        taskDonePage.setTotalItems(totalItems);
        taskDonePage.setTotalPages(totalPages);

        return taskDonePage;
    }
}
