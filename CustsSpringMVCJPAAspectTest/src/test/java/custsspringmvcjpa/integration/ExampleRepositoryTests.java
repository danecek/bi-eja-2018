/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvcjpa.integration;

import custsspringmvcjpa.model.Cust;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ExampleRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CustsDAO custsDAO;

    @Test
    public void testExample() throws Exception {
        custsDAO.save(new Cust("Tom"));
        entityManager.flush();
        assertThat(custsDAO.count() == 2);
    }

}
