private static ListNode merge(ListNode a, ListNode b) {
        ListNode result = null;
        ListNode head = null;
        while (a != null && b != null) {
            ListNode newNode;
            if (a.data < b.data) {
                newNode = new ListNode(a.data);
                a = a.next;
            } else {
                newNode = new ListNode(b.data);
                b = b.next;}
            if (head == null) {
                head = result = newNode;
            } else {
                result.next = newNode;
                result = result.next;}
        }
        while (a != null) { //a not empty but b is
            ListNode newNode = new ListNode(a.data);
            a = a.next;
            if (head == null) {
                head = result = newNode;
            } else {
                result.next = newNode;
                result = result.next;
            }
        }
        while (b != null) { //b not empty but a is
            ListNode newNode = new ListNode(b.data);
            b = b.next;

            if (head == null) {
                head = result = newNode;
            } else {
                result.next = newNode;
                result = result.next;
            }
        }
        return head;
    }

    private static class ListNode {
        int data;
        ListNode next;

        private ListNode(int data) {
            this.data = data;
        }
    }
	
	
	
int main(){
	int a[] = {1,2,3,3};
	int b[] = {2,3,3,4};
	int c[] = {1,2,2,2}
	for(int i=0;i<4;i++){
	for(int j=0;j<4;j++){
	for(int k=0;k<4;k++){
		n = a[i] + b[j] + c[k]
		if(n == 7){
			printf("[%d,%d,%d]",a[i],b[j],c[k])
		}
}}}}