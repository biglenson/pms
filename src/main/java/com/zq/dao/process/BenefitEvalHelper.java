package com.zq.dao.process;

import java.util.*;
import javax.persistence.*;

import com.zq.vo.process.*;

public interface BenefitEvalHelper{

    List<TaskTodoItemVO> getTaskTodo(String userID);
    List<TaskDoneItemVO> getTaskDone(String userID)

}
