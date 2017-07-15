package com.zq.dao.system;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zq.entity.system.SysForm;

public interface ISysFormRepository extends JpaRepository<SysForm, Long> {

	List<SysForm> findByForm(String form);
}
