package com.zq.dao.process;

import java.util.*;
import javax.persistence.*;

import com.zq.vo.process.*;

public interface BenefitEvalHelper{

    List<TaskHisItemVO> getTaskHis(String processID);
    List<TaskTodoItemVO> getTaskTodo(String userID);
    List<TaskTodoItemVO> getTaskDone(String userID);

}
