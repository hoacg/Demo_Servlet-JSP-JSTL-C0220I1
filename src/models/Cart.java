package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<CartItem> cartItemList = new ArrayList<>();

    public void addItem(CartItem item) {

        for (CartItem _item :  cartItemList) {
            int id = _item.getProduct().getId();
            if (id == item.getProduct().getId()) {
                increaseQuantityByProductId(id);
                return;
            }
        }
        this.cartItemList.add(item);
    }

    private void increaseQuantityByProductId(int productId) {
        for (CartItem item :
                cartItemList) {
            if (item.getProduct().getId() == productId) {
                item.setQuantity(item.getQuantity()+1);
            }
        }
    }

    public void deleteItemByProductId(int productId) {
        for (CartItem item : cartItemList) {
            if (item.getProduct().getId() == productId) {
                cartItemList.remove(item);
            }
        }
    }

    public List<CartItem> getCartItemList() {
        return this.cartItemList;
    }

}
