/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvcjdbc.integration;

import custsspringmvcjdbc.model.Cust;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustsDAOImpl implements CustsDAO {

    @Autowired
    JdbcTemplate jdbct;

    @Override
    public void add(String name) {
        jdbct.update("insert into custs values(default, ?1)", name);

    }

    @Override
    public List<Cust> all() {
        return jdbct.query("select * from custs", new RowMapper<Cust>() {
            @Override
            public Cust mapRow(ResultSet rs, int i) throws SQLException {
                return new Cust(rs.getInt(1), rs.getString(2));
            }
        });
    }

    @PostConstruct
    void init() {
////        jdbct.execute("DROP TABLE custs IF EXISTS");
// //       jdbct.execute("CREATE TABLE custs (ID int NOT NULL AUTO_INCREMENT, " +
//                      "        name varchar(255) NOT NULL, " +
//                          "    PRIMARY KEY (ID))");
//        jdbct.update("INSERT INTO custs VALUES (default, 'Tom')");

    }

}
