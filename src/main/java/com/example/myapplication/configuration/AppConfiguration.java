package com.example.myapplication.configuration;

import com.example.myapplication.service.CarVehicleService;
import com.example.myapplication.service.PlaneVehicleService;
import com.example.myapplication.service.VehicleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
/*
<beans>
    <bean name="carVehicleServiceConfiguration" class="com.example.myapplication.service.CarVehicleService"/>
    <bean name="planeVehicleServiceConfiguration" class="com.example.myapplication.service.PlaneVehicleService"/>
</beans>
Lê-se:
- bean denominado carVehicleServiceConfiguration disponível no BeanFactory/ApplicationContext,
  vinculado a uma instância de objeto do tipo CarVehicleService.
- bean denominado planeVehicleServiceConfiguration disponível no BeanFactory/ApplicationContext,
  vinculado a uma instância de objeto do tipo PlaneVehicleService.
*/


/*@Configuration => indica que a classe será usada pelo JavaConfig
 como uma fonte de definições de bean.
 - Em uma aplicação podem existir uma ou mais classes anotadas com o @configuration
 - @Configuration pode ser entendido como o elemento <beans /> do XML.
 - Da mesma maneira que o <beans />, ele provê um maneira de definir explicitamente
   os padrões para todas as definições de bean inclusas.
 */
@Configuration
public class AppConfiguration {

    /*@Bean pode ser entendido como o elemento <bean/> do XML.
    Quando o JavaConfig encontra esse método, ele o executa e registra o valor de retorno
    como um bean dentro de uma BeanFactory. Por default, o nome do bean será o nome do método
    */
    @Bean
  //@Qualifier("carVehicleServiceConfiguration")
    @ConditionalOnProperty(value="vehicle.service.mode", havingValue="car", matchIfMissing = false)
    public VehicleService carVehicleServiceConfiguration(){
        return new CarVehicleService();
    }

    @Bean
    //@Primary
   // @Qualifier("planeVehicleServiceConfiguration")
    @ConditionalOnProperty(value="vehicle.service.mode", havingValue="plane", matchIfMissing = true)
    public VehicleService planeVehicleServiceConfiguration(){
        return new PlaneVehicleService();
    }
}
