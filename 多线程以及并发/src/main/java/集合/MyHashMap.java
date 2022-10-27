package 集合;

public class MyHashMap<K,V> implements Map<K,V> {


    //默认初始化容量
    final static int DEFAULT_CAPACITY = 16;
    //默认加载因子
    final static float DEFAULT_LOAD_FACTOR = 0.75f;

    //容量
    int capacity;
    //加载因子
    float loadFactor;

    //数组
    Node<K,V>[] table;

    //哈希表的所有结点
    int size;

    public MyHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }


    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }


    @Override
    public V put(K k, V v) {


        int index = k.hashCode() % table.length;
        Node<K,V> current = table[index];

        if(current == null) {
            //如果table[index] 为null,直接赋值
            table[index] = new Node<K,V>(k,v,null);
            size++;
        }else {
            //遍历链表
            while (current != null) {
                if(current.k == k) {
                   V oldValue = current.v;
                   //新value覆盖旧value
                   current.v = v;
                   return oldValue;
                }
                current = current.next;
            }

            //如果链表没有相同的key就头插
            //右边的table[index] 是旧的第一个结点，当前结点插入这个旧的结点前面
            table[index] = new Node<K,V>(k,v,table[index]);
            size++;
            return null;
         }
        return null;
    }

    @Override
    public V get(K k) {
        int index = k.hashCode() % table.length;

        Node<K,V> current = table[index];

       while (current != null) {
           if(current.k == k) {
               return current.v;
           }
           current = current.next;
       }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V remove(K k) {
        int index = k.hashCode() % table.length;
        Node<K,V> current = table[index];
         //如果直接匹配第一个结点
        if(current.k == k && current.next == null) {
            table[index] = null;
            size--;
            return current.v;
        }

        //在链表中删除结点
        while (current.next != null) {
            if(current.next.k == k) {
                V oldValue = current.next.v;
                current.next = current.next.next;
                size--;
                return oldValue;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {

    }
}

class Node<K,V> {
    K k;
    V v;
    Node<K,V> next;
    public Node(K k,V v, Node<K,V> next) {
        this.k = k;
        this.v = v;
        this.next = next;
    }
}

