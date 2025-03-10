class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, String> owner = new HashMap<>();    // key: e-mail value: name -> records which user it belongs to.
            Map<String, String> parent = new HashMap<>();   // key: email value: email
            Map<String, TreeSet<String>> uf = new HashMap<>();
            // Step 1: Initialization
            for(List<String> account : accounts){
                for(int i = 1; i < account.size(); i++){
                    parent.put(account.get(i), account.get(i)); // each e-mails was initialized to point to themselves.
                    owner.put(account.get(i), account.get(0));  // set onwer of each e-mail.
                }
            }
            // Step 2: Merge each lines
            for(List<String> account : accounts){
                String root = find(account.get(1), parent); // find the root e-mail for the first email and this one will be the root for this account.
                for(int i = 2; i < account.size(); i++){
                    parent.put(find(account.get(i), parent), root); // find root for rest e-mails and merge them to the root.
                }
            }
            // Step 3: Add to uf.(Actually merge different lines)
            for(List<String> account : accounts){
                String root = find(account.get(1), parent); //// find the root e-mail for the first email.
                if(!uf.containsKey(root)) uf.put(root, new TreeSet<String>());
                for(int i = 1; i < account.size(); i++)
                    uf.get(root).add(account.get(i)); // Add all emails in this account to uf.
            }
            // Step 4: Create result List.
            List<List<String>> result = new ArrayList<>();
            for(String key : uf.keySet()){
                List<String> temp = new ArrayList<>();
                temp.add(owner.get(uf.get(key).first()));   // first add the username.
                temp.addAll(uf.get(key)); // Add all emails to the list.
                result.add(temp);
            }
            return result;
        }
        private String find(String s, Map<String, String> map){
            if(!map.get(s).equals(s)){
                map.put(s, find(map.get(s), map));
            }
            return map.get(s);
        }
    }