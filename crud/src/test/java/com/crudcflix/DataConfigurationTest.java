package com.crudcflix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootTest
public class DataConfigurationTest {

    DataConfiguration dataConfiguration;

//    @Test
//    public void dataSourceTest(){
//
//        DriverManagerDataSource dataSource;
//        dataConfiguration = new DataConfiguration();
//        dataSource = dataConfiguration.dataSource();
//        Assertions.assertNotNull(dataSource);
//
//        Exception exception = Assertions.assertThrows(dataConfiguration, () -> {
//
//        });
//
//    }

//    @Test
//   public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
//        GenericEntity genericEntity = genericEntityRepository
//                .save(new GenericEntity("test"));
//        GenericEntity foundEntity = genericEntityRepository
//                .findOne(genericEntity.getId());
//
//        assertNotNull(foundEntity);
//        assertEquals(genericEntity.getValue(), foundEntity.getValue());
//    }

}
