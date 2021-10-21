import java.util.*;

class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        map=new HashMap<Integer, Integer>();
        list=new ArrayList<Integer>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        list.set(index, list.get(list.size()-1));
        map.put(list.get(list.size()-1), index);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    public int getRandom() {
        int randomIndex = (int)(Math.random()*list.size());
        return list.get(randomIndex);
    }
}
