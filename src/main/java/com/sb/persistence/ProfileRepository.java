package com.sb.persistence;

import org.springframework.data.repository.CrudRepository;

import com.sb.domain.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long>{

}
