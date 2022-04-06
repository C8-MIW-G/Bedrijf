package database;

import model.Afdeling;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Schrijft en leest afdelingen van en naar de database
 */
public class AfdelingDAO {
    private DBaccess dBaccess;

    public AfdelingDAO(DBaccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public void slaAfdelingOp(Afdeling afdeling) {
        String sql = "INSERT INTO afdeling VALUES (?, ?);";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, afdeling.getAfdelingsNaam());
            preparedStatement.setString(2, afdeling.getAfdelingsPlaats());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("SQL fout: " + sqlException.getMessage());
        }
    }

    public ArrayList<Afdeling> geefAfdelingen() {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();
        String sql = "SELECT afdelingsnaam, afdelingsplaats FROM afdeling;";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String afdelingsNaam = resultSet.getString(1);
                String afdelingsPlaats = resultSet.getString(2);
                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));
            }
        } catch (SQLException sqlException) {
            System.out.println("SQL fout: " + sqlException.getMessage());
        }

        return afdelingen;
    }

    public ArrayList<Afdeling> geefAfdelingenMetPlaats(String afdelingsPlaats) {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();
        String sql = "SELECT afdelingsnaam FROM afdeling WHERE afdelingsplaats = ?;";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, afdelingsPlaats);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String afdelingsNaam = resultSet.getString(1);
                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));
            }
        } catch (SQLException sqlException) {
            System.out.println("SQL fout: " + sqlException.getMessage());
        }

        return afdelingen;
    }
}
