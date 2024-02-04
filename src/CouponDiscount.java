class CouponDiscount extends Discount{
    private final double couponPercentage;
    private final Product couponProduct;

    public CouponDiscount(double couponPercentage, Product couponProduct) {
        this.couponPercentage = couponPercentage;
        this.couponProduct = couponProduct;
    }

    @Override
    boolean canExecute(ShoppingCart myCart){
        return myCart.containsProduct(couponProduct);
    }
    @Override
    void Execute (ShoppingCart myCart){
        if(canExecute(myCart)){
            couponProduct.discountPrice *= (1-couponPercentage);
            }
        }
    }

