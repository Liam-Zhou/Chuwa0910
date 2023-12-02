package kechen.learn.c06_util_concurrent_locks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLearn {
    // 通过不断地尝试原子性地将变量值递增，并在成功时返回增加后的值。
    public int increamentAndGet(AtomicInteger var){
        int prev, next;
        do{
            prev = var.get();
            next = prev + 1;
            // 如果成功，说明增加操作完成；如果失败，继续循环直到成功为止
        }while (!var.compareAndSet(prev,next));  // 原子性地将变量的值从 prev 更新为 next
        return next;
    }
}

class IdGenerator{
    AtomicLong var = new AtomicLong(0);
    // 来获取下一个唯一的 ID
    public long getNextID(){
        return var.incrementAndGet();
    }
}
