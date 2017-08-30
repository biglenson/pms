package com.zq.dao.process;

import java.util.*;
import javax.persistence.*;

import com.zq.vo.process.*;

public interface BenefitEvalHelper{

    List<TaskHisItemVO> getTaskHis(String processID);
    PageModel<TaskTodoItemVO> getTaskTodo(String userID, int currentPage);
    PageModel<TaskTodoItemVO> getTaskDone(String userID, int currentPage);

}
