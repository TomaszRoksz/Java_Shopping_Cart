class PercentageDiscount extends Discount{
    private final double percentage;
    private final double condition;

    public PercentageDiscount(double percentage, double condition) {
        this.percentage = percentage;
        this.condition = condition;
    }

    @Override
    boolean canExecute(ShoppingCart myCart){
        return myCart.getTotalPrice() > condition;
    }
    @Override
    void Execute (ShoppingCart myCart){
        if(canExecute(myCart)){
            for(Product product : myCart.cart){
                product.discountPrice *= (1-percentage);
            }
        }
    }
}
