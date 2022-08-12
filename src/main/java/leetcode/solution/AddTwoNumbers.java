package leetcode.solution;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhihao.mao
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultListNode = new ListNode();
        ListNode currentListNode = resultListNode;
        boolean isNeedPlusOne = Boolean.FALSE;
        while (Boolean.TRUE) {
            int resultVal = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (isNeedPlusOne ? 1 : 0);
            isNeedPlusOne = resultVal / 10 > 0;
            currentListNode.val = resultVal % 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            if (l1 == null && l2 == null) {
                if (isNeedPlusOne) {
                    ListNode nextListNode = new ListNode();
                    nextListNode.val = 1;
                    currentListNode.next = nextListNode;
                }
                break;
            }
            ListNode nextListNode = new ListNode();
            currentListNode.next = nextListNode;
            currentListNode = nextListNode;
        }

        return resultListNode;
    }
}
