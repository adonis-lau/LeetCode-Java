package org.eu.cn.apache.leetcode.singly_linked;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 203. 移除链表元素
 * English Version
 * <p>
 * 题目描述
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
class Remove_Linked_List_Elements {

    public static void main(String[] args) {
        int[] values = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        ListNode listNode = ListNode.genListNode(values);
        listNode = removeElements(listNode, val);
        ListNode.printListNode(listNode);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }
}

class ListNode {
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

    public static ListNode genListNode(int[] values) {
        ListNode startNode = null;
        ListNode indexNode = null;
        for (int value : values) {
            ListNode curr = new ListNode(value);
            if (startNode == null) {
                startNode = curr;
                indexNode = curr;
            }
            indexNode.next = curr;
            indexNode = curr;
        }

        if (indexNode != null) {
            indexNode.next = null;
        }
        return startNode;
    }

    public static void printListNode(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(JSON.toJSONString(list));
    }
}