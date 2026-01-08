package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.*;
import modele.DescriptionFormation;

public class FormationService {
	
	private String url = "jdbc:mysql://localhost:3306/centre_formation";
    private String user = "root";
    private String pass = "fms2025";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    /**
     * <p>Check all of the Formations in the database
     * </p>
     * @param no parameter, it takes all of the c_product table content
     * @return List<DescriptionFormation> formations -> list of all elements in the table c_product
     */
    public List<DescriptionFormation> checkAllFormations() throws Exception {
        String query = "SELECT * FROM c_product";
        List<DescriptionFormation> formations = new ArrayList<>();

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DescriptionFormation formation = new DescriptionFormation(
                    rs.getString("p_name"),
                    rs.getString("p_description"),
                    rs.getInt("p_length"),
                    rs.getString("p_workplace"),
                    rs.getDouble("p_price")
                );

                formations.add(formation);
            }
        }

        if (formations.isEmpty()) {
            throw new NoProductException();
        }

        return formations;
    }

    /**
     * <p>Check formation by "workplace" type, ask the user for options
     * </p>
     * @param String keyword -> Take String as parameter and only display when it's Distance or Présentiel
     * @return List<DescriptionFormation> formations -> list of all elements in the table where the column "p_workplace" contains the user's choice : Distance or Présentiel
     */
    
    //Same exception as the checkAllFormation : either there are courses or not
    public List<DescriptionFormation> checkFormationWorkplace(String workplace) throws Exception {
        String query = "SELECT * FROM c_product WHERE p_workplace = ?";
        List<DescriptionFormation> formations = new ArrayList<>();

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // parameter of the sql command "?"
            ps.setString(1, workplace);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DescriptionFormation formation = new DescriptionFormation(
                        rs.getString("p_name"),
                        rs.getString("p_description"),
                        rs.getInt("p_length"),
                        rs.getString("p_workplace"),
                        rs.getDouble("p_price")
                    );

                    formations.add(formation);
                }
            }
        }
        //exception when the returned list is empty
        if (formations.isEmpty()) {
            throw new NoProductException();
        }

        return formations;
    }
    
    //
    
    /**
     * <p>This function is used to find Formation based on keywords in the description 
     * </p>
     * @param String keyword -> needs to be a string in this situation 
     * and will be used to search in the database if the Description contains the keyword
     * @return List<DescriptionFormation> formations -> list of all elements where the Description(p_description) contains the keyword
     */
    public List<DescriptionFormation> checkFormationKeyword(String keyword) throws Exception {
        String query = "SELECT * FROM c_product WHERE p_description LIKE  ?";
        List<DescriptionFormation> formations = new ArrayList<>();

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // parameter of the sql command "?"
        	// We need the % to find texts that contain the keyword string
            ps.setString(1, "%" + keyword + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DescriptionFormation formation = new DescriptionFormation(
                        rs.getString("p_name"),
                        rs.getString("p_description"),
                        rs.getInt("p_length"),
                        rs.getString("p_workplace"),
                        rs.getDouble("p_price")
                    );

                    formations.add(formation);
                }
            }
        }
        //exception when the returned list is empty
        if (formations.isEmpty()) {
            throw new NoProductException();
        }

        return formations;
    }



   

}
