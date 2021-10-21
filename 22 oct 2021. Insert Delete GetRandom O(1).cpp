class RandomizedSet {
public:
    /** Initialize your data structure here. */
    unordered_map<int,int>mp;
    vector<int>v;
    RandomizedSet()
    {
    }
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    bool insert(int val)
    {
     if(mp.find(val)!=mp.end())
      return false;
     v.push_back(val);
     mp[val]=v.size()-1;
     return true;
    } 
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    bool remove(int val)
    {
        if(mp.find(val)==mp.end())
          return false;
        auto it=mp.find(val);
        v[it->second]=v.back();
        v.pop_back();
        mp[v[it->second]]=it->second;
        mp.erase(val);
        return true;
    }
    /** Get a random element from the set. */
    int getRandom()
    {
        return v[rand()%v.size()];
    }
};
