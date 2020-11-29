package pentalog.hack.controller;

public class PackageClass {
    private static final String PACKAGE_ACCESS_KEY = "package.access";
    static {
        String packageAccess = java.security.Security.getProperty(
                PACKAGE_ACCESS_KEY
        );
        java.security.Security.setProperty(
                PACKAGE_ACCESS_KEY,
                (
                        (packageAccess == null ||
                                packageAccess.trim().isEmpty()) ?
                                "" :
                                (packageAccess + ",")
                ) +
                        "xx.example.product.implementation."
        );
    }

    public static void main(String[] args) {
        String packageAccess = java.security.Security.getProperty(
                PACKAGE_ACCESS_KEY
        );
        System.out.println(packageAccess);
        System.out.println(PackageClass.class.getClassLoader());
        ;

        System.out.println(0.01+0.09);
        System.out.println(0.01 + 0.09 == 0.1);
    }
}
