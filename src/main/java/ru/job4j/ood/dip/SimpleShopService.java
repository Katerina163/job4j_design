package ru.job4j.ood.dip;

import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.Set;

public class SimpleShopService {
    private static final Logger LOGGER = Logger.getLogger("Shop logger");
    private ShopStore shopStore;
    private OrderService orderService;

    public SimpleShopService(ShopStore shopStore, OrderService orderService) {
        this.shopStore = shopStore;
        this.orderService = orderService;
    }

    public boolean createBucket(User user) {
        return shopStore.saveUser(user);
    }

    public boolean createOrder(User user, Order order) {
        return shopStore.saveOrder(user, order);
    }

    public boolean addProduct(User user, Order order, Product product) {
        Optional<Order> orderDB = findOrder(user, order);
        if (orderDB.isEmpty()) {
            return false;
        }
        return orderDB.get().add(product);
    }

    private Optional<Order> findOrder(User user, Order order) {
        return shopStore.getOrders(user).stream()
                .filter(o -> o.getId() == order.getId()).findFirst();
    }

    public boolean removeProduct(User user, Order order, Product product) {
        Optional<Order> orderDB = findOrder(user, order);
        if (orderDB.isEmpty()) {
            return false;
        }
        return orderDB.get().remove(product.getId());
    }

    public boolean removeOrder(User user, Order order) {
        Set<Order> orders = shopStore.getOrders(user);
        if (orders == null) {
            return false;
        }
        return orders.remove(order);
    }

    public Check payOrder(User user, Order order) {
        Optional<Order> orderDB = findOrder(user, order);
        if (orderDB.isEmpty()) {
            LOGGER.error("Get error with " + user + " " + order,
                    new IllegalArgumentException("Invalid order"));
        }
        if (orderDB.get().isPayed()) {
            LOGGER.debug("Get error with "  + user + " " + order,
                    new IllegalArgumentException("Already payed!"));

        }
        orderDB.get().setPayed(true);
        return new Check((int) (System.currentTimeMillis() % 1000_000), "Payed: " + orderDB.get().getId());
    }
}
