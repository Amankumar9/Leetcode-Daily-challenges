import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        Node[] nodes=new Node[map.size()];
        int i=0;
        for(Character c: map.keySet()){
             nodes[i++]=new Node(c, map.get(c));
        }

        Arrays.sort(nodes, (a, b)->b.count-a.count);
        StringBuilder str=new StringBuilder();
        for(Node node:nodes){
            int count=node.count;
            while(count-->0){
                str.append(node.c);
            }
        }

        return str.toString();

    }

    class Node{
        Character c; int count;
        Node(Character c, int count){
            this.c=c;
            this.count=count;
        }
    }
}