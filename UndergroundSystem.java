class UndergroundSystem {

    Map<Integer,List<String>> inp;

    public UndergroundSystem() {
        inp = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        List<String> temp = new ArrayList<>();
        if(inp.containsKey(id)){
            temp = inp.get(id);
        }
        temp.add(stationName);
        temp.add(t + "");
        inp.put(id, temp);
    }
    
    public void checkOut(int id, String stationName, int t) {
        List<String> temp = inp.get(id);
        temp.add(t+"");
        temp.add(stationName);
        inp.put(id,temp);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<Integer> temp = new ArrayList<>();

        for(List<String> list : inp.values()){
            
            for(int i=0; i<list.size(); i=i+4){
                if(list.get(i).equals(startStation)){
                    if(i+3<list.size() && list.get(i+3).equals(endStation)){
                        int a = Integer.parseInt(list.get(i+1));
                        int b = Integer.parseInt(list.get(i+2));
                        temp.add(b-a);
                    }
                }
            }
        }

        double sum = 0;
        for(int p : temp){
            sum += p;
        }
        double out = sum/temp.size();
        return out;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
