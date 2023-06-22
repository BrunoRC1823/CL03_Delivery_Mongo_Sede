package com.example.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entidad.Sede;
import com.example.repositorio.SedeRepository;
import com.example.service.SedeService;
@Service
public class SedeServiceImp implements SedeService{
	@Autowired
	private SedeRepository repo;
	@Override
	public Sede ingresarSede(Sede sede) {
		return repo.insert(sede);
	}

}
