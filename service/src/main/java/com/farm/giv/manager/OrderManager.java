package com.farm.giv.manager;

import com.farm.giv.adapter.OrderAdapter;
import com.farm.giv.request.OrderCreateRequest;
import com.farm.giv.response.CropResponse;
import com.farm.giv.response.OrderResponse;
import com.farm.giv.response.PriceResponse;
import com.google.inject.Inject;
import dao.OrderDao;
import db.Order;

public class OrderManager {
    private final OrderDao orderDao;
    private final CropManager cropManager;
    private final PriceManager priceManager;

    @Inject
    public OrderManager(OrderDao orderDao, CropManager cropManager, PriceManager priceManager) {
        this.orderDao = orderDao;
        this.cropManager = cropManager;
        this.priceManager = priceManager;
    }

    public OrderResponse getOrder(String id) {
        Order order = orderDao.getOrder(id);
        CropResponse cropResponse = cropManager.getCrop(order.getCropId());
        PriceResponse priceResponse = priceManager.getPrice(order.getPriceId());
        return OrderAdapter.from(order, cropResponse, priceResponse);
    }

    public OrderResponse setOrder(OrderCreateRequest request) {
        Order order = orderDao.insertBean(OrderAdapter.from(request));
        CropResponse cropResponse = cropManager.getCrop(order.getCropId());
        PriceResponse priceResponse = priceManager.getPrice(order.getPriceId());
        return OrderAdapter.from(order, cropResponse, priceResponse);
    }
}
