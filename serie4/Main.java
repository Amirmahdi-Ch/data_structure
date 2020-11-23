public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(7);
        linkedList.insert(2);
        linkedList.insert(4);
        linkedList.insert(3);
        LinkedList linkedList2 = new LinkedList();
        linkedList2.insert(5);
        linkedList2.insert(6);
        linkedList2.insert(4);
        //LinkedList.ListNode delete = linkedList.delete(linkedList.head, 1);
        //linkedList.print(delete);
       // LinkedList.ListNode head = linkedList.changeOrder(linkedList.head);
        //linkedList.print(head);
        LinkedList.ListNode sum = linkedList.addTwoLists(linkedList.head, linkedList2.head);
        linkedList.print(sum);


    }
}
class LinkedList {

     ListNode head;
    private ListNode left;
    static class ListNode{
        private int val;
        private ListNode next;

        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return ""+val;
        }
    }
    public boolean isEmpty(){
        return (head==null)?true : false;
    }
    public void insert(int key){
        ListNode node = new ListNode(key);
        node.next = null;
        if (isEmpty()){
            head = node;
        }
        else {
            ListNode l = head;
            while (l.next!=null){
                l = l.next;
            }
            l.next = node;
        }
    }

    public void print(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    // question 1
    public  ListNode delete(ListNode l,int v){
        ListNode currNode = l, prev = null;


            while (currNode != null) {
                if (l != null && l.val == v) {
                    l = currNode.next; // Changed head
                    currNode = l;

                }
                else {
                    if (currNode.val == v) {
                        prev.next = currNode.next;
                        currNode = currNode.next;
                    } else {
                        prev = currNode;
                        currNode = currNode.next;
                    }
                }
            }

        return l;
    }

    // question 2 without extra memory
    // recursive solution

    boolean isPalindromeUtil(ListNode right)
    {
        left = head;

        if (right == null)
            return true;

        boolean isp = isPalindromeUtil(right.next);
        if (isp == false)
            return false;

        boolean isp1 = (right.val == (left).val);

        left = left.next;

        return isp1;
    }

    public boolean isPalindrome(ListNode head)
    {
        boolean result = isPalindromeUtil(head);
        return result;
    }

    //  problem 3
    public ListNode reverse(ListNode head)
    {
        // check is last or not
        if (head == null || head.next == null)
            return head;


        ListNode rest = reverse(head.next);
        head.next.next = head;

        head.next = null;

        return rest;
    }

    // problem 4
    public ListNode changeOrder(ListNode head){

        ListNode end = head;
        ListNode prev = null;
        ListNode curr = head;

        /* Get pointer to last Node */
        while (end.next != null) {
            end = end.next;
        }
        if (head != null && head.val%2==0) {
            head = curr.next; // Changed head
            curr = head;

        }

        ListNode new_end = end;

        // Consider all odd nodes before getting first eve node
        while (curr != end)
        {
            if (head != null && head.val%2==0) {
                head = curr.next; // Changed head
                curr = head;

            }
            if(curr.val%2==0) {
                new_end.next = curr;
                prev.next= curr.next;
                curr=curr.next;
                new_end.next.next = null;
                new_end = new_end.next;
            }
            else {
                prev = curr;
                curr = curr.next;
            }

        }
        return head;
    }
    public ListNode addTwoLists(ListNode first, ListNode second)
    {
        first = reverse(first);
        System.out.println("first" + first.val);
        second = reverse(second);
        System.out.println("second" + second.val);
        ListNode headResult = null;
        ListNode prev = null;
        ListNode temp = null;
        int carry = 0, sum;

        // while both lists exist
        while (first != null || second != null) {

            sum = carry + (first != null ? first.val : 0)
                    + (second != null ? second.val : 0);

            // update carry for next calulation
            carry = (sum >= 10) ? 1 : 0;

            // update sum if it is greater than 10
            sum = sum % 10;

            // Create a new node with sum as data
            temp = new ListNode(sum);

            // if this is the first node then set
            // it as head of the resultant list
            if (headResult == null) {
                headResult = temp;
            }

            // If this is not the first
            // node then connect it to the rest.
            else {
                prev.next = temp;
            }

            // Set prev for next insertion
            prev = temp;

            // Move first and second pointers
            // to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        // return head of the resultant list
        return reverse(headResult);
    }



}