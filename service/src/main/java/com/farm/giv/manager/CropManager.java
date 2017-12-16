package com.farm.giv.manager;

import com.farm.giv.adapter.CropAdapter;
import com.farm.giv.request.CropCreateRequest;
import com.farm.giv.response.CropResponse;
import com.google.inject.Inject;
import dao.CropDao;
import db.Crop;

public class CropManager {
    private final CropDao cropDao;

    @Inject
    public CropManager(CropDao cropDao) {
        this.cropDao = cropDao;
    }

    public CropResponse getCrop(String id) {
        Crop crop = cropDao.getCrop(id);
        return CropAdapter.from(crop);
    }

    public CropResponse getCropByCode(String code) {
        Crop crop = cropDao.getCropByCode(code);
        return CropAdapter.from(crop);
    }

    public CropResponse setCrop(CropCreateRequest request) {
        Crop crop = cropDao.insertBean(CropAdapter.from(request));
        return CropAdapter.from(crop);
    }
}
