package kdevelop.metier;

import kdevelop.dao.IDao;

public class MetierImpl implements IMetier {
    public IDao dao;

    @Override
    public double calcul_temperature() {
        double temperature = dao.getTemperature();
        return temperature;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
