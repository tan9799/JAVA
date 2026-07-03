public class Test {
    public static void main(String args[]) {
        //所有的枚举项，默认使用public static final修饰
        OrderState o1 = OrderState.PAYMENT_PENDING;
        System.out.println(o1.getName());
        switch(o1) {
            case PAYMENT_PENDING -> System.out.println("待支付状态");
            case PROCESSING -> System.out.println("处理中状态");
            case OUT_FOR_DELIVERY -> System.out.println("配送中状态");
            case DELIVERED -> System.out.println("已送达状态");
            case CANCELLED -> System.out.println("已取消状态");
            default -> System.out.println("无效状态");
        }
    }
}
