package com.ldh.scalingdemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimeRepo extends CrudRepository<Prime, Long>
{
}
