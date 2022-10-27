package HashMap;
public class 手写HashMap {
    public static void main(String[] args) {
    }
}


class  HashMap <K, V>{
//    //初始容量大小
//    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
//
//    //最大容量大小
//    static final int MAXIMUM_CAPACITY = 1 << 30;
//
//
//    //加载因子
//    static final float DEFAULT_LOAD_FACTOR = 0.75f;



    //加载因子这块供外部传入
    final float loadFactor;
    //初始容量也供外部传入吧
    int initialCapacity;

     //HashMap中现在有的结点数量
     int Size;
     Node<K, V>[] table = null;

     public HashMap(int initialCapacity, float loadFactor) {
         this.loadFactor = loadFactor;
         this.initialCapacity = initialCapacity;
         table = new Node[initialCapacity];
     }

     public void resize(int kuorongSize) {}

     public V put(K key, V value) {
         //返回旧值
         V oldValue = null;
         if(Size > this.loadFactor * this.initialCapacity) {
             resize(2 * initialCapacity);
         }
         //int index = key.hashCode() % initialCapacity;
         int index = key.hashCode() & (initialCapacity - 1);

         if(table[index] == null) {
             table[index] = new Node<>(key, value, null);
         } else {
             Node<K, V> head = table[index];
             Node<K, V> cur = head;
             while(cur != null) {
                 if(cur.key == key || cur.value.equals(value)) {
                     oldValue = cur.value;
                     cur.value = value;
                     return oldValue;
                 }
                 cur = cur.next;
             }
             table[index] = new Node<K, V>(key, value, head);
         }

         ++Size;
         return oldValue;
     }

     public V get(K key) {
         int index = key.hashCode() & (initialCapacity - 1);
         Node<K, V> cur = table[index];
         while (cur != null) {
             if(cur.key == key || cur.value.equals(key)) {
                 return cur.value;
             }
             cur = cur.next;
         }
         return null;
     }
}


class  Node<K,V> {

    K key;
    V value;
    Node<K, V> next;
    public Node(K key, V value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

}

