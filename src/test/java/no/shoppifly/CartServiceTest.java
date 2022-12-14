package no.shoppifly;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {

    @Test
    public void shouldRemoveCartAfterCheckout() {

        CartService service = new NaiveCartImpl();
        Cart theCart = Cart.builder().build();
        service.update(theCart);
        assertEquals(1, service.getAllCarts().size());
        String orderId = service.checkout(theCart);
        assertNotNull(orderId);

        // Jim; This must be wrong, right? Shouldn't the cart be removed after
        //Set from 100 to 0
        assertEquals(0, service.getAllCarts().size());
    }

}
