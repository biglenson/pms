package com.zq.dao;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zq.entity.Resource;

public interface IResourceRepository extends JpaRepository<Resource, Long> {

	boolean deleteById(Serializable resourceId);

	List<Resource> findByResourceType(Integer type);

	List<Resource> findByResourceTypeAndAppid(int type, int appid);


}
