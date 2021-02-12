package Services.impl;

import Exceptions.ProductAlreadyRegisteredException;
import Interfaces.MontrealTradedProducts;
import Objects.Product;
import java.util.HashMap;

public class MontrealTradedImpl implements MontrealTradedProducts {
    static HashMap<Product,Integer> products = new HashMap<>();

    static Boolean findProduct(Product product) {
        return products.entrySet().stream().filter(x -> product.getId().equals(x.getKey().getId()))
                .findAny().orElse(null) != null;
    }

    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        Boolean isFound = findProduct(product);
        if (!isFound) {
            products.put(product,0);
        } else {
            throw new ProductAlreadyRegisteredException();
        }
    }

    public void trade(Product product, int quantity) {
        Boolean isFound = findProduct(product);
        if (isFound) {
            products.put(product,(products.get(product) + quantity));
        }
    }

    public int totalTradeQuantityForDay() {
        int totalTradeQuantity = 0;
        for (int quantity: products.values()) {
            totalTradeQuantity += quantity;
        }
        return totalTradeQuantity;
    }


    public double totalValueOfDaysTradedProducts() {
        int totalTradeValue = 0;
        for (Product pdt: products.keySet()) {
            totalTradeValue += (pdt.getCurrentPrice() * products.get(pdt));
        }
        return totalTradeValue;
    }
}
