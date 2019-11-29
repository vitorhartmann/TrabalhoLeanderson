package jdbc;

import mvc.model.CarroModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO extends BasicoDAO {

    public void insert(CarroModel carro) {

        String sql = " insert into carro(marca, modelo, cor, anomodelo) values(?,?,?,?)";

        // Implementar chassi, se não der merda na formatação
      //  String sql = " insert into carro(marca, modelo, cor, anomodelo, chassi) values(?,?,?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, carro.getMarca());
            statement.setString(2, carro.getModelo());
            statement.setString(3, carro.getCor());
            statement.setInt(4, carro.getAnomodelo());
            statement.execute();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                long id = rs.getLong(1);
                carro.setId(id);
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(CarroModel carro) {

        String sql = " delete from carro where id = ?";

        try(Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, carro.getId());
            statement.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update(CarroModel carro) {
        String sql = " update carro set marca = ?, modelo = ?, cor = ?, anomodelo = ? where id = ?";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, carro.getMarca());
            statement.setString(2, carro.getModelo());
            statement.setString(3, carro.getCor());
            statement.setInt(4, carro.getAnomodelo());
            statement.setLong(5, carro.getId());
            statement.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public CarroModel getByMarca(int marca) {
        CarroModel carro = null;
        String sql = " select marca, modelo, cor, anomodelo from CarroModel where marca = ?";

        try(Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, String.valueOf(marca));
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                carro = new CarroModel();
                carro.setMarca(resultSet.getString(1));
                carro.setModelo(resultSet.getString(2));
                carro.setCor(resultSet.getString(3));
                carro.setAnomodelo(resultSet.getInt(4));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return carro;
    }

    public List<CarroModel> getAll(){
        List<CarroModel> list = new ArrayList<>();
        String sql = " select marca, modelo, cor, anomodelo from CarroModel order by marca";

        try(Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                CarroModel carro = new CarroModel();
                carro.setMarca(resultSet.getString(1));
                carro.setModelo(resultSet.getString(2));
                carro.setCor(resultSet.getString(3));;
                carro.setAnomodelo(resultSet.getInt(4));


                list.add(carro);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
