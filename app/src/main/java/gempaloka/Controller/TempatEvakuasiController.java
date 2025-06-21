package gempaloka.Controller;

import gempaloka.Model.Gemodel;
import gempaloka.Model.TempatEvakuasiDAO;
import java.util.List;

public class TempatEvakuasiController {
    private final TempatEvakuasiDAO dao = new TempatEvakuasiDAO();

    public void tambah(String nama, String alamat,String provinsi) {
        dao.tambah(new Gemodel(0, nama, alamat,provinsi));
    }

    public void hapus(int id) {
        dao.hapus(id);
    }

    public List<Gemodel> getAll() {
        return dao.getAll();
    }
    public void update(Gemodel model) {
    new TempatEvakuasiDAO().update(model);
}
    public List<Gemodel> getByProvinsi(String provinsi) {
    return new TempatEvakuasiDAO().getByProvinsi(provinsi);
}

public List<String> getAllProvinsi() {
    return new TempatEvakuasiDAO().getAllProvinsi();
}

}
