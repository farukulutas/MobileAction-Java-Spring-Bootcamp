package com.farukulutas.demo.dao;

import com.farukulutas.demo.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Long> {
}