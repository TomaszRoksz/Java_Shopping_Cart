class FreeProductDiscount extends Discount{
    private final double minProducts;

    public FreeProductDiscount(double minProducts) {
        this.minProducts = minProducts;
    }

    @Override
    boolean canExecute(ShoppingCart myCart){
        return myCart.cart.size() > minProducts;
    }
    @Override
    void Execute (ShoppingCart myCart){
        if(canExecute(myCart)){
            myCart.getCheapestProduct().discountPrice=0.0;
            }
        }
}

