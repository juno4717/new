import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class cache {
    public HashMap<String,Object> map = new HashMap<>();
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    public void read(Integer i){
        rwl.readLock().lock();
        System.out.println("模拟缓存读");

        try {
            TimeUnit.MILLISECONDS.sleep(300);
            Object o = map.get(i+"");
            System.out.println("读出缓存内的数字:"+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
            rwl.readLock().unlock();
        }
        rwl.readLock().unlock();
    }

    public void add(Integer i,Object obj){
        rwl.writeLock().lock();
        System.out.println("模拟缓存写");

        try {
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(i+"",obj);
            System.out.println("修改缓存完毕");

        } catch (InterruptedException e) {
            e.printStackTrace();
            rwl.writeLock().unlock();
        }
        rwl.writeLock().unlock();
    }

}
