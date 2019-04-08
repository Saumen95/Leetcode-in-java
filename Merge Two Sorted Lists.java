    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;

        ListNode resultHead;
        if(l1.val<l2.val){
            resultHead=l1;
            resultHead.next=mergeTwoLists(l1.next,l2);
        }else{
            resultHead=l2;
            resultHead.next=mergeTwoLists(l1,l2.next);
        }
        return resultHead;
    }
