class FreeCupDiscount extends Discount{
    private final double minimalPriceToGetCup;
    Product cup;
    public FreeCupDiscount(double minimalPriceToGetCup, Product cup) {
        this.minimalPriceToGetCup = minimalPriceToGetCup;
        this.cup = cup;
    }

    @Override
    boolean canExecute(ShoppingCart myCart){
        return myCart.getTotalPrice() > minimalPriceToGetCup;
    }
    @Override
    void Execute (ShoppingCart myCart){
        if(canExecute(myCart)){
            myCart.addToCart(cup);
            }
        }
}

