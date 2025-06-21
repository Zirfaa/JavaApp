package gempaloka.Model;

public class Gemodel {
    private int id;
    private String nama;
    private String alamat;
    private String provinsi;

    public Gemodel(int id, String nama, String alamat,String provinsi) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.provinsi = provinsi;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }
    
    // Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
