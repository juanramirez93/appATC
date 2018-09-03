package com.atc.service.natural;

import com.atc.connection.NaturalEM;
import com.atc.model.Natural;

import java.util.List;

public class MainNaturalService {

	NaturalEM naturalEM;

	public MainNaturalService() {
		this.naturalEM = new NaturalEM();
	}

	public List<Natural> getAllNaturales() {
		return this.naturalEM.getAll();
	}

}
