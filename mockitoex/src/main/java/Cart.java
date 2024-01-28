import java.util.HashMap;
import java.util.Iterator;

public class Cart {
    HashMap h = new HashMap<String, Integer>();
    PriceManager pm;

    public void put(String id) {
        if (h.containsKey(id)) {
            int n=(Integer) h.get(id);
            h.put(id, n+1);
        } else h.put(id, 1);
    }

    public void setPriceManager(PriceManager pm) {
        this.pm = pm;
    }

//    public int totalPrice() {
//        Iterator itr = h.keySet().iterator();
//        int total = 0;
//        while (itr.hasNext()) {
//            String id = (String) itr.next();
//            int itmNum = (Integer) h.get(id);
//            total += pm.getPrice(id) * itmNum;
//        }
//        return total;
//    }

    public int totalPrice() {
        Iterator itr = h.keySet().iterator();
        int total = 0;
        while (itr.hasNext()) {
            String id = (String) itr.next();
            int itmNum = (Integer) h.get(id);
            if (pm.isTwoPlusOneApplicable(id)) {
                int itmNum1 = itmNum/3*2;
                itmNum = itmNum1+(itmNum%3);
            }
           total += pm.getPrice(id)*itmNum;
        }
        return total;
    }
}