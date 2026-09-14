public class shu_ju_tuo_min {

    /**
     * 脱敏手机号：保留前3位和后4位，中间4位变为 ****
     * 例如：13112345678 -> 131****5678
     */
    public static String maskPhone(String phone) {
        if (phone == null || phone.length() != 11) {
            // 不符合预期长度时原样返回（也可抛出异常）
            return phone;
        }
        return phone.substring(0, 3) + "****" + phone.substring(7);
    }

    /**
     * 脱敏邮箱：保留邮箱名第一个字母，其余变为 ***，保留 @ 及之后的内容
     * 例如：zw1234@163.com -> z***@163.com
     */
    public static String maskEmail(String email) {
        if (email == null || !email.contains("@")) {
            return email;
        }
        int atIndex = email.indexOf('@');
        String localPart = email.substring(0, atIndex);   // @ 之前的部分
        String domain = email.substring(atIndex);          // @ 及之后的部分

        if (localPart.isEmpty()) {
            return email; // 没有邮箱名，无法脱敏
        }

        // 取第一个字符，固定加三个星号
        return localPart.charAt(0) + "***" + domain;
    }

    public static void main(String[] args) {
        // 测试手机号
        System.out.println(maskPhone("13112345678")); // 输出：131****5678
        // 测试邮箱
        System.out.println(maskEmail("zw1234@163.com")); // 输出：z***@163.com
        System.out.println(maskEmail("z@163.com"));      // 输出：z***@163.com
        System.out.println(maskEmail("abcdefg@gmail.com")); // 输出：a***@gmail.com
    }
}
