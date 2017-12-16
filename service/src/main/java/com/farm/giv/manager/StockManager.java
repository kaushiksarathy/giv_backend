package com.farm.giv.manager;

import com.farm.giv.adapter.StockAdapter;
import com.farm.giv.request.StockCreateRequest;
import com.farm.giv.response.CropResponse;
import com.farm.giv.response.StockResponse;
import com.google.inject.Inject;
import dao.StockDao;
import db.Stock;

public class StockManager {
    private final StockDao stockDao;
    private final CropManager cropManager;

    @Inject
    public StockManager(StockDao stockDao, CropManager cropManager) {
        this.stockDao = stockDao;
        this.cropManager = cropManager;
    }

    public StockResponse getStock(String id) {
        Stock stock = stockDao.getStock(id);
        CropResponse cropResponse = cropManager.getCrop(stock.getCropId());
        return StockAdapter.from(stock, cropResponse);
    }

    public StockResponse setStock(StockCreateRequest request) {
        Stock stock = stockDao.insertBean(StockAdapter.from(request));
        CropResponse cropResponse = cropManager.getCrop(stock.getCropId());
        return StockAdapter.from(stock, cropResponse);
    }
}
