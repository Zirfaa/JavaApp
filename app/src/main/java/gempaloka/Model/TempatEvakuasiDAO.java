package gempaloka.Model;

import gempaloka.Config.Connectiondb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TempatEvakuasiDAO {

    public void tambah(Gemodel t) {
        String sql = "INSERT INTO tempat (nama, alamat,provinsi) VALUES (?, ?, ?)";
        try (Connection conn = Connectiondb.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, t.getNama());
            stmt.setString(2, t.getAlamat());
            stmt.setString(3, t.getProvinsi());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Gemodel t) {
        String sql = "UPDATE tempat SET nama = ?, alamat = ?, provinsi = ? WHERE id = ?";
        try (Connection conn = Connectiondb.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, t.getNama());
            stmt.setString(2, t.getAlamat());
            stmt.setString(3, t.getProvinsi());
            stmt.setInt(4, t.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void hapus(int id) {
        String sql = "DELETE FROM tempat WHERE id = ?";
        try (Connection conn = Connectiondb.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Gemodel> getAll() {
        List<Gemodel> list = new ArrayList<>();
        String sql = "SELECT * FROM tempat";
        try (Connection conn = Connectiondb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Gemodel t = new Gemodel(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("provinsi")
                );
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<String> getAllProvinsi() {
    List<String> list = new ArrayList<>();
    String sql = "SELECT DISTINCT provinsi FROM tempat ORDER BY provinsi";
    try (Connection conn = Connectiondb.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            list.add(rs.getString("provinsi"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
public List<Gemodel> getByProvinsi(String provinsi) {
    List<Gemodel> list = new ArrayList<>();
    String sql = "SELECT * FROM tempat WHERE provinsi = ?";
    try (Connection conn = Connectiondb.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, provinsi);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Gemodel t = new Gemodel(
                rs.getInt("id"),
                rs.getString("nama"),
                rs.getString("alamat"),
                rs.getString("provinsi")
            );
            list.add(t);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

}
