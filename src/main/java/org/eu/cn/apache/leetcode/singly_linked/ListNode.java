package org.eu.cn.apache.leetcode.singly_linked;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adonis lau
 * @email adonis.lau.dev@gmail.com
 * @date 2023/8/14 13:48
 */
public class ListNode {
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
