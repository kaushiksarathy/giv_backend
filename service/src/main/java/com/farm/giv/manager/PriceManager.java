package com.farm.giv.manager;

import com.farm.giv.adapter.PriceAdapter;
import com.farm.giv.request.PriceCreateRequest;
import com.farm.giv.response.CropResponse;
import com.farm.giv.response.PriceResponse;
import com.google.inject.Inject;
import dao.PriceDao;
import db.Price;

public class PriceManager {
    private final PriceDao priceDao;
    private final CropManager cropManager;

    @Inject
    public PriceManager(PriceDao priceDao, CropManager cropManager) {
        this.priceDao = priceDao;
        this.cropManager = cropManager;
    }

    public PriceResponse getPrice(String id) {
        Price price = priceDao.getPrice(id);
        CropResponse cropResponse = cropManager.getCropByCode(price.getCrop_code());
        return PriceAdapter.from(price, cropResponse);
    }

    public PriceResponse setPrice(PriceCreateRequest request) {
        Price price = priceDao.insertBean(PriceAdapter.from(request));
        CropResponse cropResponse = cropManager.getCropByCode(price.getCrop_code());
        return PriceAdapter.from(price, cropResponse);
    }
}
