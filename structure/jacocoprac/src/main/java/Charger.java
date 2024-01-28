public class Charger {
    public int phone_charge(int useTime) {
        int charge = 0;
        if (useTime > 0) {
            charge = 20000;
            if (useTime > 100) {
                if (useTime <= 200)
                    charge += (useTime - 100) * 300;
                else {
                    charge += (useTime - 200) * 100 + 30000;
                    if (charge > 60000)
                        charge *= 0.9;
                }
            }
        }
        return charge;
    }
}
