package LinkedList;

public class LinkedList {
//    private static LinkedList.LinkedList.Node head;
    //    private static LinkedList.LinkedList.Node current;
    public static Node head;
    public static Node current;

    class Node {
        //注：此处的两个成员变量权限不能为private，因为private的权限是仅对本类访问。
        int data; //数据域
        Node next;//指针域

        public Node(int data) {
            this.data = data;
        }
    }

    //方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
    public void print(Node node) {
        if (node == null) {
            return;
        }

        current = node;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    //方法：向链表中添加数据
    public void add(int data) {
        //判断链表为空的时候
        if (head == null) {//如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
            head = new Node(data);
            current = head;
        } else {
            //创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
            current.next = new Node(data);
            //把链表的当前索引向后移动一位
            current = current.next; //此步操作完成之后，current结点指向新添加的那个结点
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        //向LinkList中添加数据
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

//        list.print(list.head);// 从head节点开始遍历输出
        System.out.println(findLastNode(4));
    }

    /**
     * 查找单链表中的倒数第k个结点
     * 先将整个链表从头到尾遍历一次，计算出链表的长度size，
     * 输出第(size-k)个节点就可以了,注意链表为空，k为0，k为1，k大于链表中节点个数时的情况
     */
    public static int findLastNode(int index) { //index代表的是倒数第index的那个结点
        int size = 0;
        //第一次遍历，得到链表的长度size
        if (head == null) {
            return -1;
        }

        current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        //第二次遍历，输出倒数第index个结点的数据
        current = head;
        for (int i = 0; i < size - index; i++) {
            current = current.next;
        }

        return current.data;
    }
}
