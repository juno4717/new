public class mytest {
    public static void main(String[] args) {
        cache cache = new cache();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                cache.add(temp,temp);

            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                cache.read(temp);

            },String.valueOf(i)).start();
        }
    }
}
