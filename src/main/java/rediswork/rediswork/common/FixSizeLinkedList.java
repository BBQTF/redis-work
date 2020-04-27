package rediswork.rediswork.common;

import java.util.LinkedList;

/**
 * 固定长度List
 * 如果List里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
 * @author liutf
 * @date 2020-03-05
 */
public class FixSizeLinkedList<T> extends LinkedList<T> {
    private static final long serialVersionUID = 3292612616231532364L;
    // 定义缓存的容量
    private int capacity;

    public FixSizeLinkedList(int capacity) {
        super();
        this.capacity = capacity;
    }

    /** 重新add方法，超过定长时，移除第一个元素**/
    @Override
    public boolean add(T e) {
        if (size() + 1 > capacity) {
            super.removeFirst();
        }
        return super.add(e);
    }
}
