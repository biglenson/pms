package com.zq.dao;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zq.entity.Resource;

public interface IResourceRepository extends JpaRepository<Resource, Long> {

	boolean deleteById(Serializable resourceId);

	List<Resource> findByResourceType(Integer type);

	List<Resource> findByResourceTypeAndAppid(int type, int appid);
	@Query("SELECT res FROM Resource res WHERE res.url = ?1 and res.pid > 0")
	Resource findByUrlNotRoot(String url);


}
