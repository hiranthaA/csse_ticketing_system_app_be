package com.csse.travelpay.service;

import com.csse.travelpay.model.Bus;

public interface BusService {
	Bus getCurrentLocation(String busId);

	Bus addBus(Bus bus);
}
